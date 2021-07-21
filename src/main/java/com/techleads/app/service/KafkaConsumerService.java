package com.techleads.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.techleads.app.avro.MyMessages;
import com.techleads.app.common.KafkaConstants;

@Service
public class KafkaConsumerService {
	static Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
//	@KafkaListener(topics = KafkaConstants.TOPIC, groupId = KafkaConstants.GROUP_ID)
	public MyMessages listener(MyMessages myMessage) {
		logger.info("***Message received from kafka topic:: " + myMessage.getMsgId()+" "+myMessage.getMessage().toString());
		return myMessage;
	}

}
