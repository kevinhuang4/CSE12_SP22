public class IncorrectPartitioner implements Partitioner{
    public int partition(String[] strs, int low, int high) {
        return -1;
    }
}
