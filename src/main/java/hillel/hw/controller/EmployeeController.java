package hillel.hw.controller;

import hillel.hw.service.EmployeeService;
import hillel.hw.util.AppStarter;
import hillel.hw.view.*;

public class EmployeeController {
    EmployeeService service = new EmployeeService();

    public void create() {
        EmployeeCreateView view = new EmployeeCreateView();
        view.getOutput(service.create(view.getData()));
        AppStarter.startApp();
    }

    public void read() {
        EmployeeReadView view = new EmployeeReadView();
        view.getOutput(service.read());
        AppStarter.startApp();
    }

    public void update() {
        EmployeeUpdateView view = new EmployeeUpdateView();
        view.getOutput(service.update(view.getData()));
        AppStarter.startApp();
    }

    public void delete() {
        EmployeeDeleteView view = new EmployeeDeleteView();
        view.getOutput(service.delete(view.getData()));
        AppStarter.startApp();
    }

    public void readById() {
        EmployeeReadByIdView view = new EmployeeReadByIdView();
        view.getOutput(service.readById(view.getData()));
        AppStarter.startApp();
    }
}
