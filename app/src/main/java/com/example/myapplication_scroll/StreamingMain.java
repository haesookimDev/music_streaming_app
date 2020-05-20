package com.example.myapplication_scroll;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class StreamingMain extends AppCompatActivity {
    Button btn_mini_playList;
    Button btn_stream_play_stop1;
    Button btn_stream_play_stop2;
    Button btn_mini_home;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming_main);

        this.InitializeView();
        this.SetListener();
    }

    public void InitializeView() {
        btn_mini_playList = findViewById(R.id.mini_playlist_btn);
        btn_stream_play_stop1 = findViewById(R.id.stream_play_stop1);
        btn_stream_play_stop2 = findViewById(R.id.stream_play_stop2);
        btn_mini_home = findViewById(R.id.mini_home_btn);
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
                    case R.id.mini_playlist_btn:
                        Intent intent_mini_playlist_btn = new Intent(getApplicationContext(),StreamingSongList.class);
                        startActivity(intent_mini_playlist_btn);
                        break;
                    case R.id.stream_play_stop1:
                        i = 1 - i;
                        if(i == 0){
                            btn_stream_play_stop1.setVisibility(View.VISIBLE);
                            btn_stream_play_stop2.setVisibility(View.INVISIBLE);
                        } else{
                            btn_stream_play_stop2.setVisibility(View.VISIBLE);
                            btn_stream_play_stop1.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case R.id.stream_play_stop2:
                        i= 1 - i;
                        if(i == 0){
                            btn_stream_play_stop1.setVisibility(View.VISIBLE);
                            btn_stream_play_stop2.setVisibility(View.INVISIBLE);
                        } else{
                            btn_stream_play_stop2.setVisibility(View.VISIBLE);
                            btn_stream_play_stop1.setVisibility(View.INVISIBLE);
                        } break;
                    default:
                        break;
                }
            }
        };
        btn_mini_home.setOnClickListener(Listener);
        btn_mini_playList.setOnClickListener(Listener);
        btn_stream_play_stop1.setOnClickListener(Listener);
        btn_stream_play_stop2.setOnClickListener(Listener);

    }
}
