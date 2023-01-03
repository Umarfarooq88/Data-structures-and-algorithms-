import java.util.Random;

class First extends Thread{
    Random r = new Random();
    public void run(){
        try{
            int a = r.nextInt(100);
            System.out.println("Generated number is: "+a);
            Second s = new Second(a);
            s.run();
            Third t = new Third(a);
            t.run();
        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
class Second extends Thread{
    int x;
    Second(int x){
        this.x = x;
    }

    @Override
    public void run() {
        System.out.println("The square of a number is: "+(x*x));
    }
}
class Third extends Thread{
    int x;
    Third(int x){
        this.x = x;
    }

    @Override
    public void run() {
        System.out.println("The Cube of a number is: "+(x*x*x));
    }
}
public class MultiThread {
    public static void main(String[] args) {
        First f = new First();
        f.run();
    }
}
