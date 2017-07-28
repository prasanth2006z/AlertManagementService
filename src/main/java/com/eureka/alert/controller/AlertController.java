package com.eureka.alert.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author Prasanth.P
 *
 */
@RestController
@EnableFeignClients
public class AlertController {
  
  private final Logger logger = LoggerFactory.getLogger(AlertController.class);

  @Autowired
  DiscoveryClient client;

  @RequestMapping(value = "/")
  public String getHostAndAddress() {
    logger.info("Prasanth..logs...");
    ServiceInstance localInstance = client.getLocalServiceInstance();
    return "Service is Ready and Running on : " + localInstance.getServiceId() + ":" + localInstance.getHost() + ":" + localInstance.getPort();
  }

}
