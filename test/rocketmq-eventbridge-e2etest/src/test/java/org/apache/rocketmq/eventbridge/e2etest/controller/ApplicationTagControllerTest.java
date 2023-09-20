package org.apache.rocketmq.eventbridge.e2etest.controller;

import org.apache.rocketmq.eventbridge.Main;
import org.apache.rocketmq.eventbridge.e2etest.BaseTest;
import org.apache.rocketmq.eventbridge.e2etest.util.Utils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Main.class)
public class ApplicationTagControllerTest extends BaseTest {

    @Test
    public void testGetAllApplicationTags() {
        String url = String.format("%s/bus/createEventBus", baseUrl);
        Map<String, String> maps = new HashMap<>();
        maps.put("eventBusName", "demo-bus");
        maps.put("description", "a demo bus.");
        ResponseEntity<Void> response = Utils.request(template, url, HttpMethod.POST, maps, Void.class);
        Assert.assertTrue(response.getStatusCode().is2xxSuccessful());
    }


}
