package com.rya.rye.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CanchaList {
    @SerializedName("cancha_list")
    private ArrayList<Cancha> canchaList;

    public ArrayList<Cancha> getCanchaArrayList() {
        return canchaList;
    }

    public void setCanchaArrayList(ArrayList<Cancha> canchaArrayList) {
        this.canchaList = canchaArrayList;
    }
}
