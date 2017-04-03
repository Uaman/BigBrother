package com.big_brother.services;

import com.big_brother.dto.User;
import com.big_brother.dto.UserResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Alex on 03.04.2017.
 */
public class VKApiService {
    public static boolean getVKUserStatus(String vkId){
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject("https://api.vk.com/method/users.get?user_ids=" +
                vkId + "&fields=online", User.class);

        UserResponse response = (UserResponse) user.getResponse().toArray()[0];
        return response.isOnline();
    }
}
