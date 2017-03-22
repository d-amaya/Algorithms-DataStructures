import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QuicksortVsInsertionsort {
  
  private static int insertionSort(int[] arr) {
    int swaped = 0;
    for (int i = 1; i < arr.length; i++) {
      for (int j = i; j > 0; j--) {
        if (arr[j - 1] > arr[j]) {
          int aux = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = aux;
          swaped++;
        }
      }
    }
    return swaped;
  }

  private static int quickSortInPlace(int[] arr, int low, int high) {
    if (high <= low) return 0;
    
    int swaped = 0;
    int pivot = arr[high];
    int j = low, i = j - 1;
    
    for (; j < high; j++) {
      if (arr[j] <= pivot) {
        i++;
        int aux = arr[j];
        arr[j] = arr[i];
        arr[i] = aux;
        swaped++;
      }
    }
    
    arr[high] = arr[i + 1];
    arr[i + 1] = pivot;
    swaped++;
    
    return swaped + quickSortInPlace(arr, low, i) + quickSortInPlace(arr, i + 2, high);
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] arrQuickSort = new int[in.nextInt()];
    int[] arrInsertionSort = new int[arrQuickSort.length];
    
    for (int i = 0; i < arrQuickSort.length; i++) {
      arrQuickSort[i] = in.nextInt();
      arrInsertionSort[i] = arrQuickSort[i];
    }
    
    int quickSwaped = quickSortInPlace(arrQuickSort, 0, arrQuickSort.length - 1);
    int insertionSwaped = insertionSort(arrInsertionSort);
    
    System.out.print(insertionSwaped - quickSwaped);
    
    in.close();
  }
}
