package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchSongNCTActivity extends AppCompatActivity {
    Button btn_mini_home;
    Button btn_mini_search;
    Button btn_song1;
    Button btn_lyrics_album1;
    Button btn_lyrics_song1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_song_nct);

        this.InitializeView();
        this.SetListener();
    }
    public void InitializeView() {
        btn_mini_home = (Button) findViewById(R.id.mini_home_btn);
        btn_mini_search = (Button) findViewById(R.id.mini_search_btn);
        btn_song1 = (Button) findViewById(R.id.nct127_song1);
        btn_lyrics_album1 = (Button) findViewById(R.id.nct127_lyrics_album1);
        btn_lyrics_song1 = (Button) findViewById(R.id.nct127_lyrics_song1);
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
                    case R.id.nct127_song1:
                        Intent intent_nct127_song1 = new Intent(getApplicationContext(),SongNCTActivity.class);
                        startActivity(intent_nct127_song1);
                        break;
                    case R.id.nct127_lyrics_album1:
                        Intent intent_nct127_lyrics_album1 = new Intent(getApplicationContext(),AlbumNCTActivity.class);
                        startActivity(intent_nct127_lyrics_album1);
                        break;
                    case R.id.nct127_lyrics_song1:
                        Intent intent_nct127_lyrics_song1 = new Intent(getApplicationContext(),SongNCTActivity.class);
                        startActivity(intent_nct127_lyrics_song1);
                        break;
                    default:
                        break;
                }
            }
        };

        btn_mini_home.setOnClickListener(Listener);
        btn_mini_search.setOnClickListener(Listener);
        btn_song1.setOnClickListener(Listener);
        btn_lyrics_album1.setOnClickListener(Listener);
        btn_lyrics_song1.setOnClickListener(Listener);

    }

}