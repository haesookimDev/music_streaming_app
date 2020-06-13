package com.example.myapplication_scroll;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SongModel {
    @SerializedName("idS_song")
    @Expose
    private Integer idSSong;
    @SerializedName("S_song_name")
    @Expose
    private String sSongName;
    @SerializedName("S_song_lyric")
    @Expose
    private String sSongLyric;
    @SerializedName("S_song_file")
    @Expose
    private String sSongFile;
    @SerializedName("S_Album_idS_Album")
    @Expose
    private Integer sAlbumIdSAlbum;
    @SerializedName("S_Album_Singer_idSinger")
    @Expose
    private Integer sAlbumSingerIdSinger;

    public String getIdSSong() {
        return Integer.toString(idSSong);
    }

    public void setIdSSong(Integer idSSong) {
        this.idSSong = idSSong;
    }

    public String getSSongName() {
        return sSongName;
    }

    public void setSSongName(String sSongName) {
        this.sSongName = sSongName;
    }

    public String getSSongLyric() {
        return sSongLyric;
    }

    public void setSSongLyric(String sSongLyric) {
        this.sSongLyric = sSongLyric;
    }

    public String getSSongFile() {
        return sSongFile;
    }

    public void setSSongFile(String sSongFile) {
        this.sSongFile = sSongFile;
    }

    public Integer getSAlbumIdSAlbum() {
        return sAlbumIdSAlbum;
    }

    public void setSAlbumIdSAlbum(Integer sAlbumIdSAlbum) {
        this.sAlbumIdSAlbum = sAlbumIdSAlbum;
    }

    public Integer getSAlbumSingerIdSinger() {
        return sAlbumSingerIdSinger;
    }

    public void setSAlbumSingerIdSinger(Integer sAlbumSingerIdSinger) {
        this.sAlbumSingerIdSinger = sAlbumSingerIdSinger;
    }
}
