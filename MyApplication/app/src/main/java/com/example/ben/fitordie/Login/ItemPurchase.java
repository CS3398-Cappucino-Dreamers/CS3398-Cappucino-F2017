package com.example.ben.fitordie.Login;

/**
 * Item purchase class to hold the functions to update points/health based on the item purchased
 */

public class ItemPurchase {
    /**
     * Updates the user's points after purchase
     *
     * returns the updated points
     */
    public static int updatePoints(AvatarInfo avatarInfo, int points, int price)
    {
        points -= price;
        avatarInfo.setPoints(points);
        return points;
    }
    /**
     * Extends the maximum health by x HP
     *
     * returns the updated maximum health
     */
    public static int extendHP(AvatarInfo avatarInfo, int userMaxHP, int addHP)
    {
        userMaxHP += addHP;
        avatarInfo.setUserMaxHP(userMaxHP);
        return userMaxHP;
    }
    /**
     * Restores to user's avatar health by x HP
     *
     * returns the updated health
     */
    public static int restoreXHP(AvatarInfo avatarInfo, int userHP, int addHP)
    {
        userHP += addHP;
        avatarInfo.setUserHP(userHP);
        return userHP;
    }
    /**
     * Restores/revives avatar to max HP. Used for Restore MAX HP & Full Revive
     *
     * returns the max health
     */
    public static int restoreMaxHP(AvatarInfo avatarInfo, int userMaxHP)
    {
        avatarInfo.setUserHP(userMaxHP);
        return userMaxHP;
    }
    /**
     * Revives avatar to half health
     *
     * returns the half health
     */
    public static int revive(AvatarInfo avatarInfo, int userMaxHP)
    {
        avatarInfo.setUserHP(userMaxHP / 2);
        return userMaxHP / 2;
    }
    /**
     * Slows the amount of HP damage when inactive for 7 days
     *
     * returns ?
     */
    public static int slow7Days(AvatarInfo avatarInfo, int userHP, int userMaxHP)
    {
        // code for slowing HP damage
        return 0;
    }
    /**
     * Slows the amount of HP damage when inactive for 30 days
     *
     * returns ?
     */
    public static int slow30Days(AvatarInfo avatarInfo, int userHP, int userMaxHP)
    {
        // code for slowing HP damage
        return 0;
    }
}
