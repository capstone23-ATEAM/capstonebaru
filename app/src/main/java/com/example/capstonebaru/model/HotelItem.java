package com.example.capstonebaru.model;

import com.google.gson.annotations.SerializedName;

public class HotelItem{
    /*@SerializedName("id")
    Integer Id;

    @SerializedName("nama")
    String Nama;

    @SerializedName("nomor_telp")
    String nomor_telp;

    @SerializedName("kordinat")
    String Kordinat;

    @SerializedName("alamat")
    String Alamat;

    @SerializedName("gambarurl")
    String GambarUrl;*/

    private String nomorTelp;
    private String kordinat;
    private String nama;
    private String gambarUrl;
    private Integer id;
    private String alamat;


    public void setNomorTelp(String nomorTelp){
        this.nomorTelp = nomorTelp;
    }

    public String getNomorTelp(){
        return nomorTelp;
    }

    public void setKordinat(String kordinat){
        this.kordinat = kordinat;
    }

    public String getKordinat(){
        return kordinat;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }

    public void setGambarUrl(String gambarUrl){
        this.gambarUrl = gambarUrl;
    }

    public String getGambarUrl(){
        return gambarUrl;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public String getAlamat(){
        return alamat;
    }
}
