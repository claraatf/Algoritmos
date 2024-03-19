package tests;

public class BubbleSort extends SortingAlgorithm {
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
            for (int j = 0; j < n - i - 1; j++) {
                numComparisons++;
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    numSwaps++;
                }
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