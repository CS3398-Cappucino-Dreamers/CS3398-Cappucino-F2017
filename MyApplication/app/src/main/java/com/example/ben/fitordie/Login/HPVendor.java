package com.example.ben.fitordie.Login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.app.AlertDialog;

import java.util.ArrayList;

import android.content.Context;
import android.content.DialogInterface;

import com.example.ben.fitordie.R;

public class HPVendor extends AppCompatActivity {
    public static final String TAG = HPVendor.class.getSimpleName();
    private ListView mListView;
    CharSequence[] values = {" Points "," $$$ "," Challenge "};
    int paymentOption = 0;

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

        mListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Gets item information
                ItemList list = itemList.get(position);
                final String item = list.name;
                final String price = list.price;
                final String price2 = list.price2;
                final String currency = list.currency;

                // Dialog to confirm purchase
                AlertDialog.Builder builder = new AlertDialog.Builder(HPVendor.this);
                builder.setTitle("Confirm your purchase");
                builder.setMessage("Do you want to buy " + item + " for " + price + " points " + currency + price2 + "?");

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(),"Purchase canceled ",Toast.LENGTH_LONG).show();
                    }
                });

                // If item have more than one payment options, show payment options dialog
                if(position == 8 || position == 9) {
                    // Dialog for payment options
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            final AlertDialog.Builder builder = new AlertDialog.Builder(HPVendor.this);
                            builder.setTitle("Choose payment option:");
                            builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int option) {
                                    switch (option) {
                                        case 0:
                                            paymentOption = option;
                                            Toast.makeText(HPVendor.this, values[option] + "selected", Toast.LENGTH_LONG).show();
                                            break;
                                        case 1:
                                            paymentOption = option;
                                            Toast.makeText(HPVendor.this, values[option] + "selected", Toast.LENGTH_LONG).show();
                                            break;
                                        case 2:
                                            paymentOption = option;
                                            Toast.makeText(HPVendor.this, values[option] + "selected", Toast.LENGTH_LONG).show();
                                            break;
                                    }
                                }
                            });
                            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(), "Purchase canceled ", Toast.LENGTH_LONG).show();
                                }
                            });
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if(paymentOption == 0){
                                        Toast.makeText(getApplicationContext(), "Purchased " + item, Toast.LENGTH_LONG).show();
                                    }
                                    else if(paymentOption == 1){
                                        Toast.makeText(getApplicationContext(), "Purchased " + item, Toast.LENGTH_LONG).show();
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(), "Purchased " + item, Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                            builder.create();
                            builder.show();
                        }
                    });
                }
                else{
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "Purchased " + item, Toast.LENGTH_LONG).show();
                        }
                    });
                }
                builder.show();
            }
        });
    }
}
