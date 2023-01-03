import java.util.Scanner;
class ZeroOneKnapsack {
    int[] weight, profit;
    int capacity, n;
    ZeroOneKnapsack(){ //constructor automatically called
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Number of Items");
        n = scan.nextInt();
        weight = new int[n];
        profit = new int[n];
        System.out.println("Enter Weights of Items");
        for (int i = 0; i < n; i++) {
            weight[i] = scan.nextInt();
        }
        System.out.println("Enter Profits of Items");
        for (int i = 0; i < n; i++) {
            profit[i] = scan.nextInt();
        }
        System.out.println("Enter Capacity of Knapsack");
        capacity = scan.nextInt();
        scan.close();
    }
    void fill() {
        int[][] K = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {//Base condition.
                    K[i][j] = 0;
                } else if (j < weight[i - 1]) {//If weight is more than capacity of knapsack we will discard that item.
                    K[i][j] = K[i - 1][j];
                } else {
                    K[i][j] = Math.max(K[i - 1][j], profit[i - 1] + K[i - 1][j - weight[i - 1]]);//Actual calculation taking place.
                }
            }
        }
        System.out.println("Maximum Profit: " + (K[n][capacity]));
        System.out.print("Items Considered: ");
        int i = n, j = capacity;
        while (i > 0 && j > 0) {//Printing the items considered.
            if (K[i][j] != K[i - 1][j]) {//No two vertical values are equal then we'll consider that item.
                System.out.print(i + " ");
                j -= weight[i - 1];//After considering that particular item we will subtract it`s weight from the capacity of knapsack.
            }
            i -= 1;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ZeroOneKnapsack knapsack = new ZeroOneKnapsack();
        knapsack.fill();
    }
}