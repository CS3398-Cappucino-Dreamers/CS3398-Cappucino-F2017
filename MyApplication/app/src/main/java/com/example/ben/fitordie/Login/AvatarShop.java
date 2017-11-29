package com.example.ben.fitordie.Login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

import android.content.Context;

import com.example.ben.fitordie.R;

public class AvatarShop extends AppCompatActivity {
    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar_shop);

        final Context context = this;

        // Gets data to display
        final ArrayList<GridList> gridList = GridList.getitemsFromFile("AvatarItems.json", this);

        // Creates adapter
        GridAdapter adapter = new GridAdapter(this, gridList);

        // Creates list view
        mGridView = (GridView) findViewById(R.id.grid);
        mGridView.setAdapter(adapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Gets item information
                GridList list = gridList.get(position);
                final String item = list.name;

                // Note: to see item selected
                Toast.makeText(AvatarShop.this, "You selected " + item, Toast.LENGTH_SHORT).show();
            }
        });
    }

}