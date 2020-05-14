package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.RelativeLayout;

public class SearchNCTActivity extends AppCompatActivity {
    Button btn_mini_home;
    Button btn_mini_search;
    Button btn_nct127;
    Button btn_song1;
    Button btn_song2;
    Button btn_song3;
    Button btn_song4;
    Button btn_album1;
    Button btn_album2;
//    Button btn_play1;
//    RelativeLayout songLay1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_nct);

        this.InitializeView();
        this.SetListener();
    }
    public void InitializeView() {
        btn_mini_home = (Button) findViewById(R.id.mini_home_btn);
        btn_mini_search = (Button) findViewById(R.id.mini_search_btn);
        btn_nct127 = (Button) findViewById(R.id.nct127_btn);
        btn_song1 = (Button) findViewById(R.id.nct127_song1);
        btn_song2 = (Button) findViewById(R.id.nct127_song2);
        btn_song3 = (Button) findViewById(R.id.nct127_song3);
        btn_song4 = (Button) findViewById(R.id.nct127_song4);
        btn_album1 = (Button) findViewById(R.id.nct127_album1);
        btn_album2 = (Button) findViewById(R.id.nct127_album2);
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
                    case R.id.nct127_btn:
                        Intent intent_nct127 = new Intent(getApplicationContext(),ArtistNCTActivity.class);
                        startActivity(intent_nct127);
                        break;
                    case R.id.nct127_song1:
                        Intent intent_nct127_song1 = new Intent(getApplicationContext(),SongNCTActivity.class);
                        startActivity(intent_nct127_song1);
                        break;
                    case R.id.nct127_song2:
                        Intent intent_nct127_song2 = new Intent(getApplicationContext(),SongNCTActivity.class);
                        startActivity(intent_nct127_song2);
                        break;
                    case R.id.nct127_song3:
                        Intent intent_nct127_song3 = new Intent(getApplicationContext(),SongNCTActivity.class);
                        startActivity(intent_nct127_song3);
                        break;
                    case R.id.nct127_song4:
                        Intent intent_nct127_song4 = new Intent(getApplicationContext(),SongNCTActivity.class);
                        startActivity(intent_nct127_song4);
                        break;
                    case R.id.nct127_album1:
                        Intent intent_nct127_album1 = new Intent(getApplicationContext(),AlbumNCTActivity.class);
                        startActivity(intent_nct127_album1);
                        break;
                    case R.id.nct127_album2:
                        Intent intent_nct127_album2 = new Intent(getApplicationContext(),AlbumNCTActivity.class);
                        startActivity(intent_nct127_album2);
                        break;
                    default:
                        break;
                }
            }
        };

        btn_mini_home.setOnClickListener(Listener);
        btn_mini_search.setOnClickListener(Listener);
        btn_nct127.setOnClickListener(Listener);
        btn_song1.setOnClickListener(Listener);
        btn_song2.setOnClickListener(Listener);
        btn_song3.setOnClickListener(Listener);
        btn_song4.setOnClickListener(Listener);
        btn_album1.setOnClickListener(Listener);
        btn_album2.setOnClickListener(Listener);
    }

}

