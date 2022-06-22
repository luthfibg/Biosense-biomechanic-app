package com.oxigen.hardware.biomechanic;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DataModel {
    int image;
    private String header;
    private String datetime;
    private String desc;
    private HashMap <String, String> user1;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    public DataModel(){

    }
    public DataModel(String header, String datetime, String desc){
        this.header = header;
        this.datetime = datetime;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public DataModel(int image, String header, String desc){
        this.image = image;
        this.header = header;
        this.desc = desc;
    }
}
