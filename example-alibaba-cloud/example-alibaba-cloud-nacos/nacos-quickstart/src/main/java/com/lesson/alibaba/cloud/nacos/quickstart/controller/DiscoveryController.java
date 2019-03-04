package com.lesson.alibaba.cloud.nacos.quickstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengshijun
 * @version created on 2018/11/19.
 */
@RestController
@RequestMapping("/")
public class DiscoveryController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping()
    public ResponseEntity<String> get(){


        return ResponseEntity.ok(discoveryClient.getServices().toString());
    }
}
