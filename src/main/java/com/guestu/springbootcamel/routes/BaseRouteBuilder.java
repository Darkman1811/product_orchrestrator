package com.guestu.springbootcamel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;

public class BaseRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet").port(9090).host("localhost")
                .bindingMode(RestBindingMode.json)
                .enableCORS(true)
                .corsAllowCredentials(true)

                .corsHeaderProperty("Access-Control-Allow-Credentials","true")
                .corsHeaderProperty("Access-Control-Allow-Headers","authorization,Origin, Accept, X-Requested-With, Content-Type")
                .corsHeaderProperty("Access-Control-Allow-Methods","GET,POST,DELETE,PUT,OPTIONS,HEAD")
                .corsHeaderProperty("Access-Control-Allow-Origin","*")
                //.corsHeaderProperty("Origin, Accept, X-Requested-With, Content-Type")

             //   .corsHeaderProperty("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Allow-Method, Access-Control-Allow-Headers, Access-Control-Allow-Credentials")
        ;


    }
}
