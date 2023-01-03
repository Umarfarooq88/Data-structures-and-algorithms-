import java.util.Scanner;
import java.util.StringTokenizer;

public class Token {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String string = scanner.nextLine();
        StringTokenizer s = new StringTokenizer(string,"/");
        int count=s.countTokens();
        for (int i=1 ; i<=count&&s.hasMoreTokens() ; i++){
            System.out.print(s.nextToken());
            if(i<count)
                System.out.print("-");
        }
    }
}
