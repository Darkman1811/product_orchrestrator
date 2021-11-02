package com.guestu.springbootcamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CopyHeadersProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String par = (String)exchange.getIn().getHeaders().get("id");
        // exchange.getProperties().put("id",constant("5"));
        exchange.getOut().setHeaders(exchange.getIn().getHeaders());
        // exchange.getOut().getHeaders().put("id","5");
        exchange.getOut().getHeaders().put(Exchange.HTTP_PATH,par);
        //exchange.getOut().getHeaders().put(Exchange.HTTP_QUERY,"val=6");
        //    System.out.println(exchange.getOut().getHeaders());
    }
}
