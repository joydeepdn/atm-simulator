import java.util.Scanner;

abstract class MainScreen{

    protected String userInput = null;

    Scanner scan = new Scanner(System.in);
    NewUser newUser = new NewUser();
    ExistingUser existinguser = new ExistingUser();

}

