package com.example.ben.fitordie.Login;

/**
 * Avatar info class to get/set the information about the avatar.
 */

public class AvatarInfo {
    private int userHP;
    private int userMaxHP;
    private int points;

    public void setUserHP(int userHP){ this.userHP = userHP; }

    public void setUserMaxHP(int userMaxHP){ this.userMaxHP = userMaxHP; }

    public void setPoints(int points){ this.points = points; }

    public int getUserHP(){ return userHP; }

    public int getUserMaxHP(){ return userMaxHP; }

    public int getPoints(){ return points; }
}
