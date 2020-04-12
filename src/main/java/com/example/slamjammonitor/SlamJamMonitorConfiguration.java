package com.example.slamjammonitor;

import com.example.slamjammonitor.Entity.Merch;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Class configuration for this application
 * @author whatislove118
 */

@Configuration
@EnableWebMvc
public class SlamJamMonitorConfiguration implements WebMvcConfigurer {
    /**
     * This method add a merch bean in application context
     * @return new object merch
     */
    @Bean(name = "merch")
    @Scope(scopeName = "prototype")
    public Merch getMerch(){
        return new Merch();
    }


}
