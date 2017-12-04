package com.example.ben.fitordie.Login.DataModels;

/**
 * Created by Ben on 11/29/2017.
 */

/**
 * Data model for the listview that displays the various workout routines.
 */
public class ExerciseDataModel {

    String setNumber;
    String reps;
    String weight;
    String done;

    boolean isTitle;
    String title;

    public ExerciseDataModel(String setNumber, String reps, String weight, String done) {
        this.setNumber=setNumber;
        this.reps=reps;
        this.weight=weight;
        this.done=done;

    }

    public ExerciseDataModel(boolean isTitle, String title) {
        this.isTitle = isTitle;
        this.title = title;

    }

    public String getSetNumber() {
        return setNumber;
    }

    public String getReps() {
        return reps;
    }

    public String getWeight() {
        return weight;
    }

    public String getDone() {
        return done;
    }

    public boolean isTitle(){
        return isTitle;
    }

    public String getTitle(){
        return title;
    }

}
