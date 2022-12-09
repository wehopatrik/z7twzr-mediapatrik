package hu.mik.prog5.z7twzr.mediapatrik.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogoutListener implements ApplicationListener<LogoutSuccessEvent> {

    @Override
    public void onApplicationEvent(LogoutSuccessEvent event) {
        log.info("USER LOGGED OUT: " + event.getAuthentication().getName());
    }

}
