package com.example.ben.fitordie.Login.DataModels;

/**
 * Created by Ben on 11/29/2017.
 */

/**
 * Data model for the listview that displays the various workout routines.
 */
public class ListDataModel {

    String name;
    String type;
    String version_number;
    String feature;

    public ListDataModel(String name, String type, String version_number, String feature ) {
        this.name=name;
        this.type=type;
        this.version_number=version_number;
        this.feature=feature;

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getVersion_number() {
        return version_number;
    }

    public String getFeature() {
        return feature;
    }

}
