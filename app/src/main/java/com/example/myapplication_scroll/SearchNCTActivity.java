package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.RelativeLayout;

import static com.example.myapplication_scroll.R.*;

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
    Button btn_songList1;
    Button btn_songList2;
    Button btn_songList3;
    Button btn_songList4;
//    Button btn_play1;
    RelativeLayout songLay1;
    RelativeLayout songLay2;
    RelativeLayout songLay3;
    RelativeLayout songLay4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_search_nct);

        this.InitializeView();
        this.SetListener();
    }
    public void InitializeView() {
        btn_mini_home = (Button) findViewById(id.mini_home_btn);
        btn_mini_search = (Button) findViewById(id.mini_search_btn);
        btn_nct127 = (Button) findViewById(id.nct127_btn);
        btn_song1 = (Button) findViewById(id.nct127_song1);
        btn_song2 = (Button) findViewById(id.nct127_song2);
        btn_song3 = (Button) findViewById(id.nct127_song3);
        btn_song4 = (Button) findViewById(id.nct127_song4);
        btn_album1 = (Button) findViewById(id.nct127_album1);
        btn_album2 = (Button) findViewById(id.nct127_album2);
        btn_songList1 = (Button) findViewById(id.song_list1);
        btn_songList2 = findViewById(id.song_list2);
        btn_songList3 = findViewById(id.song_list3);
        btn_songList4 = findViewById(id.song_list4);
        songLay1 = (RelativeLayout) findViewById(id.song_lay1);
        songLay2 = (RelativeLayout) findViewById(id.song_lay2);
        songLay3 = (RelativeLayout) findViewById(id.song_lay3);
        songLay4 = (RelativeLayout) findViewById(id.song_lay4);
    }

    public void SetListener() {
        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case id.mini_home_btn:
                        Intent intent_main = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent_main);
                        break;
                    case id.mini_search_btn:
                        Intent intent_search = new Intent(getApplicationContext(),SearchActivity.class);
                        startActivity(intent_search);
                        break;
                    case id.nct127_btn:
                        Intent intent_nct127 = new Intent(getApplicationContext(),ArtistNCTActivity.class);
                        startActivity(intent_nct127);
                        break;
                    case id.nct127_song1:
                        Intent intent_nct127_song1 = new Intent(getApplicationContext(),SongNCTActivity.class);
                        startActivity(intent_nct127_song1);
                        break;
                    case id.nct127_song2:
                        Intent intent_nct127_song2 = new Intent(getApplicationContext(),SongNCTActivity.class);
                        startActivity(intent_nct127_song2);
                        break;
                    case id.nct127_song3:
                        Intent intent_nct127_song3 = new Intent(getApplicationContext(),SongNCTActivity.class);
                        startActivity(intent_nct127_song3);
                        break;
                    case id.nct127_song4:
                        Intent intent_nct127_song4 = new Intent(getApplicationContext(),SongNCTActivity.class);
                        startActivity(intent_nct127_song4);
                        break;
                    case id.nct127_album1:
                        Intent intent_nct127_album1 = new Intent(getApplicationContext(),AlbumNCTActivity.class);
                        startActivity(intent_nct127_album1);
                        break;
                    case id.nct127_album2:
                        Intent intent_nct127_album2 = new Intent(getApplicationContext(),AlbumNCTActivity.class);
                        startActivity(intent_nct127_album2);
                        break;
                    case id.song_list1:
                        if (songLay1.getSolidColor() == 0) {
                            songLay1.setBackgroundResource(drawable.music_select);
                        } else {
                            songLay1.setBackgroundResource(drawable.song_lay);
                        }break;
                    case id.song_list2:
                        if (songLay2.getSolidColor() == 0) {
                            songLay2.setBackgroundResource(drawable.music_select);
                        } else {
                            songLay2.setBackgroundResource(drawable.song_lay);
                        } break;
                    case id.song_list3:
                        if (songLay3.getSolidColor() == 0) {
                            songLay3.setBackgroundResource(drawable.music_select);
                        } else {
                            songLay3.setBackgroundResource(drawable.song_lay);
                        }break;
                    case id.song_list4:
                        if (songLay4.getSolidColor() == 0) {
                            songLay4.setBackgroundResource(drawable.music_select);
                        } else {
                            songLay4.setBackgroundResource(drawable.song_lay);
                        }break;

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
        btn_songList1.setOnClickListener(Listener);
    }

}

