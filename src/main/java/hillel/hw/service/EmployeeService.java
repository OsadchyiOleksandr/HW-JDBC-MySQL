package hillel.hw.service;

import hillel.hw.entity.Employee;
import hillel.hw.entity.EmployeeMapper;
import hillel.hw.exception.EmployeeException;
import hillel.hw.repository.impl.EmployeeRepository;
import hillel.hw.util.Constants;
import hillel.hw.validator.EmployeeValidator;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class EmployeeService {

    EmployeeRepository repository = new EmployeeRepository();

    public String create(Map<String, String> data) {
        Map<String, String> errors =
                new EmployeeValidator().validateEmployeeData(data);
        if (!errors.isEmpty()) {
            try {
                throw new EmployeeException("Check inputs", errors);
            } catch (EmployeeException e) {
                return e.getErrors(errors);
            }
        }
        return repository.create(new EmployeeMapper().mapData(data));
    }

    public String read() {
        // Отримуємо дані
        Optional<List<Employee>> optional = repository.read();
        // Якщо Optional не містить null, формуємо виведення.
        // Інакше повідомлення про відсутність даних.
        if (optional.isPresent()) {
            // Отримуємо колекцію з Optional
            List<Employee> list = optional.get();
            // Якщо колекція не порожня, формуємо виведення.
            // Інакше повідомлення про відсутність даних.
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder sb = new StringBuilder();
                list.forEach((Employee) ->
                        sb.append(count.incrementAndGet())
                                .append(") ")
                                .append(Employee.toString())
                );
                return sb.toString();
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }

    public String update(Map<String, String> data) {
        Map<String, String> errors =
                new EmployeeValidator().validateEmployeeData(data);
        if (!errors.isEmpty()) {
            try {
                throw new EmployeeException("Check inputs", errors);
            } catch (EmployeeException e) {
                return e.getErrors(errors);
            }
        }
        return repository.update(new EmployeeMapper().mapData(data));
    }

    public String delete(Map<String, String> data) {
        Map<String, String> errors =
                new EmployeeValidator().validateEmployeeData(data);
        if (!errors.isEmpty()) {
            try {
                throw new EmployeeException("Check inputs", errors);
            } catch (EmployeeException e) {
                return e.getErrors(errors);
            }
        }
        return repository.delete(new EmployeeMapper().mapData(data).getId());
    }

    public String readById(Map<String, String> data) {
        Map<String, String> errors =
                new EmployeeValidator().validateEmployeeData(data);
        if (!errors.isEmpty()) {
            try {
                throw new EmployeeException("Check inputs", errors);
            } catch (EmployeeException e) {
                return e.getErrors(errors);
            }
        }
        // Отримуємо дані
        Optional<Employee> optional =
                repository.readById(Long.parseLong(data.get("id")));
        // Якщо Optional не містить null, формуємо виведення.
        // Інакше повідомлення про відсутність даних.
        if (optional.isPresent()) {
            // Отримуємо об'єкт з Optional
            Employee Employee = optional.get();
            return Employee.toString();
        } else return Constants.DATA_ABSENT_MSG;
    }
}
