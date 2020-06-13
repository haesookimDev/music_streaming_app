package com.example.myapplication_scroll;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SearchYEONGActivity extends AppCompatActivity {
    Button btn_mini_home;
    Button btn_mini_search;
    Button btn_yeong;
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
    Button btn_songAll;
    Button btn_songSelect;

    RelativeLayout songLay1;
    RelativeLayout songLay2;
    RelativeLayout songLay3;
    RelativeLayout songLay4;

    MusicListDBManager musicDBManager;


    int i_1 = 0;
    int i_2 = 0;
    int i_3 = 0;
    int i_4 = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_yeong);

        musicDBManager = MusicListDBManager.getInstance(this);

        this.InitializeView();
        this.SetListener();
    }
    public void InitializeView() {
        btn_mini_home = (Button) findViewById(R.id.mini_home_btn);
        btn_mini_search = (Button) findViewById(R.id.mini_search_btn);
        btn_yeong = (Button) findViewById(R.id.yeong_btn);
        btn_song1 = (Button) findViewById(R.id.yeong_song1);
        btn_song2 = (Button) findViewById(R.id.yeong_song2);
        btn_song3 = (Button) findViewById(R.id.yeong_song3);
        btn_song4 = (Button) findViewById(R.id.yeong_song4);
        btn_album1 = (Button) findViewById(R.id.yeong_album1);
        btn_album2 = (Button) findViewById(R.id.yeong_album2);
        btn_songList1 = findViewById(R.id.song_list1);
        btn_songList2 = findViewById(R.id.song_list2);
        btn_songList3 = findViewById(R.id.song_list3);
        btn_songList4 = findViewById(R.id.song_list4);
        btn_songAll = findViewById(R.id.all_play);
        btn_songSelect = findViewById(R.id.select_play);
        songLay1 = findViewById(R.id.song_lay1);
        songLay2 = findViewById(R.id.song_lay2);
        songLay3 = findViewById(R.id.song_lay3);
        songLay4 = findViewById(R.id.song_lay4);
    }

    public void SetListener() {
        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues addRowValue = new ContentValues();
                switch (view.getId()) {
                    case R.id.mini_home_btn:
                        Intent intent_main = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent_main);
                        break;
                    case R.id.mini_search_btn:
                        Intent intent_search = new Intent(getApplicationContext(),SearchActivity.class);
                        startActivity(intent_search);
                        break;
                    case R.id.yeong_btn:
                        Intent intent_yeong = new Intent(getApplicationContext(),ArtistYEONGActivity.class);
                        startActivity(intent_yeong);
                        break;
                    case R.id.yeong_song1:
                        Intent intent_yeong_song1 = new Intent(getApplicationContext(),SongYEONGActivity.class);
                        startActivity(intent_yeong_song1);
                        break;
                    case R.id.yeong_song2:
                        Intent intent_yeong_song2 = new Intent(getApplicationContext(),SongYEONGActivity.class);
                        startActivity(intent_yeong_song2);
                        break;
                    case R.id.yeong_song3:
                        Intent intent_yeong_song3 = new Intent(getApplicationContext(),SongYEONGActivity.class);
                        startActivity(intent_yeong_song3);
                        break;
                    case R.id.yeong_song4:
                        Intent intent_yeong_song4 = new Intent(getApplicationContext(),SongYEONGActivity.class);
                        startActivity(intent_yeong_song4);
                        break;
                    case R.id.yeong_album1:
                        Intent intent_yeong_album1 = new Intent(getApplicationContext(),AlbumYEONGActivity.class);
                        startActivity(intent_yeong_album1);
                        break;
                    case R.id.yeong_album2:
                        Intent intent_yeong_album2 = new Intent(getApplicationContext(),AlbumYEONGActivity.class);
                        startActivity(intent_yeong_album2);
                        break;
                    case R.id.song_list1:
                        i_1 = 1- i_1;
                        if (i_1 == 1) {
                            songLay1.setBackgroundResource(R.drawable.music_select);
                        } else {
                            songLay1.setBackgroundResource(R.drawable.song_lay);
                        }break;
                    case R.id.song_list2:
                        i_2 = 1- i_2;
                        if (i_2 == 1) {
                            songLay2.setBackgroundResource(R.drawable.music_select);
                        } else {
                            songLay2.setBackgroundResource(R.drawable.song_lay);
                        } break;
                    case R.id.song_list3:
                        i_3 = 1- i_3;
                        if (i_3 == 1) {
                            songLay3.setBackgroundResource(R.drawable.music_select);
                        } else {
                            songLay3.setBackgroundResource(R.drawable.song_lay);
                        }break;
                    case R.id.song_list4:
                        i_4 = 1- i_4;
                        if (i_4 == 1) {
                            songLay4.setBackgroundResource(R.drawable.music_select);
                        } else {
                            songLay4.setBackgroundResource(R.drawable.song_lay);
                        }break;
                    case R.id.all_play:
                        addRowValue.put("singer", "임영웅");
                        addRowValue.put("album", "내일은 미스터트롯 우승자 특전곡");
                        addRowValue.put("title", "이제 나만 믿어요");
                        musicDBManager.insert(addRowValue);

                        addRowValue.put("singer", "임영웅");
                        addRowValue.put("album", "내일은 미스터트롯 우승자 특전곡");
                        addRowValue.put("title", "어느 60대 노부부이야기");
                        musicDBManager.insert(addRowValue);

                        addRowValue.put("singer", "임영웅");
                        addRowValue.put("album", "내일은 미스터트롯 우승자 특전곡");
                        addRowValue.put("title", "상사화");
                        musicDBManager.insert(addRowValue);

                        addRowValue.put("singer", "임영웅");
                        addRowValue.put("album", "내일은 미스터트롯 우승자 특전곡");
                        addRowValue.put("title", "바램");
                        musicDBManager.insert(addRowValue);
                        break;
                    case R.id.select_play:
                        if (i_1 == 1){
                            addRowValue.put("singer", "임영웅");
                            addRowValue.put("album", "내일은 미스터트롯 우승자 특전곡");
                            addRowValue.put("title", "이제 나만 믿어요");
                            musicDBManager.insert(addRowValue);
                        } if (i_2 == 1){
                            addRowValue.put("singer", "임영웅");
                            addRowValue.put("album", "내일은 미스터트롯 우승자 특전곡");
                            addRowValue.put("title", "어느 60대 노부부이야기");
                            musicDBManager.insert(addRowValue);
                        } if (i_3 == 1){
                            addRowValue.put("singer", "임영웅");
                            addRowValue.put("album", "내일은 미스터트롯 우승자 특전곡");
                            addRowValue.put("title", "상사화");
                            musicDBManager.insert(addRowValue);
                        } if (i_4 == 1) {
                            addRowValue.put("singer", "임영웅");
                            addRowValue.put("album", "내일은 미스터트롯 우승자 특전곡");
                            addRowValue.put("title", "바램");
                            musicDBManager.insert(addRowValue);
                        }
                        break;
                    default:
                        break;
                }
            }
        };

        btn_mini_home.setOnClickListener(Listener);
        btn_mini_search.setOnClickListener(Listener);
        btn_yeong.setOnClickListener(Listener);
        btn_song1.setOnClickListener(Listener);
        btn_song2.setOnClickListener(Listener);
        btn_song3.setOnClickListener(Listener);
        btn_song4.setOnClickListener(Listener);
        btn_album1.setOnClickListener(Listener);
        btn_album2.setOnClickListener(Listener);
        btn_songList1.setOnClickListener(Listener);
        btn_songList2.setOnClickListener(Listener);
        btn_songList3.setOnClickListener(Listener);
        btn_songList4.setOnClickListener(Listener);
        btn_songSelect.setOnClickListener(Listener);
        btn_songAll.setOnClickListener(Listener);
    }

}