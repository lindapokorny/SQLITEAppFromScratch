package com.example.lindapokorny.sqliteappfromscratch.model;

import android.util.Log;
//2)We made a MODEL CLASS with the fields we need in our table
public class Note {

    private String name;
    private String message;

    public Note(){

    }
    public Note(String name, String message){
    this.name = name;
    this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
