package hillel.hw.service;

import hillel.hw.controller.EmployeeController;
import hillel.hw.exception.OptionException;
import hillel.hw.util.AppStarter;
import hillel.hw.util.Constants;
import hillel.hw.view.AppView;

public class AppService {
    EmployeeController controller = new EmployeeController();

    public void handleOption(int option) {
        switch (option) {
            case 1 -> controller.create();
            case 2 -> controller.read();
            case 3 -> controller.update();
            case 4 -> controller.delete();
            case 5 -> controller.readById();
            case 0 -> new AppView().getOutput(Integer.toString(option));
            default -> {
                try {
                    throw new OptionException(Constants.INCORRECT_OPTION_MSG);
                } catch (OptionException e) {
                    new AppView().getOutput(e.getMessage());
                    AppStarter.startApp();
                }
            }
        }
    }
}
