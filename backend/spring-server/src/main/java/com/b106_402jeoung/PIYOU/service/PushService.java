package com.b106_402jeoung.PIYOU.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

@Service
public class PushService {

    private final String sendUrlVal = "https://fcm.googleapis.com/fcm/send";
    @Value("${fcm.key.token}")
    private String apiKeyValue;
    private final String urlVal = "https://yusinsolution.com";

    @SuppressWarnings("unchecked")
    public void sendPush(HashMap<String, String> params) {
        StringBuilder urlBuilder = new StringBuilder(sendUrlVal);
        try {
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "key=" + apiKeyValue);
            conn.setRequestProperty("Content-type", "application/json");

            JSONObject apiParams = new JSONObject();
            JSONObject dataParams = new JSONObject();
            JSONObject notificationParams = new JSONObject();

            String tokenList = params.get("tokenList");

            apiParams.put("to", tokenList);

            String title = params.get("title");

            dataParams.put("title", title);
            notificationParams.put("title", title);

            String message = params.get("message");

            dataParams.put("message", message);
            notificationParams.put("body", message);

            String intent = params.get("intent");

            dataParams.put("intent", urlVal + intent);

            notificationParams.put("badge", 1);

            apiParams.put("data", dataParams);
            apiParams.put("notification", notificationParams);

            System.out.println(apiParams);

            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(apiParams.toString());
            wr.close();

            conn.connect();

            BufferedReader rd;
            StringBuilder sb = new StringBuilder();

            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();

            System.out.println("응답값 : " + sb);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}