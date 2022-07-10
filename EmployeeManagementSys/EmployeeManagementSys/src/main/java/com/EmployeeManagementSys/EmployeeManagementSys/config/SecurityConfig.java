package com.EmployeeManagementSys.EmployeeManagementSys.config;

import com.EmployeeManagementSys.EmployeeManagementSys.security.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests()
                .antMatchers("/**/create").hasAnyAuthority("Role_Admin")
                .antMatchers("/**/delete/**").hasAnyAuthority("Role_Admin")
                //.antMatchers("/**/update/**").hasAnyAuthority("Role_Admin", "Role_User")
                .antMatchers("/**/to/**").hasAnyAuthority("Role_Admin")
                .antMatchers("/**/getall").hasAnyAuthority("Role_Admin")
                .antMatchers("/asset").hasAnyAuthority("Role_Admin")
                .antMatchers("/org").hasAnyAuthority("Role_Admin")
                .antMatchers("/**").authenticated()
                .anyRequest().authenticated().and().httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
