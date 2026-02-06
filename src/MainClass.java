
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        System.out.println("Hello, and Welcome to DEBNATH Bank");
        Scanner scan = new Scanner(System.in);
        MainMenu m = new MainMenu();
        NewUser n = new NewUser();
        ExistingUser ex = new ExistingUser();
        Customer c = new Customer();
        m.mainMenu(scan,n,ex,c);
    }
}