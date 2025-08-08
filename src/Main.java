
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n********************* Hello! Welcome to DEBNATH Bank **************************\n");
        Scanner scan = new Scanner(System.in);
        MainMenu m = new MainMenu();
        NewUser n = new NewUser();
        ExistingUser ex = new ExistingUser();
        CustomerInfo c = new CustomerInfo();
        m.mainMenu(scan,n,ex,m,c);
    }
}