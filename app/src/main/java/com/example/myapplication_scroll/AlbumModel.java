package com.example.myapplication_scroll;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlbumModel {
    @SerializedName("idS_Album")
    @Expose
    private Integer idSAlbum;
    @SerializedName("S_Album_name")
    @Expose
    private String sAlbumName;
    @SerializedName("S_Albumcol_ficture")
    @Expose
    private String sAlbumcolFicture;

    public String getIdSAlbum() {
        return Integer.toString(idSAlbum);
    }

    public void setIdSAlbum(Integer idSAlbum) {
        this.idSAlbum = idSAlbum;
    }

    public String getSAlbumName() {
        return sAlbumName;
    }

    public void setSAlbumName(String sAlbumName) {
        this.sAlbumName = sAlbumName;
    }

    public String getSAlbumcolFicture() {
        return sAlbumcolFicture;
    }

    public void setSAlbumcolFicture(String sAlbumcolFicture) {
        this.sAlbumcolFicture = sAlbumcolFicture;
    }
}
