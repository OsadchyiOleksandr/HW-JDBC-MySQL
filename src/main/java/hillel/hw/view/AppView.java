package hillel.hw.view;

import hillel.hw.util.AppStarter;
import hillel.hw.util.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppView {

    public int getOption(){
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        getMenu();
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println(Constants.INCORRECT_VALUE_MSG);
            AppStarter.startApp();
        }
        return option;
    }

    private void getMenu(){
        System.out.println("""
                OPTIONS:
                1. Create Employee.
                2. Read Employee.
                3. Update Employee.
                4. Delete Employee.
                5. Read Employee by ID.
                0. Close the App.
                """);
        System.out.println("Input your option: ");
    }

    public void getOutput(String output){
        if (output.equals("0")){
            System.out.println(Constants.APP_CLOSE_MSG);
            System.exit(0);
        } else System.out.println(output);
    }
}
