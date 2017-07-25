package com.eureka.alert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
public class AlertController {

  @Autowired
  DiscoveryClient client;

  @RequestMapping(value = "/")
  public String health() {
    ServiceInstance localInstance = client.getLocalServiceInstance();
    return "Service is Ready and Running on : " + localInstance.getServiceId() + ":" + localInstance.getHost() + ":" + localInstance.getPort();
  }

}
