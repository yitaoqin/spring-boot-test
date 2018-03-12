package com.example.multipledatasource.event;

import com.example.multipledatasource.service.UserService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class RegisterListener implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType==UserRegisterEvent.class;
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
        UserRegisterEvent userRegisterEvent = (UserRegisterEvent) event;
        System.out.println("用户注册"+userRegisterEvent.getBean().getUri());
    }

    /**
     * 异步后这个就没用了
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
