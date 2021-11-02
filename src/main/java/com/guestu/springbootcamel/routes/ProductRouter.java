package com.guestu.springbootcamel.routes;

import com.guestu.springbootcamel.model.Product;
import com.guestu.springbootcamel.processor.CopyHeadersProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangeProperty;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.apache.http.protocol.HTTP;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class ProductRouter extends BaseRouteBuilder {
  // final StringBuffer param=new StringBuffer();
    @Override
    public void configure() throws Exception {
        super.configure();
        super.configure();

        rest().get("/product/getAll")
                .route()
                .to("http://localhost:8081/microservice-product/product/getAll/?httpMethod=GET&bridgeEndpoint=true&copyHeaders=true")
                .unmarshal().json(JsonLibrary.Jackson)
                .endRest();


        rest().get("/product/getOne/{id}")
                .param()
                .name("id").type(RestParamType.path).required(true).dataType("string")
                .endParam()
                .route()
                .to("http://localhost:8081/microservice-product/?httpMethod=GET&bridgeEndpoint=true&copyHeaders=true")
                .unmarshal().json(JsonLibrary.Jackson)
                .endRest();

        rest().post("/product/save")
                .route()
                .marshal().json(JsonLibrary.Jackson)
                .to("http://localhost:8081/microservice-product/product/save/?httpMethod=POST&bridgeEndpoint=true&copyHeaders=true")
                .unmarshal().json(JsonLibrary.Jackson)
                .endRest();

        rest().post("/product/update")
                .route()
                .marshal().json(JsonLibrary.Jackson)
                .to("http://localhost:8081/microservice-product/product/update/?httpMethod=POST&bridgeEndpoint=true&copyHeaders=true")
                .unmarshal().json(JsonLibrary.Jackson)
                .endRest();


        rest().post("/product/delete")
                .route()
                .marshal().json(JsonLibrary.Jackson)
                .to("http://localhost:8081/microservice-product/product/delete/?httpMethod=POST&bridgeEndpoint=true&copyHeaders=true")
                .unmarshal().json(JsonLibrary.Jackson)
                .endRest();
    }
}
