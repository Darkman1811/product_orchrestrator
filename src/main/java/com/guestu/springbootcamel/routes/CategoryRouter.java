package com.guestu.springbootcamel.routes;

import com.guestu.springbootcamel.config.MyKafkaConstants;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

@Component
public class CategoryRouter extends BaseRouteBuilder {
    @Override
    public void configure() throws Exception {
        super.configure();

        rest().get("/category/getAll")
                .route()
                .to("http://localhost:8081/microservice-product/category/getAll/?httpMethod=GET&bridgeEndpoint=true&copyHeaders=true")
                .unmarshal().json(JsonLibrary.Jackson)
                .endRest();


        rest().get("/category/getOne/{id}")
                .param()
                .name("id").type(RestParamType.path).required(true).dataType("string")
                .endParam()
                .route()
                .to("http://localhost:8081/microservice-product/?httpMethod=GET&bridgeEndpoint=true&copyHeaders=true")
                .unmarshal().json(JsonLibrary.Jackson)
                .endRest();

        rest().post("/category/save")
                .route()
                .marshal().json(JsonLibrary.Jackson)
                .multicast()
                .to("http://localhost:8081/microservice-product/category/save/?httpMethod=POST&bridgeEndpoint=true&copyHeaders=true"
                        , MyKafkaConstants.topic_product_save)
                .unmarshal().json(JsonLibrary.Jackson)
                //.to(BaseRouteBuilder.tokafka)
                .endRest();

        rest().post("/category/update")
                .route()
                .marshal().json(JsonLibrary.Jackson)
                .to("http://localhost:8081/microservice-product/category/update/?httpMethod=POST&bridgeEndpoint=true&copyHeaders=true")
                .unmarshal().json(JsonLibrary.Jackson)
                .endRest();


        rest().post("/category/delete")
                .route()
                .marshal().json(JsonLibrary.Jackson)
                .to("http://localhost:8081/microservice-product/category/delete/?httpMethod=POST&bridgeEndpoint=true&copyHeaders=true")
                .unmarshal().json(JsonLibrary.Jackson)
                .endRest();


        rest().get("/category/parents/{id}")
                .param()
                .name("id").type(RestParamType.path).required(true).dataType("string")
                .endParam()
                .route()
                .to("http://localhost:8081/microservice-product/?httpMethod=GET&bridgeEndpoint=true&copyHeaders=true")
                .unmarshal().json(JsonLibrary.Jackson)
                .endRest();
    }
}
