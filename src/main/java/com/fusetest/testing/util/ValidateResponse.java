package com.fusetest.testing.util;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ValidateResponse implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        // TODO Auto-generated method stub
        String valBs = exchange.getIn().getBody().toString();
        String isSuccess = "";
        if (valBs.contains("Unauthorized") && valBs.contains("responseCode")) {
            isSuccess = "2";
            exchange.setProperty("isSuccess", isSuccess);
        }else {
            isSuccess = "1";
            exchange.setProperty("isSuccess", isSuccess);
        }



    }
}