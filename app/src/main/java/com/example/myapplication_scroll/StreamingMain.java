package com.example.myapplication_scroll;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.IOException;

public class StreamingMain extends Activity {

    Button btn_mini_playList;
    Button btn_mini_home;
    int i = 0;

    Button btn_stream_play_stop1;
    SeekBar seekbar;
    MediaPlayer music;
    String strColorplay="#ff691bf3";
    String strColorstop="#fff63e4b";
    Button btn_stream_lyrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming_main);


        this.InitializeView();
        this.SetListener();


        music = MediaPlayer.create(this, R.raw.music);
        music.setLooping(true);

        btn_stream_play_stop1 = (Button) findViewById(R.id.stream_play_stop1);
        seekbar = (SeekBar) findViewById(R.id.seekBar1);

        seekbar.setMax(music.getDuration());

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {

                if(fromUser)
                    music.seekTo(progress);
            }
        });
    }


    public void button(View v){

        if(music.isPlaying()){

            music.pause();

            btn_stream_play_stop1.setText(R.string.stream_play);
        }else{
            music.start();
            btn_stream_play_stop1.setText(R.string.stream_stop);
            Thread();
        }
    }


    public void Thread(){
        Runnable task = new Runnable(){
            public void run(){

                while(music.isPlaying()){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    seekbar.setProgress(music.getCurrentPosition());
                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }





    public void InitializeView() {
        btn_mini_playList = findViewById(R.id.mini_playlist_btn);
        btn_mini_home = findViewById(R.id.mini_home_btn);
        btn_stream_lyrics = (Button)findViewById(R.id.stream_page_lyrics_btn);
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
                    case R.id.mini_playlist_btn:
                        Intent intent_mini_playlist_btn = new Intent(getApplicationContext(), StreamingSongList.class);
                        startActivity(intent_mini_playlist_btn);
                        break;

                    case R.id.stream_page_lyrics_btn:
                        Intent intent_stream_lyrics = new Intent(getApplicationContext(), StreamingSongLyrics.class);
                        startActivity(intent_stream_lyrics);
                        break;
                    default:
                        break;
                }
            }
        };
        btn_mini_home.setOnClickListener(Listener);
        btn_mini_playList.setOnClickListener(Listener);
        btn_stream_lyrics.setOnClickListener(Listener);
    }

}






