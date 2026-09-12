package org.example;

import java.util.Arrays;
import java.util.Random;

public class SortingBenchmark {
    //bubble sort
    public static void bubbleSort(int[] arr){
        int n= arr.length;

        for(int i=0; i < n - 1; i++){
            boolean swapped = false;

            for (int j=0; j< n-1-i; j++ ){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = temp;

                    swapped = true;
                }
            }

            if(!swapped){
                break;
            }
        }
    }

    //merge sort
    public static void mergeSort(int[] arr){
        if(arr.length <2){
            return;
        }
        int mid = arr.length/2;
        int[] left= Arrays.copyOfRange(arr,0,mid);
        int[] right= Arrays.copyOfRange(arr,mid,arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr,left,right);

    }
    private static void merge(int[] arr, int[] left, int[] right){
        int i=0;
        int j=0;
        int k=0;
        while(i< left.length && j< right.length){
            if(left[i]<= right[j]){
                arr[k++]= left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        while ( i< left.length){
            arr[k++] = left[i++];
        }
        while(j< right.length){
            arr[k++] = right[j++];
        }
    }

    // quick sort
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    // generate random array
    public static int[] generateRandomArray(int size) {
        Random random = new Random();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1_000_000);
        }

        return arr;
    }
    // measure sorting time
    public static long measureTime(int[] original, String algorithm) {

        // Make a copy so every algorithm receives
        // the same unsorted data.
        int[] arr = Arrays.copyOf(original, original.length);

        long start = System.nanoTime();

        switch (algorithm) {
            case "Bubble Sort":
                bubbleSort(arr);
                break;

            case "Merge Sort":
                mergeSort(arr);
                break;

            case "Quick Sort":
                quickSort(arr);
                break;

            case "Arrays.sort()":
                Arrays.sort(arr);
                break;
        }

        long end = System.nanoTime();

        // Verify that the algorithm actually sorted the array
        if (!isSorted(arr)) {
            throw new RuntimeException(algorithm + " failed to sort the array!");
        }

        return end - start;
    }
    // check if array is sorted
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }
// main
public static void main(String[] args) {

    int[] sizes = {1000, 10_000, 100_000};

    System.out.printf(
            "%-12s %-15s %-15s%n",
            "Array Size",
            "Algorithm",
            "Time (ms)"
    );

    System.out.println("----------------------------------------------");

    for (int size : sizes) {

        int[] original = generateRandomArray(size);

        String[] algorithms = {
                "Bubble Sort",
                "Merge Sort",
                "Quick Sort",
                "Arrays.sort()"
        };

        for (String algorithm : algorithms) {

            // Bubble sort becomes extremely slow at 100,000,
            // so the benchmark can skip it for that size.
            if (size == 100_000 && algorithm.equals("Bubble Sort")) {
                System.out.printf(
                        "%-12d %-15s %-15s%n",
                        size,
                        algorithm,
                        "Skipped"
                );
                continue;
            }

            long time = measureTime(original, algorithm);

            double milliseconds = time / 1_000_000.0;

            System.out.printf(
                    "%-12d %-15s %-15.3f%n",
                    size,
                    algorithm,
                    milliseconds
            );
        }

        System.out.println("----------------------------------------------");
    }
}
}
