package com.example.ben.fitordie.Login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

import android.content.Context;

import com.example.ben.fitordie.R;

public class HPVendor extends AppCompatActivity {
    private static final String TAG = "HP Vendor";
    private ListView mListView;
    private ProgressBar HPBar;

    // Sample HP & Pts data for testing conditional statements
    final int MAX_HP = 500;
    int userHP = 0;
    int userMaxHP = 100;
    int Pts = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hp_vendor);

        // Gets and sets the HP & Pts
        final TextView pointsView = (TextView)findViewById(R.id.Pt);
        final TextView healthView = (TextView)findViewById(R.id.HP);
        pointsView.setText(Integer.toString(Pts));
        healthView.setText(Integer.toString(userHP) + "/" + Integer.toString(userMaxHP));

        final AvatarInfo avatarInfo = new AvatarInfo();
        avatarInfo.setUserHP(userHP);
        avatarInfo.setUserMaxHP(userMaxHP);
        avatarInfo.setPoints(Pts);

        HPBar = (ProgressBar)findViewById(R.id.progressBar);
        HPBar.setMax(userMaxHP);
        HPBar.setProgress(userHP);

        final Context context = this;

        // Gets data to display
        final ArrayList<ItemList> itemList = ItemList.getitemsFromFile("AllItems.json", this);

        // Creates adapter
        ListAdapter adapter = new ListAdapter(this, itemList);

        // Creates list view
        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Gets item information
                ItemList list = itemList.get(position);
                final String item = list.name;
                final String price = list.price;
                final String price2 = list.price2;
                final String addHP = list.addHP;
                final String currency = list.currency;

                // Dialog to confirm purchase
                AlertDialogs.confirmDialogHP(HPVendor.this, item, price, currency, price2, position,
                                            avatarInfo, MAX_HP, pointsView, healthView,
                                            Integer.parseInt(addHP), HPBar);
            }
        });
    }
}
