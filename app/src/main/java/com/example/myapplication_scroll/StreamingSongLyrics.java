package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StreamingSongLyrics extends AppCompatActivity {
    Button btn_mini_home;
    Button btn_mini_play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming_song_lyrics);

        this.InitializeView();
        this.SetListener();
    }
    public void InitializeView() {
        btn_mini_home = findViewById(R.id.mini_home_btn);
        btn_mini_play= findViewById(R.id.mini_play_btn);
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
                    case R.id.mini_play_btn:
                        Intent intent_play = new Intent(getApplicationContext(),StreamingMain.class);
                        startActivity(intent_play);
                        break;
                    default:
                        break;
                }
            }
        };
        btn_mini_home.setOnClickListener(Listener);
        btn_mini_play.setOnClickListener(Listener);


    }
}
