package com.rackspace.service;

import com.rackspace.domains.Response;
import jdk.Exported;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
public class HelloServiceTest {

    @InjectMocks
    private HelloService helloService;

    @Test
    public void reverse() {
        Response response = helloService.reverse("Hello World");
        Assert.assertNotNull(response);
        Assert.assertEquals("World Hello",response.getReversed());
    }
    @Test(expected = IllegalArgumentException.class)
    public void reverseNullScenario() {
        Response response = helloService.reverse(null);
    }

    @Test
    public void removeDuplicatesFromList() {
        List<Integer> list = Arrays.asList(1,2,3,1,5,2,9,6,2,1);
        List<Integer> expected = Arrays.asList(1,2,3,5,6,9);
        List<Integer> withOutDuplicates = helloService.removeDuplicatesFromList(list);
        Assert.assertNotNull(withOutDuplicates);
        Assert.assertEquals(expected.size(),withOutDuplicates.size());
    }
}