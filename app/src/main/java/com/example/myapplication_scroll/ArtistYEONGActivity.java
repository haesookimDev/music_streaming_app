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

public class ArtistYEONGActivity extends AppCompatActivity {
    private static String TAG;
    Button btn_mini_home;
    Button btn_mini_search;
    TextView textInfo;
    TextView textName;
    private ApiService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_yeong);
        service = RetrofitClient.getClient().create(ApiService.class);

        this.InitializeView();
        this.SetListener();
        testData();
    }
    public void InitializeView() {
        TAG = "MainActivity";
        btn_mini_home = (Button) findViewById(R.id.mini_home_btn);
        btn_mini_search = (Button) findViewById(R.id.mini_search_btn);
        textInfo = findViewById(R.id.text8);
        textName = findViewById(R.id.text11);

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

    private void testData(){
        service.getYEONGData().enqueue(new Callback<SingerModel>() {
            @Override
            public void onResponse(Call<SingerModel> call, Response<SingerModel> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "response is success");
                    SingerModel singerModel = response.body();
                    if (singerModel != null) {
                        Log.d(TAG, singerModel.getIdSinger());
                        Log.d(TAG, singerModel.getNameSinger());
                        Log.d(TAG, singerModel.getInfoSinger());
                        Log.d(TAG, singerModel.getFictureSinger());
                        textName.setText(singerModel.getNameSinger());
                        textInfo.setText(singerModel.getInfoSinger());
                    } else {
                        Log.d(TAG, "NameSinger is null");
                    }
                } else {
                    int statusCode  = response.code();
                    Log.d(TAG, String.valueOf(statusCode));
                }
            }

            @Override
            public void onFailure(Call<SingerModel> call, Throwable t) {
                Log.d(TAG, "error loading from API" + t);
            }
        });
    }

}
