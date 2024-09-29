package com.deliveryboy.deliveryboy.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deliveryboy.deliveryboy.config.AppConstants;

import ch.qos.logback.classic.Logger;

@Service
public class KafkaService {
	
	private Logger logger = (Logger) LoggerFactory.getLogger(KafkaService.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public boolean updateLocation(String location) {
		this.kafkaTemplate.send(AppConstants.LOCTION_TOPIC_NAME, location);
		this.logger.info("message produced");
		return true;
	}
}
