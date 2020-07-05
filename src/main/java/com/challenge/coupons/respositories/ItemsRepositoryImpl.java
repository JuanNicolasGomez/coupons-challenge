package com.challenge.coupons.respositories;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class ItemsRepositoryImpl implements ItemsRepository

{
    @Override
    public Map<String, Float> getItems(List<String> itemsId) {
        Map<String, Float> items = null;
        String itemsListParams = String.join(",",itemsId);
        try{
            String jsonResponse = getRequest("https://api.mercadolibre.com/items?ids="+ itemsListParams);
            JSONArray jArray = stringToJSONArray(jsonResponse);
            items = getItemsFromJson(jArray);
        }catch(IOException e){
            e.printStackTrace();
        }
        return items;
    }

    public String getRequest(String url) throws IOException {
        URL urlForGetRequest = new URL(url);
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        connection.setRequestProperty("Accept", "application/json");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            return response.toString();
        } else {
            return "";
        }
    }

    public JSONArray stringToJSONArray(String jsonString){
        JSONArray jArray  = new JSONArray(jsonString);
        return jArray;
    }

    public Map<String, Float> getItemsFromJson(JSONArray jsonArray){
        Map<String, Float> itemsMap = new HashMap<>();
        for (int i = 0;i<jsonArray.length();i++){
            JSONObject item  = jsonArray.getJSONObject(i);
            if(item.getInt("code") == 200){
                JSONObject itemBody = item.getJSONObject("body");
                itemsMap.put(itemBody.getString("id"),itemBody.getFloat("price"));
            }
        }
        return itemsMap;
    }
}
