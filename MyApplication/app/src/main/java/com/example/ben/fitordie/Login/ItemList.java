package com.example.ben.fitordie.Login;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ItemList {

    public static final String TAG = com.example.ben.fitordie.Login.ItemList.class.getSimpleName();

    public String name;
    public String description;
    public String price;
    public String icon;
    public String currency;
    public String price2;
    public String addHP;
    public String category;

    public static ArrayList<ItemList> getitemsFromFile(String filename, Context context){
        final ArrayList<ItemList> itemList = new ArrayList<>();

        try {
            // Loads data
            String jsonString = loadJsonFromAsset("AllItems.json", context);
            JSONObject json = new JSONObject(jsonString);
            JSONArray items = json.getJSONArray("AllItems");

            // Gets item objects from data
            for(int i = 0; i < items.length(); i++){
                ItemList item = new ItemList();

                item.name = items.getJSONObject(i).getString("name");
                item.description = items.getJSONObject(i).getString("description");
                item.price = items.getJSONObject(i).getString("price");
                item.icon = items.getJSONObject(i).getString("icon");
                item.currency = items.getJSONObject(i).getString("currency");
                item.price2 = items.getJSONObject(i).getString("price2");
                item.addHP = items.getJSONObject(i).getString("addHP");
                item.category = items.getJSONObject(i).getString("category");

                itemList.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}