package com.example.ben.fitordie.Login;

import java.util.Date;

/**
 *  Log Class
 */

public class Log {

    private String description; // description of workout
    private int duration; //seconds
    String category;
    Date date;

    public Log(){
        description = "";
        duration = 0;
        category = "";
    }

    // set Date
    public void setDate(Date date){
        this.date = date;
    }

    // set Description of workout
    public void setDescription(String description){
        this.description = description;
    }

    // set category of workout (i.e. Endurance, Flexibility, Strength)
    public void setCategory(String category){
        this.category = category;
    }

    // set duration in seconds
    public void setDuration(int duration){
        this.duration = duration;
    }

    // getter for the Date
    public Date getDate(){
        return date;
    }
    //getter for workout description
    public String getDescription(){
        return description;
    }

    //getter for the category of the workout
    public String getCategory(){
        return category;
    }
}
