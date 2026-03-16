package org.apache.rocketmq.eventbridge.e2etest.controller;

import okhttp3.*;

import java.io.IOException;

public class PostJsonExample {
    public static void main(String[] args) throws InterruptedException {

        // 构建 JSON 请求体

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), "A test recrod.");

        // 创建 POST 请求
        Request request = new Request.Builder()
                .url("http://localhost:7001/putEvents")
                .addHeader("Content-Type", "application/json")
                .addHeader("ce-specversion","1.0")
                .addHeader("ce-type", "com.github.pull_request.opened")
                .addHeader("ce-source", "https://github.com/cloudevents/spec/pull")
                .addHeader("ce-subject", "demo")
                .addHeader("ce-id", "1234-1234-1234")
                .addHeader("ce-datacontenttype", "application/json")
                .addHeader("ce-time","2018-04-05T17:31:00Z")
                .addHeader("ce-eventbusname", "demo-bus")
                .post(body)
                .build();

        // 发送同步 POST 请求
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                System.out.println(response.body().string());
            } else {
                System.err.println("Request failed: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

