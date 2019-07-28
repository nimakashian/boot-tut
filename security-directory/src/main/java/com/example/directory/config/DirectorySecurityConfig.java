package com.example.directory.config;


import com.example.directory.repository.PersonRepository;
import com.example.directory.security.DirectoryUserDetailService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class DirectorySecurityConfig extends WebSecurityConfigurerAdapter {

    private PersonRepository personRepository;

    public DirectorySecurityConfig(PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers("/**")
        .hasRole("ADMIN")
        .and()
        .httpBasic();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(
                new DirectoryUserDetailService(this.personRepository)
        );
    }
}
