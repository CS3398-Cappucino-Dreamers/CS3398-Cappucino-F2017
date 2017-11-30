package com.example.owner_pc.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import android.content.Context;

public class HPVendor extends AppCompatActivity {

    public static final String TAG = HPVendor.class.getSimpleName();

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hp_vendor);

        final Context context = this;

        // Gets data to display
        final ArrayList<ItemList> itemList = ItemList.getitemsFromFile("AllItems.json", this);

        // Creates adapter
        ListAdapter adapter = new ListAdapter(this, itemList);

        // Creates list view
        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setAdapter(adapter);
    }
}
