import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class FileSystemTest {
    @Test
    public void testRemoveFile() {
        FileSystem fiSystem = new FileSystem();
        fiSystem.add("mySample.txt", "/home", "02/01/2021");
        assertEquals(false, fiSystem.removeFile("mySample.txt", "/root"));
    }

    @Test
    public void testRemoveByNameFromDateMap() {
        FileSystem fiSystem = new FileSystem();
        fiSystem.add("mySample.txt", "/home", "02/01/2021");
        fiSystem.add("mySample.txt", "/root", "02/01/2021");
        fiSystem.add("mySample.txt", "/user", "02/01/2021");
        fiSystem.removeByName("mySample.txt");
        assertEquals(false, fiSystem.dateMap.containsKey("02/01/2021"));
    }
}
