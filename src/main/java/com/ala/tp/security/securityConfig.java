package com.ala.tp.security;

import com.ala.tp.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig  {

    @Autowired
    UserDetailsServiceImpl uds;

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(uds);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests((requests)-> {requests.requestMatchers("/","/cat/**","/film/all","/photos/**","/images/**").permitAll();
            requests.requestMatchers("/film/new","/film/delete/**","/film/modifier/**").hasAuthority("ADMIN");
            requests.anyRequest().authenticated();
        }).formLogin((form) -> form
                .permitAll().defaultSuccessUrl("/film/all",true/*???????*/)
        ).logout((logout) -> logout.permitAll().logoutSuccessUrl("/")).exceptionHandling().accessDeniedPage("/film/forbidden");
    return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
         BCryptPasswordEncoder bcP = new BCryptPasswordEncoder();
         System.out.println( bcP.encode("fat7i"));
        return bcP;

    }

}
