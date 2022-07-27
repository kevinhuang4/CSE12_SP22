/**
 * FileData is a class that instantiates objects that represent files.
 * It includes three fields: name, dir (directory), and lastModifiedDate.
 * It has its own toString() method.
 */

public class FileData {

    public String name;
    public String dir;
    public String lastModifiedDate;

    /**
     * FileData constructor
     * sets the fields according to input
     * 
     * @param name         the file name
     * @param directory    the file directory
     * @param modifiedDate the last modified date of the file
     */
    public FileData(String name, String directory, String modifiedDate) {
        this.name = name;
        this.dir = directory;
        this.lastModifiedDate = modifiedDate;
    }

    /**
     * returns the string representation of FileData
     * 
     * @return a string that displays the file information
     */
    public String toString() {
        return "{Name: " + this.name +
                ", Directory: " + this.dir +
                ", Modified Date: " + this.lastModifiedDate + "}";
    }
}