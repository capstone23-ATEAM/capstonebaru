package com.example.capstonebaru.model;

import java.util.ArrayList;

public class HotelModel{
    private ArrayList<HotelItem> hotel;

    public void setHotel(ArrayList<HotelItem> hotel){
        this.hotel = hotel;
    }

    public ArrayList<HotelItem> getHotel(){
        return hotel;
    }
}