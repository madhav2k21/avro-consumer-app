package com.techleads.app;

import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.techleads.app.avro.MyMessages;
import com.techleads.app.common.KafkaConstants;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
@Component
public class ArvoConsumerRunner implements CommandLineRunner {

	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {
		

		Properties props=new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,KafkaConstants.BOOTSTRAPSERVERS);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstants.GROUP_ID);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
		props.setProperty(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, KafkaConstants.SCHEMAREGISTRYSERVERS);
		props.put("specific.avro.reader","true");
		
		KafkaConsumer<String, MyMessages> consumer=new KafkaConsumer<>(props);
		consumer.subscribe(Collections.singleton(KafkaConstants.TOPIC));
		System.out.println("Waiting for data");
		while(true) {
			ConsumerRecords<String, MyMessages> records = consumer.poll(500);
			
			for (ConsumerRecord<String, MyMessages> record : records) {
				MyMessages messages = record.value();
				System.out.println(messages);
			}
			consumer.commitAsync();
			
		}
//		consumer.close();
	}

}
