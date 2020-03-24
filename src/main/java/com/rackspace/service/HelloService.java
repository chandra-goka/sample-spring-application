package com.rackspace.service;

import com.rackspace.domains.Response;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class HelloService {
    public Response reverse(String message){
        Assert.notNull(message,"Message should not be null");
       return Pattern.compile("\\s").splitAsStream(message).reduce((w1, w2) -> w2 + " " + w1).
                map(data->new Response(data)).get();
    }

    public List<Integer> removeDuplicatesFromList(List<Integer> duplicateList){
       return duplicateList.stream().distinct().collect(Collectors.toList());
    }

}
