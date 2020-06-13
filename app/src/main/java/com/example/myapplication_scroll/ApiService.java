package com.example.myapplication_scroll;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/music/singer/5")
    Call<SingerModel> getYEONGData();

    @GET("/music/singer/6")
    Call<SingerModel> getNCTData();

    @GET("/music/album/6/1")
    Call<AlbumModel> getYEONGAlbumData();

    @GET("/music/album/5/1")
    Call<AlbumModel> getNCTAlbumData();

    @GET("/music/song/5")
    Call<SongModel> getYEONGSongData();

    @GET("/music/song/6")
    Call<List<SongModel>> getNCTSongData();

}
