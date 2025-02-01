package hillel.hw.controller;

import hillel.hw.service.AppService;
import hillel.hw.view.AppView;

public class AppController {
    AppView view;
    AppService service;

    public AppController(AppView view, AppService service) {
        this.view = view;
        this.service = service;
    }

    public void runApp() {
        service.handleOption(view.getOption());
    }
}
