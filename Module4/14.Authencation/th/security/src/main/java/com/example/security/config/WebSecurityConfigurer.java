package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    // phân quyền + đổi name user login
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()

                // {noop}: không cần mã hóa password vẫn login oke man
                .withUser("admin1").password("{noop}admin1").roles("ADMIN")
                .and()
                .withUser("admin2").password("admin2").roles("ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
//                .loginPage("/login") // url để login
//                .loginProcessingUrl("/j_spring_security_check") // gọi method login.html là vào đây


                .defaultSuccessUrl("/welcome", true)// logined --> url: "/welcome"
                .and()
                .authorizeRequests().anyRequest().authenticated(); // chặn all khi chưa login oke man
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
