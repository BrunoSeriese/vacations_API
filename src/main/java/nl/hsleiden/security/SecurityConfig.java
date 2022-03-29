package nl.hsleiden.security;


import lombok.RequiredArgsConstructor;
import nl.hsleiden.security.filter.AuthFilter;
import nl.hsleiden.security.filter.AuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration @EnableWebSecurity @RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
    //,"/api/refreshtoken/?**","api/vacations/?**","api/vacations"
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        AuthFilter authFilter = new AuthFilter(authenticationManagerBean());
        authFilter.setFilterProcessesUrl("/api/login");
        http.cors();
        http.csrf().disable();
        http.authorizeRequests().antMatchers(POST,"/api/login").permitAll();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers("/api/vacations/**").permitAll();
        http.authorizeRequests().antMatchers("/api/login/**").permitAll();



        http.authorizeRequests().antMatchers(GET,"/api/users").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(POST,"api/vacation/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers("api/signup/**").permitAll();
        http.authorizeRequests().antMatchers("/api/signup/**").permitAll();
        http.authorizeRequests().antMatchers("api/cart/item").permitAll();
        http.authorizeRequests().antMatchers("/api/cart/item").permitAll();
        http.authorizeRequests().antMatchers("/api/cart/item/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(authFilter);
        http.addFilterBefore(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);



    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
