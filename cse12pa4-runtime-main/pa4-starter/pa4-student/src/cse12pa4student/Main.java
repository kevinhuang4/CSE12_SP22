package cse12pa4student;

import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		String[] toRun = {"A", "B", "C", "D", "E", "F"};
		List<Measurement> measurement = Measure.measure(toRun, 30, 80);
		String csvMeasurement = Measure.measurementsToCSV(measurement);
		System.out.println(csvMeasurement);
	}
}
