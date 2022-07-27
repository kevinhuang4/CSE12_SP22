
/** FileSystem represents the entire structure of the file system
 * It has two instance variables:
 * nameTree (uses file name as the key and FileData as the value)
 * dateTree (uses last modified date as the key and a list of FileData as the value)
 * Both nameTree and dateTree implement BST
 * It includes basic methods such as add, findFileNamesByDate, filter,
 * outputNameTree, and outputDateTree.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Comparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileSystem {

    BST<String, FileData> nameTree;
    BST<String, ArrayList<FileData>> dateTree;

    /**
     * Default constructor that creates a new FileSystem object
     * and initializes its instance variables.
     */
    public FileSystem() {
        this.nameTree = new BST<>();
        this.dateTree = new BST<>();
    }

    /**
     * Constructor that creates a new FileSystem object with the given inputFile
     * that contains the file system information.
     * 
     * @param inputFile the input file to be read
     */
    public FileSystem(String inputFile) {
        this.nameTree = new BST<>();
        this.dateTree = new BST<>();
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

    /**
     * creates a FileData object with the given file information
     * and adds it to the instance variables of FileSystem
     * 
     * @param name the file name
     * @param dir  the file director
     * @param date the last modified date of the file
     */
    public void add(String name, String dir, String date) {
        if (name == null || dir == null | date == null) {
            return;
        }
        if (this.nameTree.containsKey(name)) {
            if (this.nameTree.get(name).lastModifiedDate.equals(date)) {
                return;
            }
            String oldDate = this.nameTree.get(name).lastModifiedDate;
            String oldDir = this.nameTree.get(name).dir;
            if (oldDate.compareTo(date) >= 0 && oldDir.compareTo(dir) == 0) {
                return;
            }
            this.updateNameTree(name, dir, date);
            this.removeFromDateTree(name, dir, oldDate);
            this.addToDateTree(name, dir, date);
            return;
        }
        this.addToNameTree(name, dir, date);
        this.addToDateTree(name, dir, date);
    }

    /**
     * assuming a file with the same name and an older date exists
     * updates nameTree with the newest file
     * 
     * @param name the file name
     * @param dir  the file director
     * @param date the last modified date of the file
     */
    private void updateNameTree(String name, String dir, String date) {
        FileData newData = new FileData(name, dir, date);
        this.nameTree.replace(name, newData);
    }

    /**
     * assuming a file with the same name and an older date exists
     * removes the older file from the dateTree
     * 
     * @param name    the file name
     * @param dir     the file director
     * @param oldDate the last modified date of the older file
     */
    @SuppressWarnings("unchecked")
    private void removeFromDateTree(String name, String dir, String oldDate) {
        ArrayList<FileData> oldDateList = (ArrayList<FileData>) this.dateTree.get(oldDate).clone();
        for (int i = 0; i < oldDateList.size(); i++) {
            if (oldDateList.get(i).name.equals(name)) {
                oldDateList.remove(oldDateList.get(i));
                break;
            }
        }
        // if (oldDateList.size() == 0) {
        // this.dateTree.remove(oldDate);
        // } else {
        this.dateTree.replace(oldDate, oldDateList);
        // }
    }

    /**
     * adds a file to dateTree
     * 
     * @param name the file name
     * @param dir  the file director
     * @param date the last modified date of the file
     */
    @SuppressWarnings("unchecked")
    private void addToDateTree(String name, String dir, String date) {
        FileData newData = new FileData(name, dir, date);
        if (!this.dateTree.containsKey(date)) {
            ArrayList<FileData> newDateList = new ArrayList<>();
            newDateList.add(newData);
            this.dateTree.put(date, newDateList);
        } else {
            ArrayList<FileData> currentDateList = (ArrayList<FileData>) this.dateTree.get(date).clone();
            currentDateList.add(newData);
            this.dateTree.replace(date, currentDateList);
        }
    }

    /**
     * assuming no file with the same name exists in nameTree
     * adds the file to nameTree
     * 
     * @param name the file name
     * @param dir  the file director
     * @param date the last modified date of the file
     */
    private void addToNameTree(String name, String dir, String date) {
        FileData newData = new FileData(name, dir, date);
        this.nameTree.put(name, newData);
    }

    /**
     * given a date, return an ArrayList of file names that correspond to this date
     * 
     * @param date the given date
     * @return an ArrayList of file names that correspond to this date
     */
    @SuppressWarnings("unchecked")
    public ArrayList<String> findFileNamesByDate(String date) {
        if (date == null) {
            return null;
        }
        ArrayList<String> namesByDate = new ArrayList<>();
        if (!this.dateTree.containsKey(date)) {
            return namesByDate;
        }
        ArrayList<FileData> filesByDate = (ArrayList<FileData>) this.dateTree.get(date).clone();
        for (FileData fData : filesByDate) {
            namesByDate.add(fData.name);
        }
        filesByDate = null;
        return namesByDate;
    }

    /**
     * given a startDate and an endDate, return a new FileSystem
     * that contains only the files that are within the range
     * startDate is inclusive, endDate is exclusive
     * 
     * @param startDate the start date
     * @param endDate   the end date
     * @return a new FileSystem that contains only the files that are within the
     *         range
     */
    @SuppressWarnings("unchecked")
    public FileSystem filter(String startDate, String endDate) {
        FileSystem filteredFileSystem = new FileSystem();
        if (startDate.compareTo(endDate) >= 0) {
            return filteredFileSystem;
        }
        ArrayList<FileData> filesByDate = new ArrayList<>();
        for (String date : this.dateTree.keys()) {
            int compToStart = date.compareTo(startDate);
            int compToEnd = date.compareTo(endDate);
            if (compToStart >= 0 && compToEnd < 0) {
                filesByDate = (ArrayList<FileData>) this.dateTree.get(date).clone();
                for (FileData fiData : filesByDate) {
                    filteredFileSystem.add(fiData.name, fiData.dir, fiData.lastModifiedDate);
                }
            }
        }
        return filteredFileSystem;
    }

    /**
     * Given a string wildCard
     * return a new FileSystem that contains only the files with names that contain
     * the wildCard string.
     * 
     * @param wildCard the wildCard string
     * @return a new FileSystem that contains only the files with names that contain
     *         the wildCard string.
     */
    public FileSystem filter(String wildCard) {
        FileSystem filteredFileSystem = new FileSystem();
        for (String name : this.nameTree.keys()) {
            if (name.contains(wildCard)) {
                FileData fData = this.nameTree.get(name);
                filteredFileSystem.add(fData.name, fData.dir, fData.lastModifiedDate);
            }
        }
        return filteredFileSystem;
    }

    /**
     * Returns a List that contains the nameTree
     * where each entry is formatted as: ": <FileData toString()>"
     * in alphabetical order
     * 
     * @return a List that contains the nameTree
     *         where each entry is formatted as: ": <FileData toString()>"
     */
    public List<String> outputNameTree() {
        return this.nameTree.toStringList();
    }

    // TODO
    public List<String> outputDateTree() {
        return this.dateTree.reversedToStringListForDateMap();
    }

}
