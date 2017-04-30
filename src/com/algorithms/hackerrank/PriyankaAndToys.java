import java.util.*;

public class Solution {
  
  private static void quickSort(int[] toys, int from, int to) {
    if (to <= from) return;
    
    int pivot = toys[to], i = from - 1, j = from; 
    
    for (; j < to; j++) {
      if (toys[j] <= pivot) {
        i += 1;
        int aux = toys[j];
        toys[j] = toys[i];
        toys[i] = aux;
      }
    }
    
    toys[to] = toys[i + 1];
    toys[i + 1] = pivot;
    
    quickSort(toys, from, i);
    quickSort(toys, i + 2, to);
  }
  
  private static int getMinimumUnits(int[] toys) {
    quickSort(toys, 0, toys.length - 1);
    
    int units = 1;
    int currentWeight = toys[0];
    
    for (int i = 1; i < toys.length; i++) {
      if (toys[i] > currentWeight + 4) {
        units += 1;
        currentWeight = toys[i];
      }
    }
    
    return units;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] toys = new int[n];

    for (int i = 0; i < n; i++) {
      toys[i] = in.nextInt();
    }
    
    System.out.print(getMinimumUnits(toys));
    in.close();
  }
