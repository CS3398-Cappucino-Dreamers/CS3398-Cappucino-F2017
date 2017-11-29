package com.example.ben.fitordie.Login;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GridList {
    public String name;
    public String price;
    public String icon;

    public static ArrayList<GridList> getitemsFromFile(String filename, Context context){
        final ArrayList<GridList> gridList = new ArrayList<>();

        try {
            // Loads data
            String jsonString = loadJsonFromAsset("AvatarItems.json", context);
            JSONObject json = new JSONObject(jsonString);
            JSONArray items = json.getJSONArray("AvatarItems");

            // Gets item objects from data
            for(int i = 0; i < items.length(); i++){
                GridList item = new GridList();

                item.name = items.getJSONObject(i).getString("name");
                item.price = items.getJSONObject(i).getString("price");
                item.icon = items.getJSONObject(i).getString("icon");

                gridList.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return gridList;
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