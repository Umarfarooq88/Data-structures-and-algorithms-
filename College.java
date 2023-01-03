import java.util.Scanner;
class staff
{
    public static Scanner scan= new Scanner(System.in);
    int staffid;
    String name,phno;
    double sal;
    void get_info()
    {
        System.out.println("Enter in order \nStaff ID : Name : Phone Number : Salary :");
        staffid=scan.nextInt();
        name=scan.next();
        phno=scan.next();
        sal=scan.nextDouble();
    }
    void display()
    {
        System.out.println("Staff Details:\nStaff Id : "+staffid+"\nName :"+name+"\nPhone Number : "+phno+"\nSalary : "+sal);
    }
}
class Teaching extends staff
{
    public static Scanner scan= new Scanner(System.in);
    String domain,pub;
    void get_info()
    {
        super.get_info();
        System.out.println("Enter the Domain of Teacher "+name+" in order\nDomain : Publication");
                domain=scan.next();
        pub=scan.next();
    }
    void display()
    {
        super.display();
        System.out.println("Domain : "+domain+"\nPublication :"+pub);
    }
}
class Technical extends Teaching
{
    public static Scanner scan= new Scanner(System.in);
    String skills;
    void get_info()
    {
        super.get_info();
        System.out.println("Enter the Skills for Teacher "+name);
        skills=scan.next();
    }
    void display()
    {
        super.display();
        System.out.println("Skills :"+skills);
    }
}
class Contact extends Technical
{
    public static Scanner scan= new Scanner(System.in);
    String period;
    void get_info()
    {
        super.get_info();
        System.out.println("Enter the periods handled by Teacher "+name);
        period=scan.next();
    }
    void display()
    {
        super.display();
        System.out.println("Period : "+period);
    }
}
public class College {
    public static Scanner scan= new Scanner(System.in);
    public static void main(String[] args) {
        int n;
        System.out.println("Enter the Total Number of Records");
        n=scan.nextInt();
        Contact c[] = new Contact[n];
        for(int i=0;i<n;i++)
        {
            c[i]=new Contact();
            int r=i+1;
            System.out.println("Enter the Details of Record No "+r);
            c[i].get_info();
        }
        for(int i=0;i<n;i++)
        {
            int r=i+1;
            System.out.println("Displaying record No :"+r);
            c[i].display();
        }
    }
}