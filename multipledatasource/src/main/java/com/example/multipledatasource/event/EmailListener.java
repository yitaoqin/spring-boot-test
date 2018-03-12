package com.example.multipledatasource.event;

import com.example.multipledatasource.service.UserService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailListener implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == EmailEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType == UserService.class;
    }

    @Override
    @Async
    public void onApplicationEvent(ApplicationEvent event) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EmailEvent emailEvent=(EmailEvent)event;
        System.out.println("发邮件"+emailEvent.getBean().getClientIp());
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
