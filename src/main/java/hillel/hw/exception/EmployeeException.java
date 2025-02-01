package hillel.hw.exception;

import java.util.HashMap;
import java.util.Map;

public class EmployeeException extends RuntimeException{

    Map<String,String> errors;

    public EmployeeException(String message, Map<String, String> errors){
        super(message);
        this.errors = errors;
    }

    public String getErrors(Map<String,String> errors){
        this.errors = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        errors.forEach((key, value) ->
                sb.append(String.format("%n>> %s: %s", key, value))
        );
        return  sb.toString();
    }
}
