package tests;

import java.util.Arrays;

public interface SortingComparison {
    void printResults(String algorithmName, int[] sortedArray);

    void printResults(SortingAlgorithm algorithm, int[] originalArray, int[] sortedArray);
}

class SimplifiedSortingComparison implements SortingComparison {
    @Override
    public void printResults(String algorithmName, int[] sortedArray) {
        System.out.println("Algorithm: " + algorithmName);
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }

    @Override
    public void printResults(SortingAlgorithm algorithm, int[] originalArray, int[] sortedArray) {
        long startTime = System.nanoTime();
        algorithm.sort(originalArray.clone());
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        System.out.printf("%s:\n\tNumber of swaps = %d\tNumber of comparisons = %d\tElapsed time = %d ns\n",
                algorithm.getClass().getSimpleName(),
                algorithm.getNumSwaps(),
                algorithm.getNumComparisons(),
                elapsedTime);
    }
}

