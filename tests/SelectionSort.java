package tests;
import java.util.Arrays;
public class SelectionSort extends SortingAlgorithm {
    private int numSwaps;
    private int numComparisons;
    private long executionTime;

    @Override
    public void sort(int[] array) {
        long startTime = System.nanoTime();
        int n = array.length;

        numSwaps = 0;
        numComparisons = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                numComparisons++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(array, i, minIndex);
                numSwaps++;
            }
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
