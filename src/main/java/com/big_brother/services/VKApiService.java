package com.big_brother.services;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Alex on 03.04.2017.
 */
public class VKApiService {
    private static final String URL = "https://api.vk.com/method/users.get";
    private static final String CHARSET = "UTF-8";

    public VKApiService(){}

    public static boolean getVKUserStatus(String vkId){

        String query = null;
        URLConnection connection = null;
        InputStream response = null;
        BufferedReader br = null;
        JSONObject recvObj = null;

        try {
            query = String.format("user_ids=%s&fields=online", URLEncoder.encode(vkId, CHARSET));
            connection = new URL(URL + "?" + query).openConnection();
            connection.setRequestProperty("Accept-Charset", CHARSET);
            response = connection.getInputStream();

            br = new BufferedReader(new InputStreamReader(response));

            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            recvObj = new JSONObject(sb.toString());

            response.close();
            br.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONArray root = recvObj.getJSONArray("response");
        JSONObject user = root.getJSONObject(0);

        return user.getInt("online") != 0;
    }
}
