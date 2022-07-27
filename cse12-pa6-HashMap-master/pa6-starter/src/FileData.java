/** FileData is a class that instantiates objects that represent files.
 * It includes three fields: name, dir (directory), and lastModifiedDate.
 * It has its own toString() method.
 * It has hasSameDir() method that compares directories for two files.
 */

public class FileData {

    public String name;
    public String dir;
    public String lastModifiedDate;

    // TODO
    /**
     * initiates the object with the input values
     * 
     * @param name         the name of this file
     * @param directory    the directory of this file
     * @param modifiedDate the modified date of this file
     */
    public FileData(String name, String directory, String modifiedDate) {
        this.name = name;
        this.dir = directory;
        this.lastModifiedDate = modifiedDate;
    }

    /**
     * overwrite the default toString() method
     * 
     * @return a string that contains the file's name, directory, and modifiedDate
     */
    // TODO
    public String toString() {
        return "{Name: " + this.name + ", Directory: " + this.dir + ", Modified Date: " + this.lastModifiedDate + "}";
    }

    /**
     * check if this file and the input file have the same directory
     * 
     * @param file another file
     * @return true if this file and the input file have the same directory
     */
    public boolean hasSameDir(FileData file) {
        if (this.dir.equals(file.dir)) {
            return true;
        }
        return false;
    }
}
