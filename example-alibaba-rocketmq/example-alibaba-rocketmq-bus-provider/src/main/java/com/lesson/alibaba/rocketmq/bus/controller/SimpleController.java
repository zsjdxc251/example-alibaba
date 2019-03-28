package com.lesson.alibaba.rocketmq.bus.controller;

import com.lesson.alibaba.rocketmq.bus.api.event.SimpleRemoteApplicationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.BusProperties;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhengshijun
 * @version created on 2019/3/27.
 */
@RestController
public class SimpleController {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private BusProperties busProperties;


	@GetMapping("/")
	public ResponseEntity<Map<String,String>> index(@RequestHeader Map<String,String> header){

		String message = "simpile-message";
		applicationContext.getId();
		applicationContext.getDisplayName();
		applicationContext.getApplicationName();
		String[] names = {applicationContext.getId(),
				applicationContext.getDisplayName(),applicationContext.getApplicationName(),busProperties.getId()};
		SimpleRemoteApplicationEvent event
				= new SimpleRemoteApplicationEvent(message, busProperties.getId(), "rocketmq-bus-consumer*");

		try {
			publisher.publishEvent(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(header);
	}

	@GetMapping("/refresh")
	public ResponseEntity<Map<String,String>> refresh(@RequestHeader Map<String,String> header){

		String message = "simpile-message";
		applicationContext.getId();
		applicationContext.getDisplayName();
		applicationContext.getApplicationName();
		String[] names = {applicationContext.getId(),
				applicationContext.getDisplayName(),applicationContext.getApplicationName(),busProperties.getId()};
		RefreshRemoteApplicationEvent event
				= new RefreshRemoteApplicationEvent(message, busProperties.getId(), "**");

		try {
			publisher.publishEvent(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(header);
	}
}
