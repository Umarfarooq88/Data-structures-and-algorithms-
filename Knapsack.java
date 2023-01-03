import java.util.Scanner;
public class Knapsack
{
    public static void main(String[] args)
    {
        int i,j=0,max_qty,m,n;
        float sum=0,max;
        Scanner sc = new Scanner(System.in);
        int[][] array=new int[2][20];

        System.out.println("Enter no of items");
        n=sc.nextInt();

        System.out.println("Enter the weights of each items");  //This is how our array looks
        for(i=0;i<n;i++)                                        // 0 |_|_|_| //weight
            array[0][i]=sc.nextInt();                           // 1 |_|_|_| //profit

        System.out.println("Enter the profit of each items");
        for(i=0;i<n;i++)
            array[1][i]=sc.nextInt();

        System.out.println("Enter maximum volume of knapsack :");
        max_qty=sc.nextInt();
        m=max_qty;

        while(m>=0)
        {
            max=0;
            for(i=0;i<n;i++)
            {
                if(((float)array[1][i])/((float)array[0][i])>max)//Finding P/W ratio
                {
                    max=((float)array[1][i])/((float)array[0][i]);// Assigning the max p/w ratio among the elements to max
                    j=i;//Getting the index value/item number
                }
            }

            if(array[0][j]>m)//If weight of the item is more than the capacity
            {
                System.out.println("Quantity of item number: "+ (j+1) + " added is " +m);//How much ever capacity is left all r added
                sum+=m*max;//Multiplying m n max to find the no.of elements to take, to find the profit of the ratio we take
                m=-1;//Reducing the capacity by 1 coz we'll take at least 1 quantity
            }
            else
            {
                System.out.println("Quantity of item number: " + (j+1) + " added is " + array[0][j]);//Taking all the quantity of a particular item
                m-=array[0][j];//Reducing the capacity by the number of quantities taken
                sum+=(float)array[1][j];//Directly taking the profit
                array[1][j]=0;//Erasing the values considered
            }
        }
        System.out.println("The total profit is " + sum);
        sc.close();
    }
}