//package com.codegym.furama.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private MyUserDetailService myUserDetailService;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        //Sử dụng phương thức matches để so sánh pass chưa mã hóa và pass đã mã hóa.
////        bCryptPasswordEncoder.matches("123123","$2a$12$fvKL0pk.qWBp16iCGkhaK.8KnDFVyApXzrW6qHWQE7RnX3XPsuUIC");
//        return bCryptPasswordEncoder;
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//        // xét đặt dịch vụ để tìm kiếm User trong Database.
//        // Và xét đặt PasswordEncoder.
//        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin();
//    }
//
//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
//        return memory;
//    }
//
//}