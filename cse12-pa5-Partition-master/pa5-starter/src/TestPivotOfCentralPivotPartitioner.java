import java.util.Random;
import java.util.Arrays;

public class TestPivotOfCentralPivotPartitioner {
    public static void main(String[] args) {
        String[] generated;
        int low;
        int high;
        String[] partitioned;
        int pivot;
        String result;
        Partitioner p = new CentralPivotPartitioner();
        for (int i = 0; i < 10; i++) {
            generated = PartitionOracle.generateInput(1 + new Random().nextInt(10));
            low = 0;
            high = generated.length;
            // if (high - low <= 1) {
            //     continue;
            // }
            partitioned = Arrays.copyOf(generated, generated.length);
            pivot = p.partition(partitioned, low, high);
            System.out.println("generated: " + Arrays.toString(generated));
            System.out.println("partitioned: " + Arrays.toString(partitioned));
            System.out.println("pivot index: " + pivot);
            System.out.println("____________");
        }
    }
}