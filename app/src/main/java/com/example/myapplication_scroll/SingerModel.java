package com.example.myapplication_scroll;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingerModel {
    @SerializedName("idSinger")
    @Expose
    private int idSinger;
    @SerializedName("nameSinger")
    @Expose
    private String nameSinger;
    @SerializedName("infoSinger")
    @Expose
    private String infoSinger;
    @SerializedName("fictureSinger")
    @Expose
    private String fictureSinger;

    public String getIdSinger() {
        return Integer.toString(idSinger);
    }

    public void setIdSinger(Integer idSinger) {
        this.idSinger = idSinger;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getInfoSinger() {
        return infoSinger;
    }

    public void setInfoSinger(String infoSinger) {
        this.infoSinger = infoSinger;
    }

    public String getFictureSinger() {
        return fictureSinger;
    }

    public void setFictureSinger(String fictureSinger) {
        this.fictureSinger = fictureSinger;
    }
}
