package hillel.hw.entity;

import java.util.Map;

public class EmployeeMapper {
    public Employee mapData(Map<String, String> data) {
        Employee employee = new Employee();
        if (data.containsKey("id"))
            employee.setId(Long.parseLong(data.get("id")));
        if (data.containsKey("name"))
            employee.setName(data.get("name"));
        if (data.containsKey("age"))
            employee.setAge(data.get("age"));
        if (data.containsKey("position"))
            employee.setPosition(data.get("position"));
        if (data.containsKey("salary"))
            employee.setSalary(data.get("salary"));
        return employee;
    }

}
