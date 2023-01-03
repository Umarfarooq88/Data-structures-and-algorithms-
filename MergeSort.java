import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    public static void mergeSort(int[] a,int low,int high){
        int N = high-low;
        if (N<=1)
            return;
        int mid = low+(N/2);
        mergeSort(a,low,mid);
        mergeSort(a,mid,high);
        int[] temp = new int[N];
        int i=low,j=mid;
        for (int k = 0 ; k < N ; k++){
            if (i == mid)
                temp[k] = a[j++];
            else if (j == high)
                temp[k] = a[i++];
            else if (a[i]<a[j])
                temp[k] = a[i++];
            else
                temp[k] = a[j++];
        }
        for (int k = 0 ; k < N ; k++){
            a[low++] = temp[k];
        }
    }

    public static void main(String[] args) {
        double totaldur = 0;
        int times = 0;
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the no.of times this algo should run");
         times = scanner.nextInt();

        int[] a = new int[10];
        for (int i = 0 ; i < times ; i++) {
            System.out.println("The array values generated at random are: ");
            for (int j = 0; j < 10; j++) {
                a[j] = r.nextInt(1000);
                System.out.print(a[j] + " ");
            }
            System.out.println();
            long start = System.nanoTime();
            mergeSort(a, 0, 10);
            long end = System.nanoTime();
            double dur = end - start;
            System.out.println("Elements after Sorting are");
            for (int k = 0; k < 10; k++)
                System.out.print(a[k] + " ");
            System.out.println("");
            totaldur += dur;
        }
            System.out.println("\nTotal time taken to Sort is :"+totaldur+" Nano Seconds");
            double miliseconds = (totaldur / 1000000);
            System.out.println("\nTotal time taken to Sort is :"+miliseconds+" Mili Seconds");
            double avg=totaldur/times;
            System.out.println("The Average time Spend by the System is : "+avg+" Nano Second");
            double miliavg=(avg/1000000);
            System.out.println("The Avergae time Spend by the System is : "+miliavg+" Mili Seconds");
                    scanner.close();

        }
    }

