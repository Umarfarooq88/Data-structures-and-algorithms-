import java.util.Scanner;
public class Exception extends Throwable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a,b,c;
        System.out.print("Enter the Two Integer Values\nA :");
        a=scan.nextInt();
        System.out.print("B :");
        b=scan.nextInt();
        scan.close();
        try {
            if(b==0)
                throw new ArithmeticException("Divide By Zero Error");
            c=a/b;
            System.out.println("\nThe Value of "+a+" / "+b+" is "+c);
        }catch(ArithmeticException ex)
        {
            System.out.println(ex.getMessage());
            //e.printStackTrace();
        }
    }
}
