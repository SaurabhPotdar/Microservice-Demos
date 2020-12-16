package com.cg.productservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;

@Configuration
public class RibbonConfig {
 
    @Bean
    public IRule ribbonRule() {
        return new AvailabilityFilteringRule();
    }

}
