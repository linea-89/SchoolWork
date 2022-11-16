package com.sdu.web;

import com.sdu.web.controller.UIController;
import events.UIEvent;
import helperclasses.HazelcastConnection;
import services.IUIService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class},scanBasePackages = "com.sdu.web")
public class UIApplication implements IUIService {

    private ApplicationContext webApplicationContext;
    private HazelcastConnection hazelcastConnection;

    @Override
    public void run(String[] args) {
        webApplicationContext = SpringApplication.run(UIApplication.class,args);
        UIController controller = webApplicationContext.getBean(UIController.class);
        controller.setGateway(this);
        hazelcastConnection = new HazelcastConnection();
    }

    @Override
    public void update(String json) {
        for (UIController value : webApplicationContext.getBeansOfType(UIController.class).values()) {
            value.pushUpdateString(json);
        }
    }

    public void startProduction() {
        UIEvent uiEvent = new UIEvent(1);
        hazelcastConnection.publish(uiEvent.toString(), "UI");
    }

    public static void main(String[] args) {
        UIApplication app = new UIApplication();
        app.run(args);
        UIEventHandler uiEventHandlerMES = new UIEventHandler("MES",app);
        UIEventHandler uiEventHandlerAssets = new UIEventHandler("Assets",app);
    }
}