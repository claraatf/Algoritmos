package org.example;
import tests.*;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SortingAlgorithm[] algorithms = {
                new BubbleSort(),
                new InsertionSort(),
                new SelectionSort(),
        };

        System.out.println("Array Size: 100");
        int[] array100 = generateRandomArray(100);
        compareAlgorithms(algorithms, array100, new SimplifiedSortingComparison());
        System.out.print("\n\n\n");

        System.out.println("Array Size: 10000");
        int[] array10000 = generateRandomArray(10000);
        compareAlgorithms(algorithms, array10000, new SimplifiedSortingComparison());
        System.out.print("\n\n\n");

        System.out.println("Array Size: 100000");
        int[] array100000 = generateRandomArray(100000);
        compareAlgorithms(algorithms, array100000, new SimplifiedSortingComparison());
        System.out.print("\n\n\n");
    }

    static class SimplifiedSortingComparison implements SortingComparison {
        @Override
        public void printResults(String algorithmName, int[] sortedArray) {
            System.out.println("Algorithm: " + algorithmName);
            System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        }

        @Override
        public void printResults(SortingAlgorithm algorithm, int[] originalArray, int[] sortedArray) {

        }
    }

    public static void compareAlgorithms(SortingAlgorithm[] algorithms, int[] array, SortingComparison comparison) {
        System.out.println();

        for (SortingAlgorithm algorithm : algorithms) {
            int[] copyArray = array.clone();
            long startTime = System.nanoTime();
            algorithm.sort(copyArray);
            long endTime = System.nanoTime();

            System.out.println("Algorithm: " + algorithm.getClass().getSimpleName());
            System.out.println("Number of Swaps: " + algorithm.getNumSwaps());
            System.out.println("Number of Comparisons: " + algorithm.getNumComparisons());
            System.out.println("Execution Time: " + (endTime - startTime) + " ns");
            System.out.println();
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }
}
