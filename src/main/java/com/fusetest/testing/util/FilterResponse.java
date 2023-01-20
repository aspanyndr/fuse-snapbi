package com.fusetest.testing.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FilterResponse implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        // TODO Auto-generated method stub
        String respBs = exchange.getIn().getBody().toString();
        if (respBs.contains("Unauthorized") && respBs.contains("responseCode")) {

            respBs = respBs.replaceAll(Pattern.quote("'"), Matcher.quoteReplacement(""));
        }
        exchange.setProperty("respBs", respBs);
    }

}
