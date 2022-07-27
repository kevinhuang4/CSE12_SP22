/** FileSystem represents the entire structure of the file system
 * It has two instance variables:
 * nameMap (uses file name as the key and a list of FileData as the value)
 * dateMap (uses last modified date as the key and a list of FileData as the value)
 * Both nameMap and dateMap implement MyHashMap
 * It includes basic methods such as add, findFile, findAllFilesName, 
 * findFilesByName, findFilesByDate, findFilesInMultDir, removeByName, 
 * and removeFile.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileSystem {

    MyHashMap<String, ArrayList<FileData>> nameMap;
    MyHashMap<String, ArrayList<FileData>> dateMap;

    // TODO
    /**
     * default constructor that initiate the fields
     */
    public FileSystem() {
        this.nameMap = new MyHashMap<>();
        this.dateMap = new MyHashMap<>();
    }

    // TODO
    /**
     * read all the files written in the inputFile into the FileSystem
     * 
     * @param inputFile the location of the input file to be read into the
     *                  FileSystem
     */
    public FileSystem(String inputFile) {
        // Add your code here
        this.nameMap = new MyHashMap<>();
        this.dateMap = new MyHashMap<>();
        try {
            File f = new File(inputFile);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(", ");
                // Add your code here
                this.add(data[0], data[1], data[2]);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    // TODO
    /**
     * Adds the new file into the FileSystem
     * 
     * @param fileName     The file name of the file
     * @param directory    The directory of the file
     * @param modifiedDate The modified date of the file
     * @return true if the file is added to the FileSystem
     */
    @SuppressWarnings("unchecked")
    public boolean add(String fileName, String directory, String modifiedDate) {
        if (fileName == null) {
            fileName = "";
        }
        if (directory == null) {
            directory = "/";
        }
        if (modifiedDate == null) {
            modifiedDate = "01/01/2021";
        }
        FileData data = new FileData(fileName, directory, modifiedDate);
        ArrayList<FileData> dataList = new ArrayList<>();
        dataList.add(data);
        if (this.nameMap.containsKey(fileName)) {
            for (FileData fData : this.nameMap.get(fileName)) {
                if (fData.hasSameDir(data)) {
                    return false;
                }
            }
            ArrayList<FileData> currentNameMap = (ArrayList<FileData>) this.nameMap.get(fileName).clone();
            currentNameMap.add(data);
            this.nameMap.replace(fileName, currentNameMap);
        } else {
            this.nameMap.put(fileName, dataList);
        }
        if (this.dateMap.containsKey(modifiedDate)) {
            ArrayList<FileData> currentDateMap = (ArrayList<FileData>) this.dateMap.get(modifiedDate).clone();
            currentDateMap.add(data);
            this.dateMap.replace(modifiedDate, currentDateMap);
        } else {
            this.dateMap.put(modifiedDate, dataList);
        }
        return true;
    }

    // TODO
    /**
     * Find the file in the FileSystem
     * 
     * @param name      The file name of the file
     * @param directory The directory of the file
     * @return the file if the file is present, null if it's not
     */
    public FileData findFile(String name, String directory) {
        if (!this.nameMap.containsKey(name)) {
            return null;
        }
        for (FileData fData : this.nameMap.get(name)) {
            if (fData.dir.equals(directory)) {
                return fData;
            }
        }
        return null;
    }

    // TODO
    /**
     * finds all file names in the FileSystem
     * 
     * @return an ArrayList of all file names in the FileSystem
     */
    public ArrayList<String> findAllFilesName() {
        return (ArrayList<String>) this.nameMap.keys();
    }

    // TODO
    /**
     * Finds all files that match the name
     * 
     * @param name The file name of the file
     * @return an ArrayList of all files in the FileSystem that match the name
     */
    public ArrayList<FileData> findFilesByName(String name) {
        if (!this.nameMap.containsKey(name)) {
            return new ArrayList<FileData>();
        }
        return this.nameMap.get(name);
    }

    // TODO
    /**
     * Finds all files that match the date
     * 
     * @param modifiedDate The modified date of the file
     * @return an ArrayList of all files in the FileSystem that match the modified
     *         date
     */
    public ArrayList<FileData> findFilesByDate(String modifiedDate) {
        if (!this.dateMap.containsKey(modifiedDate)) {
            return new ArrayList<FileData>();
        }
        return this.dateMap.get(modifiedDate);
    }

    // TODO
    /**
     * find all files with the given modifiedDate
     * that also have at least another file
     * with the same file name in a different directory
     * 
     * @param modifiedDate The modified date of the file
     * @return a list of FileData with the given modifiedDate
     *         that has at least another file
     *         with the same file name in a different directory
     */
    public ArrayList<FileData> findFilesInMultDir(String modifiedDate) {
        ArrayList<FileData> filesInMultiDir = new ArrayList<>();
        if (!this.dateMap.containsKey(modifiedDate)) {
            return filesInMultiDir;
        }
        for (FileData fData : this.dateMap.get(modifiedDate)) {
            if (this.nameMap.get(fData.name).size() > 1) {
                filesInMultiDir.add(fData);
            }
        }
        return filesInMultiDir;
    }

    // TODO
    /**
     * Removes all files that match the name
     * 
     * @param name The file name
     * @return true if all files that match the name are removed
     */
    @SuppressWarnings("unchecked")
    public boolean removeByName(String name) {
        if (!this.nameMap.containsKey(name)) {
            return false;
        }
        ArrayList<FileData> fileList = this.nameMap.get(name);
        ArrayList<String> dateList = new ArrayList<>();
        for (FileData file : fileList) {
            dateList.add(file.lastModifiedDate);
        }
        for (String date : dateList) {
            if (this.dateMap.get(date) != null) {
                ArrayList<FileData> dateEntries = (ArrayList<FileData>) this.dateMap.get(date).clone();
                if (dateEntries.size() == 1 && dateEntries.get(0).name.equals(name)) {
                    this.dateMap.remove(date);
                } else {
                    Iterator<FileData> iterator = dateEntries.iterator();
                    while (iterator.hasNext()) {
                        FileData file = iterator.next();
                        if (file.name.equals(name)) {
                            iterator.remove();
                        }
                    }
                    if (dateEntries.size() != 0) {
                        this.dateMap.replace(date, dateEntries);
                    } else {
                        this.dateMap.remove(date);
                    }
                }
            }
        }
        this.nameMap.remove(name);
        return true;
    }

    // TODO
    /**
     * Removes all files that match the name and the directory
     * 
     * @param name      The file name
     * @param directory The file directory
     * @return true if all files that match the name and the directory are removed
     */
    @SuppressWarnings("unchecked")
    public boolean removeFile(String name, String directory) {
        if (!this.nameMap.containsKey(name) || directory == null) {
            return false;
        }
        String date = null;
        ArrayList<FileData> fileNameList = this.nameMap.get(name);
        if (fileNameList.size() == 1 && fileNameList.get(0).dir.equals(directory)) {
            date = fileNameList.get(0).lastModifiedDate;
            this.nameMap.remove(name);
        } else {
            for (FileData fData : fileNameList) {
                if (fData.dir.equals(directory)) {
                    date = fData.lastModifiedDate;
                    ArrayList<FileData> currentNameMap = (ArrayList<FileData>) fileNameList.clone();
                    currentNameMap.remove(fData);
                    this.nameMap.replace(name, currentNameMap);
                }
            }
        }
        if (date == null) {
            return false;
        }
        ArrayList<FileData> fileDateList = this.dateMap.get(date);
        if (fileDateList.size() == 1
                && fileDateList.get(0).name.equals(name)
                && fileDateList.get(0).dir.equals(directory)) {
            this.dateMap.remove(date);
        } else {
            for (FileData fData : fileDateList) {
                if (fData.name.equals(name) && fData.dir.equals(directory)) {
                    ArrayList<FileData> currentDateMap = (ArrayList<FileData>) fileDateList.clone();
                    currentDateMap.remove(fData);
                    this.dateMap.replace(date, currentDateMap);
                }
            }
        }
        return true;
    }

}
