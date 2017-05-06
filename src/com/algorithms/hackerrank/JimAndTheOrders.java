import java.util.*;

public class JimAndTheOrders {
  
  private static class Order {
    private int number;
    private int t;
    private int d;
    
    public Order(int number, int t, int d) {
      this.number = number;
      this.t = t;
      this.d = d;
    }
    
    public int getNumber() { return this.number; }
    public int getT() { return this.t; }
    public int getD() { return this.d; }
  }
  
  private static void sortOrders(Order[] orders) {
    
    Arrays.sort(orders, new Comparator<Order>() {
      @Override
      public int compare(Order o1, Order o2) {
        int timeOrder1 = o1.getT() + o1.getD();
        int timeOrder2 = o2.getT() + o2.getD();
        
        int comparison = timeOrder1 - timeOrder2;
        if (comparison == 0) comparison = o1.getNumber() - o2.getNumber();
        return comparison;
      }
    });
    
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    
    int n = in.nextInt();
    
    Order[] orders = new Order[n];
    for (int i = 0; i < n; i++) {
      orders[i] = new Order(i + 1, in.nextInt(), in.nextInt());
    }
    
    sortOrders(orders);
    for (int i = 0; i < n; i++) {
      System.out.print(orders[i].getNumber() + " ");
    }
    
    in.close();
  }
}
