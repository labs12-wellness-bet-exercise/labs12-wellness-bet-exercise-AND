package com.example.labs12_wellness_bet_exercise_and.Network;

import android.util.Base64;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static final String BASE_URL = "https://sleep-bet.herokuapp.com/";
    public static final String USER_URL = BASE_URL + "api/user";
    private static final String CLIENT_ID = "labs12-wellness-bet-slee-f7748";
    private static final String CLIENT_SECRET = "vWcbrnGWL47r8RBVHbQm1q9YkP6hJ3Ujujp7sNBm";
    private static final String CLIENT_ID_SECRET = CLIENT_ID + ":" + CLIENT_SECRET;

    public static Map<String, String> headerProperties;


    public static Map<String, String> logInOauth(String username, String password) {
        String token = "";
        String auth = Base64.encodeToString(CLIENT_ID_SECRET.getBytes(), Base64.DEFAULT);

        headerProperties = new HashMap<>();
        headerProperties.put("Authorization", "Basic " + auth);


        String tokenRequest = null;
        try {
            tokenRequest = NetworkAdapter.httpRequest(
                    "http://192.168.1.14:2019/oauth/token?grant_type=password&username="
                            + username + "&password="
                            + password + "&scope=",
                    "POST", null, headerProperties);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i("TokenRequest", tokenRequest);
        try {
            token = new JSONObject(tokenRequest).getString("access_token");

            headerProperties.clear();
            headerProperties.put("Authorization", "Bearer " + token);


            String result = null;
            try {
                result = NetworkAdapter.httpRequest("https://sleep-bet.herokuapp.com/auth/login/", "GET", null, headerProperties);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            Log.i("Authentication", result);
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        Log.i("HeaderProperties", headerProperties.toString());
        return headerProperties;
    }

    public static void logIn(String username, String password){
        String result = null;
        try {
            result = NetworkAdapter.httpRequest("https://sleep-bet.herokuapp.com/auth/login/", "POST", null, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("Userlist", result);
    }
}
