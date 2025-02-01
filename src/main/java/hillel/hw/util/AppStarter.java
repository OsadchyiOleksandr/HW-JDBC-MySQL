package hillel.hw.util;

import hillel.hw.controller.AppController;
import hillel.hw.service.AppService;
import hillel.hw.view.AppView;

public class AppStarter {
    public static void startApp(){
        AppService service = new AppService();
        AppView view = new AppView();
        AppController controller = new AppController(view, service);
        controller.runApp();
    }
}
