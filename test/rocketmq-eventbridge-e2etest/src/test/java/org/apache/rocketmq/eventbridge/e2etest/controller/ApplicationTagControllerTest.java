package org.apache.rocketmq.eventbridge.e2etest.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
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

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Main.class)
public class ApplicationTagControllerTest extends BaseTest {

    @Test
    public void testGetAllApplicationTags() throws Exception {

        String url = String.format("%s/putEvents", baseUrl);
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=UTF-8");
        headers.put("ce-specversion","1.0");
        headers.put("ce-type", "com.github.pull_request.opened");
        headers.put("ce-source", "https://github.com/cloudevents/spec/pull");
        headers.put("ce-subject", "demo");
        headers.put("ce-id", "1234-1234-1234");
        headers.put("ce-datacontenttype", "application/json");
        headers.put("ce-time","2018-04-05T17:31:00Z");
        headers.put("ce-eventbusname", "demo-bus");

        ResponseEntity<Void> response = Utils.request(template, url, HttpMethod.POST, "A test recrod.", Void.class, headers);
        Assert.assertTrue(response.getStatusCode().is2xxSuccessful());
        File file = new File(System.getProperty("user.home") + "/demo");
        String data = null;
        int retries = 0;
        while( retries < 10 ) {
            data = FileUtils.readFileToString(file, "UTF-8");
            if (StringUtils.isNotBlank(data)) {
                Assert.assertEquals("A test recrod.\n", data);
                break;
            }
            Thread.sleep(50000);
            retries++;
        }
    }


}
