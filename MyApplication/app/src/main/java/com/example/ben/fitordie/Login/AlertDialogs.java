package com.example.ben.fitordie.Login;

import android.content.Context;

import android.app.AlertDialog;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class AlertDialogs {
    private static int paymentOptions;
    private static int options;
    private static Activity mActivity;

    public AlertDialogs(Activity activity) {
        this.mActivity = activity;
    }

    /**
     * Creates a dialog to confirm purchases from the HP Vendor
     *
     */
    public static void confirmDialogHP(final Context context, final String item, final String price,
                                       String currency, String price2, final int position, final AvatarInfo avatarInfo,
                                       final int MAX_HP, final TextView pointsView, final TextView healthView,
                                       final int addHP, final ProgressBar HPBar)
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
                            paymentOption(context, item, price, avatarInfo, position, pointsView, healthView, HPBar);
                        }
                        else{
                            int points = avatarInfo.getPoints();
                            int userMaxHP = avatarInfo.getUserMaxHP();
                            int userHP = avatarInfo.getUserHP();

                            if(position >= 0 && position <= 2){
                                if(userMaxHP == MAX_HP){
                                    // Dialog for max extended HP error
                                    basicDialog(context, "ERROR", "You have already extended to the max HP capacity of "
                                            + MAX_HP, "Purchase canceled");
                                }
                                else{
                                    if(points >= Integer.parseInt(price)){
                                        int pointsTemp = ItemPurchase.updatePoints(avatarInfo, points, Integer.parseInt(price));
                                        int healthTemp = ItemPurchase.extendHP(avatarInfo, userMaxHP, addHP);

                                        pointsView.setText(Integer.toString(pointsTemp));
                                        healthView.setText(Integer.toString(userHP) + "/" + Integer.toString(healthTemp));

                                        updateHPBar(HPBar, userHP, healthTemp);

                                        Toast.makeText(context, "Purchased " + item, Toast.LENGTH_LONG).show();
                                    }
                                    else{
                                        // Dialog for not enough points

                                        basicDialog(context, "ERROR", "You do not have enough points to purchase "
                                                + item, "Purchase canceled");

                                    }
                                }
                            }
                            else if(position >= 3 && position <= 6){
                                if(userHP == userMaxHP){
                                    // Dialog for full HP error
                                    basicDialog(context, "ERROR", "Your HP is already full", "Purchase canceled");
                                }
                                else if(userHP + addHP > userMaxHP){
                                    // Dialog for max extended HP error
                                    basicDialog(context, "ERROR", "You cannot purchase "
                                               + item, "Purchase canceled");
                                }
                                else if(userHP == 0){
                                    // Dialog for dead avatar error
                                    basicDialog(context, "ERROR", "Your avatar is dead...", "Purchase canceled");
                                }
                                else{
                                    if(points >= Integer.parseInt(price)){
                                        int pointsTemp = ItemPurchase.updatePoints(avatarInfo, points, Integer.parseInt(price));
                                        int healthTemp = ItemPurchase.restoreXHP(avatarInfo, userHP, addHP);

                                        pointsView.setText(Integer.toString(pointsTemp));
                                        healthView.setText(Integer.toString(healthTemp) + "/" + Integer.toString(userMaxHP));

                                        updateHPBar(HPBar, healthTemp, userMaxHP);

                                        Toast.makeText(context, "Purchased " + item, Toast.LENGTH_LONG).show();
                                    }
                                    else{
                                        // Dialog for not enough points
                                        basicDialog(context, "ERROR", "You do not have enough points to purchase "
                                                + item, "Purchase canceled");
                                    }
                                }
                            }
                            else if(position == 7){
                                if(userHP == userMaxHP){
                                    // Dialog for full HP error
                                    basicDialog(context, "ERROR", "Your HP is already full", "Purchase canceled");
                                }
                                else if(userHP == 0){
                                    // Dialog for dead avatar error
                                    basicDialog(context, "ERROR", "Your avatar is dead...", "Purchase canceled");
                                }
                                else
                                {
                                    if(points >= Integer.parseInt(price)){
                                        int pointsTemp = ItemPurchase.updatePoints(avatarInfo, points, Integer.parseInt(price));
                                        int healthTemp = ItemPurchase.restoreMaxHP(avatarInfo, userMaxHP);

                                        pointsView.setText(Integer.toString(pointsTemp));
                                        healthView.setText(Integer.toString(healthTemp) + "/" + Integer.toString(userMaxHP));

                                        updateHPBar(HPBar, healthTemp, userMaxHP);

                                        Toast.makeText(context, "Purchased " + item, Toast.LENGTH_LONG).show();
                                    }
                                    else{
                                        // Dialog for not enough points
                                        basicDialog(context, "ERROR", "You do not have enough points to purchase "
                                                + item, "Purchase canceled");
                                    }
                                }
                            }
                            else{
                                Toast.makeText(context, "Purchased " + item, Toast.LENGTH_LONG).show();
                            }
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
    public  static void paymentOption(final Context context, final String item, final String price,
                                      final AvatarInfo avatarInfo, final int position,
                                      final TextView pointsView, final TextView healthView, final ProgressBar HPBar)
    {
        final CharSequence[] options = {" Points "," $$$ "};

        final int points = avatarInfo.getPoints();
        final int userMaxHP = avatarInfo.getUserMaxHP();
        final int userHP = avatarInfo.getUserHP();

        if(userHP > 0){
            // Dialog for full HP error
            basicDialog(context, "ERROR", "Your avatar is still alive...", "Purchase canceled");
        }
        else{
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
                            }
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Toast.makeText(context, "Purchase canceled", Toast.LENGTH_LONG).show();
                        }
                    })
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            switch (paymentOptions) {
                                case 0:
                                    if(points >= Integer.parseInt(price)){
                                        int healthTemp = 0;
                                        int pointsTemp = ItemPurchase.updatePoints(avatarInfo, points, Integer.parseInt(price));

                                        if(position == 8){
                                            healthTemp = ItemPurchase.revive(avatarInfo, userMaxHP);
                                        }
                                        else{
                                            healthTemp = ItemPurchase.restoreMaxHP(avatarInfo, userMaxHP);
                                        }

                                        updateHPBar(HPBar, healthTemp, userMaxHP);

                                        pointsView.setText(Integer.toString(pointsTemp));
                                        healthView.setText(Integer.toString(healthTemp) + "/" + Integer.toString(userMaxHP));

                                        Toast.makeText(context, "Purchased " + item, Toast.LENGTH_LONG).show();
                                    }
                                    else{
                                        // Dialog for not enough points
                                        basicDialog(context, "ERROR", "You do not have enough points to purchase "
                                                + item,"Purchase canceled");
                                    }
                                    break;
                                case 1:
                                    // Place holder code & dialog for in-app purchase
                                    int healthTemp = 0;

                                    if(position == 8){
                                        healthTemp = ItemPurchase.revive(avatarInfo, userMaxHP);
                                    }
                                    else{
                                        healthTemp = ItemPurchase.restoreMaxHP(avatarInfo, userMaxHP);
                                    }

                                    updateHPBar(HPBar, healthTemp, userMaxHP);

                                    healthView.setText(Integer.toString(healthTemp) + "/" + Integer.toString(userMaxHP));

                                    basicDialog(context, "Purchased item", "Thank you for purchasing!   :)",
                                            "Purchased item");
                                    break;
                            }
                        }
                    })
                    .create();
            paymentOption.show();
        }

    }
    /**
     * Creates a basic dialog used for error messages
     *
     */
    public static void basicDialog(final Context context, String title, String message, final String error)
    {
        AlertDialog basicDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)

                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(context, error, Toast.LENGTH_LONG).show();
                    }
                })

                .create();
        basicDialog.show();
    }
    /**
     * Updates the health bar
     *
     */
    public static void updateHPBar(final ProgressBar HPBar, final int userHP, final int userMaxHP)
    {
        HPBar.setMax(userMaxHP);
        HPBar.setProgress(userHP);
    }
}