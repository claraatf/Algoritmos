package tests;
import java.util.Arrays;
public class InsertionSort extends SortingAlgorithm {
    private int numSwaps;
    private int numComparisons;
    private long executionTime;

    @Override
    public void sort(int[] array) {
        long startTime = System.nanoTime();
        int n = array.length;

        numSwaps = 0;
        numComparisons = 0;

        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
                numSwaps++;
                numComparisons++;
            }
            array[j + 1] = key;
        }

        executionTime = System.nanoTime() - startTime;
    }

    @Override
    public int getNumSwaps() {
        return numSwaps;
    }

    @Override
    public int getNumComparisons() {
        return numComparisons;
    }

    @Override
    public long getExecutionTime() {
        return executionTime;
    }
}