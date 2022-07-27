import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Scanner;

public class FileReader {
	
	String filename;
	Comparator comparator;
	DefaultMap<Character, Student> hashMap;
	
	public FileReader(String name) {
		this.filename = name;
		this.comparator = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if (s1.marks > s2.marks) {
					return 1;
				} else if (s1.marks == s2.marks) {
					return 0;
				} else {
					return -1;
				}
			}
		};
		this.hashMap = new MyHashMap<>(10, comparator);
	}
	
	public void createHeap() {
		try {
			FileInputStream  fileInputStream = new FileInputStream(filename);
			Scanner scan = new Scanner(fileInputStream);
			while (scan.hasNextLine()){
				String line = scan.nextLine();
				String[] data = line.split(",");
				try {
					Student student = new Student(data[0], data[1].charAt(0), Integer.parseInt(data[2]));
					Character section = student.section;
					this.hashMap.put(section, student);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			scan.close();
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Student getMaxOfSection(char section) {
		if (!hashMap.containsKey(section)) {
			return null;
		}
		return hashMap.get(section);
	}
}
