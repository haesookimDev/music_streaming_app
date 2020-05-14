package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Popular_Song_Activity extends AppCompatActivity {
    Button btn_mini_home;
    Button btn_mini_search;
    Button btn_music_1;
    Button btn_music_2;
    Button btn_music_3;
    Button btn_music_4;
    Button btn_music_5;
    Button btn_music_6;
    Button btn_music_7;
    Button btn_music_8;
    Button btn_music_9;
    Button btn_music_10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_song);

        this.InitializeView();
        this.SetListener();
    }
    public void InitializeView() {
        btn_mini_home = (Button) findViewById(R.id.mini_home_btn);
        btn_mini_search = (Button) findViewById(R.id.mini_search_btn);
        btn_music_1 = (Button) findViewById(R.id.popular_chart_music_1);
        btn_music_2 = (Button) findViewById(R.id.popular_chart_music_2);
        btn_music_3 = (Button) findViewById(R.id.popular_chart_music_3);
        btn_music_4 = (Button) findViewById(R.id.popular_chart_music_4);
        btn_music_5 = (Button) findViewById(R.id.popular_chart_music_5);
        btn_music_6 = (Button) findViewById(R.id.popular_chart_music_6);
        btn_music_7 = (Button) findViewById(R.id.popular_chart_music_7);
        btn_music_8 = (Button) findViewById(R.id.popular_chart_music_8);
        btn_music_9 = (Button) findViewById(R.id.popular_chart_music_9);
        btn_music_10 = (Button) findViewById(R.id.popular_chart_music_10);
    }

    public void SetListener() {
        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.mini_home_btn:
                        Intent intent_main = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent_main);
                        break;
                    case R.id.mini_search_btn:
                        Intent intent_search = new Intent(getApplicationContext(), SearchActivity.class);
                        startActivity(intent_search);
                        break;
                    case R.id.popular_chart_music_1:
                        Intent intent_music_1_album = new Intent(getApplicationContext(), AlbumYEONGActivity.class);
                        startActivity(intent_music_1_album);
                        break;
                    case R.id.popular_chart_music_2:
                        Intent intent_music_2_album = new Intent(getApplicationContext(), AlbumYEONGActivity.class);
                        startActivity(intent_music_2_album);
                        break;
                    case R.id.popular_chart_music_3:
                        Intent intent_music_3_album = new Intent(getApplicationContext(), AlbumYEONGActivity.class);
                        startActivity(intent_music_3_album);
                        break;
                    case R.id.popular_chart_music_4:
                        Intent intent_music_4_album = new Intent(getApplicationContext(), AlbumYEONGActivity.class);
                        startActivity(intent_music_4_album);
                        break;
                    case R.id.popular_chart_music_5:
                        Intent intent_music_5_album = new Intent(getApplicationContext(), AlbumYEONGActivity.class);
                        startActivity(intent_music_5_album);
                        break;
                    case R.id.popular_chart_music_7:
                        Intent intent_music_7_album = new Intent(getApplicationContext(), AlbumYEONGActivity.class);
                        startActivity(intent_music_7_album);
                        break;
                    case R.id.popular_chart_music_8:
                        Intent intent_music_8_album = new Intent(getApplicationContext(), AlbumYEONGActivity.class);
                        startActivity(intent_music_8_album);
                        break;
                    case R.id.popular_chart_music_9:
                        Intent intent_music_9_album = new Intent(getApplicationContext(), AlbumYEONGActivity.class);
                        startActivity(intent_music_9_album);
                        break;
                    case R.id.popular_chart_music_10:
                        Intent intent_music_10_album = new Intent(getApplicationContext(), AlbumYEONGActivity.class);
                        startActivity(intent_music_10_album);
                        break;
                    default:
                        break;
                }
            }
        };

        btn_mini_home.setOnClickListener(Listener);
        btn_mini_search.setOnClickListener(Listener);
        btn_music_1.setOnClickListener(Listener);
        btn_music_2.setOnClickListener(Listener);
        btn_music_3.setOnClickListener(Listener);
        btn_music_4.setOnClickListener(Listener);
        btn_music_5.setOnClickListener(Listener);
        btn_music_6.setOnClickListener(Listener);
        btn_music_7.setOnClickListener(Listener);
        btn_music_8.setOnClickListener(Listener);
        btn_music_9.setOnClickListener(Listener);
        btn_music_10.setOnClickListener(Listener);
    }
}
