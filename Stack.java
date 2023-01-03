import java.util.Scanner;
class arraystack
{
    int a[],top,max,i;
    arraystack(int n) //using constructor
    {
        max=n;
        a=new int[max];
        top=-1;
    }
    void push(int ele)
    {
        if(top==max-1)
        {
            System.out.println("----Stack OVER FLOW - Elements in the array are:"+max+" ----");
        }
         else
        {
            a[++top]=ele;
        }
    }
    void pop()
    {
        if(top==-1)
        {
            System.out.println("----Stack Underflow----");
        }
        else
        {
            System.out.println("Poped Element is :"+a[top--]);
        }
    }
    void display()
    {
        if(top==-1)
        {
            System.out.println("----STACK UNDERFLOW - No Element to display----");
            return;
        }
        System.out.println("Elements in the stack are as follows :");
        int p=top;
        for(i=p;i>=0;i--)
        {
            System.out.println("ELEMENT :"+a[i]);
        }
    }
}
public class Stack {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the Size of the array");
        int n=scan.nextInt();
        boolean done=false;
        arraystack stk =new arraystack(n);
        do
        {
            System.out.println("Stack Operation ");
            System.out.println("1.Push\n2.Pop\n3.Display\n4.Exit");
            System.out.println("Enter Your Choice");
            int choice=scan.nextInt();
            switch(choice)
            {
                case 1:System.out.println("Enter the Elements to be instered");
                    stk.push(scan.nextInt());
                    break;
                case 2:stk.pop();
                    break;
                case 3:stk.display();
                    break;
                case 4:done=true;
                    break;
                default : System.out.println("You Have Entered the Wrong Choice");
                    break;
            }
        }
        while(!done);
        scan.close();
    }
}
