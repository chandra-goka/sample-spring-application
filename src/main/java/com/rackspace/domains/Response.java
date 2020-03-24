package com.rackspace.domains;

import org.springframework.stereotype.Component;

@Component
public class Response {
    private String reversed;

    public Response() {
    }

    public Response(String reversed) {
        this.reversed = reversed;
    }

    public String getReversed() {
        return reversed;
    }
}
