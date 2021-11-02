package com.guestu.springbootcamel.config;

import org.springframework.stereotype.Component;


public class MyKafkaConstants {
   private static final String kafka_broker="brokers=localhost:9092";
   public static final String topic_test="kafka:TestTopic?"+kafka_broker;
   public static final String topic_product_save="kafka:topic.product.save?"+kafka_broker;
}
