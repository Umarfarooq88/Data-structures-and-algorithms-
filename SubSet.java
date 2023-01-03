import java.util.Scanner;
public class SubSet {
 static int count;
 static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Reading the number of values in a set
        System.out.println("Enter the number of values in a set");
        int n = scanner.nextInt();
        //Reading the values to a set
        System.out.println("Enter the values to the set");
        arr = new int[n];
        for (int i = 0 ; i < n ; i++){
            arr[i] = scanner.nextInt();
        }
        //Reading the sum to be considered.
        System.out.println("Enter the sum");
        int sum = scanner.nextInt();
        boolean[] solution = new boolean[n];
        //Method call
        subSet(sum, n-1 , solution);
        //Means printSolution did not execute that is No element could make the sum 0
        if (count==0)
            System.out.println("No solution Exists");
    }
    private static void subSet(int sum, int index, boolean[] solution){
        if (sum == 0)//Answer found
            printSolution(solution);
        else if(index < 0 || sum < 0)//Exit condition
            return;
        else{
            //Creating temporary boolean array with same values of solution array
            boolean[] tempSolution = solution.clone();
            //Do not consider the array element i.e 0
            tempSolution[index] = false;
            subSet(sum,index-1,tempSolution);
            //Consider the array element i.e 1
            tempSolution[index] = true;
            subSet(sum-arr[index],index-1,tempSolution);
        }
    }
    //We print the solution according to the boolean array which says what elements are considered.
    private static void printSolution(boolean[] solution){
        count++;
        System.out.print("Solution: {");
        for (int i = 0 ; i < solution.length ; i++){
            if (solution[i])//If true that means the element is considered.
                System.out.print(arr[i]+" ");
        }
        System.out.println("}");

    }
}
