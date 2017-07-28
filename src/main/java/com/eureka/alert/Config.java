package com.eureka.alert;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * 
 * @author Prasanth.P
 *
 */
@Configuration
@ComponentScan(basePackages="com.eureka.alert")
public class Config {

  @LoadBalanced
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public AlwaysSampler defaultSampler() {
    return new AlwaysSampler();
  }
}
