import static org.junit.Assert.*;

import org.junit.*;

public class FileDataTest {
    @Test
    public void testFileDataToString() {
        FileData fileData = new FileData("kevin.txt", "/", "2022/05/05");
        assertEquals("{Name: kevin.txt, Directory: /, Modified Date: 2022/05/05}", fileData.toString());
    }

    @Test
    public void testFileDataHasSameDir() {
        FileData fileData0 = new FileData("kevin.txt", "/", "2022/05/05");
        FileData fileData1 = new FileData("kevinhuang.txt", "/", "2022/05/05");
        assertEquals(true, fileData0.hasSameDir(fileData1));
    }
}
