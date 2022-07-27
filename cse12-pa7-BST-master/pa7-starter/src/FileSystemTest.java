
/**
 * FileSystemTest a test file for FileSystem.java
 * It includes two or three tests for
 * each FileSystem method, including the constructors. 
 * The methodName indicates which method
 * it is testing.
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class FileSystemTest {
    @Test
    public void testDefaultConstructor() {
        FileSystem fSystem = new FileSystem();
        assertEquals(0, fSystem.nameTree.size());
    }

    @Test
    public void testDefaultConstructor2() {
        FileSystem fSystem = new FileSystem();
        assertEquals(0, fSystem.dateTree.size());
    }

    @Test
    public void testAdd() {
        FileSystem fSystem = new FileSystem();
        fSystem.add("mySample.txt", "/home", "2021/02/01");
        FileData fData = new FileData("mySample.txt", "/home", "2021/02/01");
        assertEquals(1, fSystem.nameTree.size);
        assertEquals(1, fSystem.dateTree.size);
        assertEquals("mySample.txt", fSystem.nameTree.get("mySample.txt").name);
        assertEquals("/home", fSystem.nameTree.get("mySample.txt").dir);
        assertEquals("2021/02/01", fSystem.nameTree.get("mySample.txt").lastModifiedDate);
        assertEquals(1, fSystem.dateTree.get("2021/02/01").size());
        assertEquals("mySample.txt", fSystem.dateTree.get("2021/02/01").get(0).name);
        assertEquals("/home", fSystem.dateTree.get("2021/02/01").get(0).dir);
        assertEquals("2021/02/01", fSystem.dateTree.get("2021/02/01").get(0).lastModifiedDate);
    }

    @Test
    public void testAdd2() {
        FileSystem fSystem = new FileSystem();
        fSystem.add("mySample.txt", "/home", "2021/02/01");
        fSystem.add("mySample.txt", "/user", "2021/02/01");
        assertEquals(1, fSystem.nameTree.size);
        assertEquals(1, fSystem.dateTree.size);
        fSystem.add("mySample.txt", "/user", "2021/02/03");
        assertEquals(1, fSystem.nameTree.size);
        assertEquals(1, fSystem.dateTree.size);
        fSystem.add("mySample2.txt", "/user", "2021/02/03");
        assertEquals(2, fSystem.nameTree.size);
        assertEquals(1, fSystem.dateTree.size);
        fSystem.add("mySample3.txt", "/user", "2021/02/04");
        assertEquals(3, fSystem.nameTree.size);
        assertEquals(2, fSystem.dateTree.size);
    }

    @Test
    public void testConstructor() {
        FileSystem fSystem = new FileSystem("./input.txt");
        assertEquals(3, fSystem.nameTree.size);
        assertEquals(2, fSystem.dateTree.size);
        assertEquals("mySample.txt", fSystem.nameTree.get("mySample.txt").name);
        assertEquals("/home", fSystem.nameTree.get("mySample.txt").dir);
        assertEquals("2021/02/01", fSystem.nameTree.get("mySample.txt").lastModifiedDate);
        assertEquals("mySample1.txt", fSystem.nameTree.get("mySample1.txt").name);
        assertEquals("/root", fSystem.nameTree.get("mySample1.txt").dir);
        assertEquals("2021/02/01", fSystem.nameTree.get("mySample1.txt").lastModifiedDate);
        assertEquals("mySample2.txt", fSystem.nameTree.get("mySample2.txt").name);
        assertEquals("/user", fSystem.nameTree.get("mySample2.txt").dir);
        assertEquals("2021/02/06", fSystem.nameTree.get("mySample2.txt").lastModifiedDate);
    }

    @Test
    public void testConstructor2() {
        FileSystem fSystem = new FileSystem("./input.txt");
        assertEquals(3, fSystem.nameTree.size);
        assertEquals(2, fSystem.dateTree.size);
        assertEquals(2, fSystem.dateTree.get("2021/02/01").size());
        assertEquals(1, fSystem.dateTree.get("2021/02/06").size());
        assertEquals("mySample.txt", fSystem.dateTree.get("2021/02/01").get(0).name);
        assertEquals("/home", fSystem.dateTree.get("2021/02/01").get(0).dir);
        assertEquals("2021/02/01", fSystem.dateTree.get("2021/02/01").get(0).lastModifiedDate);
        assertEquals("mySample1.txt", fSystem.dateTree.get("2021/02/01").get(1).name);
        assertEquals("/root", fSystem.dateTree.get("2021/02/01").get(1).dir);
        assertEquals("2021/02/01", fSystem.dateTree.get("2021/02/01").get(0).lastModifiedDate);
        assertEquals("mySample2.txt", fSystem.dateTree.get("2021/02/06").get(0).name);
        assertEquals("/user", fSystem.dateTree.get("2021/02/06").get(0).dir);
        assertEquals("2021/02/06", fSystem.dateTree.get("2021/02/06").get(0).lastModifiedDate);
    }

    @Test
    public void testFindFileNamesByDate() {
        FileSystem fSystem = new FileSystem("./input.txt");
        List<String> expected0 = List.of("mySample.txt", "mySample1.txt");
        assertEquals(expected0, fSystem.findFileNamesByDate("2021/02/01"));
    }

    @Test
    public void testFindFileNamesByDate2() {
        FileSystem fSystem = new FileSystem("./input.txt");
        List<String> expected0 = List.of("mySample2.txt");
        assertEquals(expected0, fSystem.findFileNamesByDate("2021/02/06"));
    }

    @Test
    public void testFilter() {
        FileSystem fSystem = new FileSystem("./input.txt");
        FileSystem filtered = fSystem.filter("2021/02/01", "2021/02/06");
        FileSystem expected = new FileSystem();
        expected.add("mySample.txt", "/home", "2021/02/01");
        expected.add("mySample1.txt", "/root", "2021/02/01");
        assertEquals(expected.dateTree.size(), filtered.dateTree.size());
        assertEquals(expected.nameTree.size(), filtered.nameTree.size());
    }

    @Test
    public void testFilter2() {
        FileSystem fSystem = new FileSystem("./input.txt");
        FileSystem filtered = fSystem.filter("2021/02/01", "2021/02/01");
        FileSystem expected = new FileSystem();
        assertEquals(expected.dateTree.size(), filtered.dateTree.size());
        assertEquals(expected.nameTree.size(), filtered.nameTree.size());
    }

    @Test
    public void testFilterWildCard() {
        FileSystem fSystem = new FileSystem("./input.txt");
        FileSystem filtered = fSystem.filter("mySample");
        FileSystem expected = fSystem;
        assertEquals(expected.dateTree.size(), filtered.dateTree.size());
        assertEquals(expected.nameTree.size(), filtered.nameTree.size());
        filtered = fSystem.filter("1");
        expected = new FileSystem();
        expected.add("mySample1.txt", "/root", "2021/02/01");
        assertEquals(expected.dateTree.size(), filtered.dateTree.size());
        assertEquals(expected.nameTree.size(), filtered.nameTree.size());
        filtered = fSystem.filter("2");
        expected = new FileSystem();
        expected.add("mySample2.txt", "/user", "2021/02/06");
        assertEquals(expected.dateTree.size(), filtered.dateTree.size());
        assertEquals(expected.nameTree.size(), filtered.nameTree.size());
    }

    @Test
    public void testOutputNameTree() {
        FileSystem fSystem = new FileSystem("./input.txt");
        List<String> expected = List.of(
                "mySample.txt: {Name: mySample.txt, Directory: /home, Modified Date: 2021/02/01}",
                "mySample1.txt: {Name: mySample1.txt, Directory: /root, Modified Date: 2021/02/01}",
                "mySample2.txt: {Name: mySample2.txt, Directory: /user, Modified Date: 2021/02/06}");
        assertEquals(expected, fSystem.outputNameTree());
    }

    @Test
    public void testOutputNameTree2() {
        FileSystem fSystem = new FileSystem();
        List<String> expected = new ArrayList<>();
        assertEquals(expected, fSystem.outputNameTree());
    }

    @Test
    public void testOutputDateTree() {
        FileSystem fSystem = new FileSystem("./input.txt");
        List<String> expected = List.of(
                "2021/02/06: {Name: mySample2.txt, Directory: /user, Modified Date: 2021/02/06}",
                "2021/02/01: {Name: mySample1.txt, Directory: /root, Modified Date: 2021/02/01}",
                "2021/02/01: {Name: mySample.txt, Directory: /home, Modified Date: 2021/02/01}");
        assertEquals(expected, fSystem.outputDateTree());
    }

    @Test
    public void testOutputDateTree2() {
        FileSystem fSystem = new FileSystem();
        List<String> expected = new ArrayList<>();
        assertEquals(expected, fSystem.outputDateTree());
    }

    @Test
    public void testDateTreeAddDuplicates() {
        FileSystem fSystem = new FileSystem();
        fSystem.add("mySample.txt", "/home", "2021/02/01");
        fSystem.add("mySample.txt", "/home", "2021/02/02");
        assertEquals(0, fSystem.dateTree.get("2021/02/01").size());
    }
}