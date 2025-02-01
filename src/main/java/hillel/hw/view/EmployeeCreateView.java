package hillel.hw.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeCreateView {

    public Map<String, String> getData(){
        System.out.println("\n CREATE FORM");
        Map<String, String> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input Name: ");
        map.put("name", scanner.nextLine().trim());

        System.out.println("Input Age: ");
        map.put("age", scanner.nextLine().trim());

        System.out.println("Input Position: ");
        map.put("position", scanner.nextLine().trim());

        System.out.println("Input Salary: ");
        map.put("salary", scanner.nextLine().trim());
        return map;
    }

    public void  getOutput(String output){
        System.out.println(output);
    }
}
