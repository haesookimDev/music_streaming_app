package com.example.myapplication_scroll;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class StreamingMain extends Activity {

    Button btn_mini_playList;
    Button btn_mini_home;
    int i = 0;

    Button btn_stream_play_stop1;
    SeekBar seekbar;
    MediaPlayer music;
    String strColorplay = "#ff691bf3";
    String strColorstop = "#fff63e4b";
    Button btn_stream_lyrics;


    Button btn_pre;
    Button btn_next;


    MediaPlayer mediaPlayer;
    int[] array = {R.raw.nct_um, R.raw.yeong_be, R.raw.nct_hero, R.raw.yeong_st};
    int index = 0;


    ImageView img1;
    int imgs[] = {R.drawable.image1, R.drawable.yeong2, R.drawable.nct1, R.drawable.yeong1};
    int cnt = 0;


    TextView tex;
    int title[] = {R.string.nct_love_song, R.string.album_name5, R.string.nct_kick_it, R.string.yeong_elevator};
    int text = 0;


    TextView tex1;
    int singer[] = {R.string.nct127, R.string.yeong, R.string.nct127, R.string.yeong};
    int text1 = 0;


    TextView tex2;
    int lyrics[] = {R.string.strem_song, R.string.trust, R.string.nct_hero_li, R.string.yeong_es};
    int text2 = 0;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming_main);


        this.InitializeView();
        this.SetListener();


        btn_pre = (Button) findViewById(R.id.strem_before);
        btn_next = (Button) findViewById(R.id.strem_nex);


        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.nct_um);


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    //index+=1;
                    if (index < array.length - 1) {
                        mediaPlayer.setAudioSessionId(array[++index]);
                    }
                    if (cnt < imgs.length - 1) {
                        img1.setImageResource(imgs[++cnt]);
                    }
                    if (text < title.length - 1) {
                        tex.setText(title[++text]);
                    }
                    if (text1 < singer.length - 1) {
                        tex1.setText(singer[++text1]);
                    }
                    if (text2 < lyrics.length - 1) {
                        tex2.setText(lyrics[++text2]);
                    }

                    mediaPlayer = MediaPlayer.create(getApplicationContext(), array[index]);
                    mediaPlayer.start();

                } else {
                    Toast.makeText(getApplicationContext(), "재생중이 아닙니다", Toast.LENGTH_LONG).show();
                }

            }

        });

        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    //index-=1;
                    if (index > 0) {
                        mediaPlayer.setAudioSessionId(array[--index]);
                    }
                    if (cnt > 0) {
                        img1.setImageResource(imgs[--cnt]);
                    }
                    if (text > 0) {
                        tex.setText(title[--text]);
                    }
                    if (text1 > 0) {
                        tex1.setText(singer[--text1]);
                    }
                    if (text2 > 0) {
                        tex2.setText(lyrics[--text2]);
                    }
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), array[index]);
                    mediaPlayer.start();
                } else {
                    Toast.makeText(getApplicationContext(), "재생중이 아닙니다", Toast.LENGTH_LONG).show();
                }

            }
        });

        img1 = (ImageView) findViewById(R.id.strem_album_um);
        tex = (TextView) findViewById(R.id.text9);
        tex1 = (TextView) findViewById(R.id.text8);
        tex2 = (TextView) findViewById(R.id.strem_song);



        mediaPlayer.setLooping(true);

        btn_stream_play_stop1 = (Button) findViewById(R.id.stream_play_stop1);
        seekbar = (SeekBar) findViewById(R.id.seekBar1);

        seekbar.setMax(mediaPlayer.getDuration());

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

                if (fromUser)
                    mediaPlayer.seekTo(progress);
            }
        });

    }

    public void button(View v) {

        if (mediaPlayer.isPlaying()) {

            mediaPlayer.pause();

            btn_stream_play_stop1.setText(R.string.stream_play);
        } else {
            mediaPlayer.start();
            btn_stream_play_stop1.setText(R.string.stream_stop);
            Thread();
        }
    }


    public void Thread() {
        Runnable task = new Runnable() {
            public void run() {

                while (mediaPlayer.isPlaying()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    seekbar.setProgress(mediaPlayer.getCurrentPosition());
                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }










    @SuppressLint("ResourceType")
    public void InitializeView() {
        btn_mini_playList = findViewById(R.id.mini_playlist_btn);
        btn_mini_home = findViewById(R.id.mini_home_btn);
        btn_stream_lyrics = (Button)findViewById(R.id.strem_song);

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

                    case R.id.strem_song:
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






