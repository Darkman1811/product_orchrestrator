package com.guestu.springbootcamel.routes;

import com.guestu.springbootcamel.config.MyKafkaConstants;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

@Component
public class Testkafka extends BaseRouteBuilder{
    @Override
    public void configure() throws Exception {
        super.configure();
        rest().get("/publish2/{message}")
                .param()
                .name("message").type(RestParamType.path).required(true).dataType("string")
                .endParam()
                .route()
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("hello");
                        exchange.getOut().setBody("hello");
                    }
                })
                //   .to("http://localhost:8081/microservice-product/?httpMethod=GET&bridgeEndpoint=true&copyHeaders=true")
                   .to(MyKafkaConstants.topic_test)
                // .unmarshal().json(JsonLibrary.Jackson)
                .endRest();
    }
}
