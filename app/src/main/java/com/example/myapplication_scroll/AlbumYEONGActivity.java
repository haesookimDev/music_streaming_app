package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumYEONGActivity extends AppCompatActivity {
    private static String TAG;
    Button btn_mini_home;
    Button btn_mini_search;
    private ApiService service;

    TextView textAlbumName;
    TextView textSongT_me;
    TextView textSongIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_yeong);
        service = RetrofitClient.getClient().create(ApiService.class);

        this.InitializeView();
        this.SetListener();
        albumData();
        songData();
    }

    public void InitializeView() {
        btn_mini_home = (Button) findViewById(R.id.mini_home_btn);
        btn_mini_search = (Button) findViewById(R.id.mini_search_btn);
        TAG = "MainActivity";
        textAlbumName = findViewById(R.id.text7);
        textSongT_me = findViewById(R.id.yeong_trust_me);
        textSongIndex = findViewById(R.id.text4);

    }

    public void SetListener() {
        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.mini_home_btn:
                        Intent intent_main = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent_main);
                        break;
                    case R.id.mini_search_btn:
                        Intent intent_search = new Intent(getApplicationContext(),SearchActivity.class);
                        startActivity(intent_search);
                        break;
                    default:
                        break;
                }
            }
        };

        btn_mini_home.setOnClickListener(Listener);
        btn_mini_search.setOnClickListener(Listener);
    }
    private void albumData(){
        service.getYEONGAlbumData().enqueue(new Callback<AlbumModel>() {
            @Override
            public void onResponse(Call<AlbumModel> call, Response<AlbumModel> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "response is success");
                    AlbumModel albumModel = response.body();
                    if (albumModel != null) {
                        textAlbumName.setText(albumModel.getSAlbumName());
                    } else {
                        Log.d(TAG, "NameSinger is null");
                    }
                } else {
                    int statusCode  = response.code();
                    Log.d(TAG, String.valueOf(statusCode));
                }
            }

            @Override
            public void onFailure(Call<AlbumModel> call, Throwable t) {
                Log.d(TAG, "error loading from API" + t);
            }
        });
    }

    private void songData(){
        service.getYEONGSongData().enqueue(new Callback<SongModel>() {
            @Override
            public void onResponse(Call<SongModel> call, Response<SongModel> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "response is success");
                    SongModel songModel = response.body();
                    if (songModel != null) {
                        textSongT_me.setText(songModel.getSSongName());
                        textSongIndex.setText(songModel.getIdSSong());
                    } else {
                        Log.d(TAG, "NameSinger is null");
                    }
                } else {
                    int statusCode  = response.code();
                    Log.d(TAG, String.valueOf(statusCode));
                }
            }

            @Override
            public void onFailure(Call<SongModel> call, Throwable t) {
                Log.d(TAG, "error loading from API" + t);
            }
        });
    }
}
