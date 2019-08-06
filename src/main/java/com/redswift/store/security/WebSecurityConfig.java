package com.redswift.store.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import com.redswift.store.filter.MyCORSFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserDetailsService customUserDetailsService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;    
    
    @Autowired
    private MyCORSFilter myCorsFilter;
    
    Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

        
    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(customUserDetailsService)
            .passwordEncoder(passwordEncoder);    
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(myCorsFilter, ChannelProcessingFilter.class)
            .authorizeRequests()
                .antMatchers("/oauth/token").permitAll()
                .anyRequest().authenticated()
                .and()
            .httpBasic()
             .and()
            .csrf().disable();
    }
    
    /**
         * See: https://github.com/spring-projects/spring-boot/issues/11136
         *
         * @return
         * @throws Exception
         */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }    
    
    @EventListener
    public void authSuccessEventListener(AuthenticationSuccessEvent authorizedEvent){
        // write custom code here for login success audit
    	//logger.info("User Oauth2 login success " + authorizedEvent.getAuthentication().getPrincipal());
    }
    
    @EventListener
    public void authFailedEventListener(AbstractAuthenticationFailureEvent oAuth2AuthenticationFailureEvent){
        // write custom code here login failed audit.
    	//logger.info("User Oauth2 login Failed");
    	//logger.info(""+oAuth2AuthenticationFailureEvent.getAuthentication().getPrincipal());
    }
    
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//        configuration.setAllowedMethods(Arrays.asList("GET","POST", "OPTIONS", "DELETE", "PUT", "HEAD"));
//        configuration.setAllowCredentials(true);
//        configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Accept", "X-Requested-With", "remember-me", "Authorization"));
//        
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }

}