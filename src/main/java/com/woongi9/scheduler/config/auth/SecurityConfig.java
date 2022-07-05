package com.woongi9.scheduler.config.auth;

import com.woongi9.scheduler.domain.user.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http
//                .csrf().disable()
//                .headers().frameOptions().disable()
//                .and()
//                    .authorizeRequests()
//                    .antMatchers("/", "/h2-consle/**", "/css/**", "/images/**"
//                    , "js/**").permitAll()
//                    .antMatchers("/calendar/timesort", "/calendar/prioritysort", "calendar/calendar",
//                        "calendar/events", "calendar/register").hasRole(Role.USER.name())
//                    .anyRequest().authenticated()
//                .and()
//                    .logout()
//                        .logoutSuccessUrl("/")
//                .and()
//                    .oauth2Login()
//                        .defaultSuccessUrl("/")
//                        .userInfoEndpoint()
//                        .userService(customOAuth2UserService);


        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/calendar/timesort", "/calendar/prioritysort", "calendar/calendar",
                        "calendar/events", "calendar/register").hasRole("USER");

        http.formLogin().defaultSuccessUrl("/");
        http.csrf().disable();
        http.logout().logoutSuccessUrl("/");
        http.oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);

    }
}
