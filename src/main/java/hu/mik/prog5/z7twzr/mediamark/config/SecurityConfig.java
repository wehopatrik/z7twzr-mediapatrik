package hu.mik.prog5.z7twzr.mediamark.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String[] AUTH_WHITELIST = { "/index", "/home", "/css/**", "/js/**", "/images/**", "/favicon.ico**" };

    @Bean
    public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests(authorize -> {
            authorize.antMatchers(AUTH_WHITELIST).permitAll();
            authorize.anyRequest().authenticated();
        }).formLogin(form -> {
            form.loginPage("/login");
            form.defaultSuccessUrl("/myaccount", true);
            form.permitAll();
        }).logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsServiceBean(PasswordEncoder passwordEncoder) {
        //@formatter:off
        return new InMemoryUserDetailsManager(
                User.builder()
                        .passwordEncoder(passwordEncoder::encode)
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build(),
                User.builder()
                        .passwordEncoder(passwordEncoder::encode)
                        .username("admin")
                        .password("password")
                        .roles("USER", "ADMIN")
                        .build());
        //@formatter:on
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
