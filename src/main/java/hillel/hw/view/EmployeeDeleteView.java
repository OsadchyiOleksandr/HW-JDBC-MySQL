package hillel.hw.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeDeleteView {

    public Map<String, String> getData(){
        System.out.println("\n DELETE FORM");
        Map<String, String> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input ID: ");
        map.put("id", scanner.nextLine().trim());
        return map;
    }

    public void  getOutput(String output){
        System.out.println(output);
    }
}
