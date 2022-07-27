package cse12pa4student;

import java.util.ArrayList;
import java.util.List;
import static cse12pa4mysteries.Mysteries.*;

public class Measure {
	public static List<Measurement> measure(String[] toRun, int startN, int stopN) {
		/** TODO **/
		List<Measurement> result = new ArrayList<>();
		long startTime;
		long estimatedTime;
		for (String method: toRun) {
			for (int i = startN; i <= stopN; i++) {
				switch(method) {
					case "A": 
						startTime = System.nanoTime();
						mysteryA(i);
						estimatedTime = System.nanoTime() - startTime;
						result.add(new Measurement("A", i, estimatedTime));
						break;
					case "B":
						startTime = System.nanoTime();
						mysteryB(i);
						estimatedTime = System.nanoTime() - startTime;
						result.add(new Measurement("B", i, estimatedTime));
						break;
					case "C":
						startTime = System.nanoTime();
						mysteryC(i);
						estimatedTime = System.nanoTime() - startTime;
						result.add(new Measurement("C", i, estimatedTime));
						break;
					case "D":
						startTime = System.nanoTime();
						mysteryD(i);
						estimatedTime = System.nanoTime() - startTime;
						result.add(new Measurement("D", i, estimatedTime));
						break;
					case "E":
						startTime = System.nanoTime();
						mysteryE(i);
						estimatedTime = System.nanoTime() - startTime;
						result.add(new Measurement("E", i, estimatedTime));
						break;
					case "F":
						startTime = System.nanoTime();
						mysteryF(i);
						estimatedTime = System.nanoTime() - startTime;
						result.add(new Measurement("F", i, estimatedTime));
						break;
					default:
						break;
				}
			}
		}
		return result;
		//Example call to mystery method
		// mysteryA(50);
		// return null;
	}
	

	public static String measurementsToCSV(List<Measurement> toConvert) {
		/** TODO **/
		String result = "name,n,nanoseconds\n";
		for (Measurement measurement: toConvert) {
			result += measurement.name + "," + measurement.valueOfN + "," + measurement.nanosecondsToRun + "\n";
		}
		return result;

	}
	
	/* Add any helper methods you find useful */
		
}
