package com.example.ben.fitordie.Login.DataModels;

/**
 * Created by Ben on 11/29/2017.
 */

/**
 * Data model for the listview that displays the various workout routines.
 */
public class ListDataModel {

    String workoutName;
    String exercises;
    String version_number;
    String feature;

    public ListDataModel(String workoutName, String exercises, String version_number, String feature ) {
        this.workoutName=workoutName;
        this.exercises=exercises;
        this.version_number=version_number;
        this.feature=feature;

    }

    public String getName() {
        return workoutName;
    }

    public String getExercises() {
        return exercises;
    }

    public String getVersion_number() {
        return version_number;
    }

    public String getFeature() {
        return feature;
    }

}
