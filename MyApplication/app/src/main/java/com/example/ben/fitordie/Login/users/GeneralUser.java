package com.example.ben.fitordie.Login.users;

/**
 * Created by Ben on 10/8/2017.
 */

/**
 * General user class to hold general information about the user.
 * Once database is created, this can be expanded or used to store database data in cache
 */
public class GeneralUser {


    private String firstName;
    private String lastName;
    private int age;
    private String birthDate;

    public GeneralUser(){

    }


    public int getAge(){return age;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getBirthDate(){return birthDate;}


}
