package tests;
import java.util.Arrays;
public abstract class SortingAlgorithm {

    // Método abstrato para ordenação
    public abstract void sort(int[] array);

    // Método utilitário para trocar elementos de posição em um array
    protected void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public abstract int getNumSwaps();

    public abstract int getNumComparisons();

    public abstract long getExecutionTime();

    public long executionTime(int[] array) {
        long startTime = System.nanoTime();
        sort(array);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}