import java.util.Random;
import java.util.Scanner;

class QuickSort{
    public static void sort(int[] a){
        quickSort(a,0,a.length-1);
    }
    public static void quickSort(int[] a, int low, int high){
        int i=low,j=high,temp,pivot = a[low];
        while (i<=j){
            while (a[i]<pivot)
                i++;
            while (a[j]>pivot)
                j--;
            if (i<=j){
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (j>low)
            quickSort(a,low,j);
        if (i<high)
            quickSort(a,i,high);
    }

    public static void main(String[] args) {
        long totalTime = 0;
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[10];
        System.out.println("Enter the number of times the algorithm should run: ");
        int times = scanner.nextInt();
        for (int i = 0 ; i < times ; i++) {
            System.out.println("The random array generated is:");
            for (int j = 0; j < 10; j++) {
                a[j] = r.nextInt(100);
                System.out.print(a[j] + " ");
            }
            System.out.println();
            long start = System.nanoTime();
            sort(a);
            long end = System.nanoTime();
            long duration = end - start;
            System.out.println("The sorted array is : ");
            for (int j = 0; j < 10; j++) {
                System.out.print(a[j]+" ");
            }
            System.out.println("\nThe duration of sort " + i+1 + " is " + duration+" milli seconds");
            totalTime += duration;
        }
        System.out.println("The total time taken is "+totalTime+" milli seconds");
        System.out.println("The total time in seconds is "+(totalTime/1000)+" nano seconds");
    }
}