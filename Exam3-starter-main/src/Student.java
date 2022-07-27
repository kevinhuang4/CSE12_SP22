import java.util.Comparator;

public class Student implements Comparator<Student>{
	
	String name;
	char section;
	double marks;
	
	public Student(String name, char section, double marks) {
		this.name = name;
		this.section = section;
		this.marks = marks;
	}

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

}
