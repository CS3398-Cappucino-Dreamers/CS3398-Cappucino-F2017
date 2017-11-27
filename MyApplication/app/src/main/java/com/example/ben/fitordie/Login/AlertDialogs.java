package com.example.ben.fitordie.Login;

import android.content.Context;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class AlertDialogs {
    private static int paymentOptions = 0;

    /**
     * Creates a dialog to confirm purchases from the HP Vendor
     *
     */
    public static void confirmDialogHP(final Context context, final String item, String price,
                                     String currency, String price2, final int position)
    {
        AlertDialog confirmDialog = new AlertDialog.Builder(context)
                .setTitle("Confirm your purchase")
                .setMessage("Do you want to buy " + item + " for " + price + " points " + currency + price2 + "?")

                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(context, "Purchase canceled", Toast.LENGTH_LONG).show();
                    }
                })
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if(position == 8 || position == 9) {
                            paymentOption(context, item);
                        }
                        else{
                            Toast.makeText(context, "Purchased " + item, Toast.LENGTH_LONG).show();
                        }
                    }
                })

                .create();
        confirmDialog.show();
    }
    /**
     * Creates a dialog for payment options
     *
     */
    public  static void paymentOption(final Context context, final String item)
    {
        final CharSequence[] options = {" Points "," $$$ "," Challenge "};

        AlertDialog paymentOption = new AlertDialog.Builder(context)

                .setTitle("Choose payment option:")

                .setSingleChoiceItems(options, -1, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int option) {
                        switch (option) {
                            case 0:
                                paymentOptions = option;
                                Toast.makeText(context, options[option] + "selected", Toast.LENGTH_LONG).show();
                                break;
                            case 1:
                                paymentOptions = option;
                                Toast.makeText(context, options[option] + "selected", Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                paymentOptions = option;
                                Toast.makeText(context, options[option] + "selected", Toast.LENGTH_LONG).show();
                                break;
                        }
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(context, "Purchase canceled", Toast.LENGTH_LONG).show();
                    }
                })
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (paymentOptions) {
                            case 0:
                                Toast.makeText(context, "Purchased " + item, Toast.LENGTH_LONG).show();
                                break;
                            case 1:
                                Toast.makeText(context, "Purchased " + item, Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                Toast.makeText(context, "Purchased " + item, Toast.LENGTH_LONG).show();
                                break;
                        }

                    }
                })

                .create();
        paymentOption.show();
    }
}