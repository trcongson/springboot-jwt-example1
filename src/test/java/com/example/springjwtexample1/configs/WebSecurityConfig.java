package com.example.springjwtexample1.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
//        co nghia la truy cap toi "/" thi khong can xac thuc
        .antMatchers(HttpMethod.POST, "/login").permitAll()
//                phuong thuc dang POST truy cap toi "/login" luon duoc phep truy cap du la da duoc authenticated hay chua
        .anyRequest().authenticated()
//                Cac requet con lai deu can authenticated
        .and()
//                Add cac filter, filter se hu'ng cac request de xu ly truoc khi chung duoc dua toi xu ly o controller
        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
        /*
       // Mình comment phần dưới này vì chúng ta ko sử dụng DB nhé. Nếu các bạn sử dụng, bỏ comment và config query sao cho phù hợp. Các bạn có thể GG để tìm hiểu thêm
       auth.jdbcAuthentication().dataSource(dataSource)
               .usersByUsernameQuery("select username,password, enabled from users where username=?")
               .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
       */
    }
}
