package hu.mik.prog5.z7twzr.mediapatrik.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoginListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        log.info("USER LOGGED IN: " + event.getAuthentication().getName() + " | ROLES: " + event.getAuthentication().getAuthorities());
    }

}
