package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).
            withUser("admin").password("$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.").roles("ADMIN");
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).
            withUser("user").password("$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.").roles("USER");
        // admin/123456: ADMIN
        // user/123456: USER
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        http
        .authorizeRequests()
        .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/home/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
        .antMatchers("/user/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
        .antMatchers("/forgot/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
        .and()
            .formLogin()
            .loginProcessingUrl("/login")
            .loginPage("/login")                    // the html file
            .defaultSuccessUrl("/home")             // url after success login
            .failureUrl("/login?message=error")     // when login failed
            .usernameParameter("username")          // the html file, input tag with name='username'
            .passwordParameter("password")          // the html file, input tag with name='password'
        .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?message=logout");

    }
}
