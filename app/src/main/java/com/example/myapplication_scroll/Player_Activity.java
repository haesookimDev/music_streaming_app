package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Player_Activity extends Fragment {

    Button btn_play;
    Button btn_pre1;
    Button btn_next1;


    MediaPlayer mediaPlayer;
    int[] array = {R.raw.nct_um,R.raw.yeong_be,R.raw.nct_hero,R.raw.yeong_st};
    int index = 0;


    ImageView img1;
    int imgs[] = {R.drawable.image1,R.drawable.yeong2,R.drawable.nct1,R.drawable.yeong1};
    int cnt = 0;


    TextView tex;
    int title[] = {R.string.nct_love_song,R.string.album_name5,R.string.nct_kick_it,R.string.yeong_elevator};
    int text = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myLayout = inflater.inflate(R.layout.activity_player, container, false);

        btn_pre1 = myLayout.findViewById(R.id.album_name1);
        btn_next1 = myLayout.findViewById(R.id.album_name2);
        btn_play = myLayout.findViewById(R.id.stream_play_stop);

        mediaPlayer = MediaPlayer.create(getActivity(),R.raw.nct_um);


        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    btn_play.setText("재생");

                }else{
                    //getApplicationContext() 현재 액티비티 정보얻어오기
                    mediaPlayer = MediaPlayer.create(getActivity(), array[index]);
                    mediaPlayer.start();
                    btn_play.setText("정지");
                }
            }
        });



        btn_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    //index+=1;
                    if(index<array.length-1){
                        mediaPlayer.setAudioSessionId(array[++index]);
                    }
                    if (cnt<imgs.length-1) {
                        img1.setImageResource(imgs[++cnt]);
                    }
                    if (text<title.length-1) {
                        tex.setText(title[++text]);
                    }
                    mediaPlayer = MediaPlayer.create(getActivity(), array[index]);
                    mediaPlayer.start();

                }else{
                    Toast.makeText(getActivity(), "재생중이 아닙니다",Toast.LENGTH_LONG).show();
                }

            }

        });

        btn_pre1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    //index-=1;
                    if(index > 0){
                        mediaPlayer.setAudioSessionId(array[--index]);
                    }
                    if (cnt > 0) {
                        img1.setImageResource(imgs[--cnt]);
                    }
                    if (text > 0) {
                        tex.setText(title[--text]);
                    }
                    mediaPlayer = MediaPlayer.create(getActivity(), array[index]);
                    mediaPlayer.start();
                }else{
                    Toast.makeText(getActivity(), "재생중이 아닙니다",Toast.LENGTH_LONG).show();
                }

            }
        });

        img1 = myLayout.findViewById(R.id.player_songimage);
        tex = myLayout.findViewById(R.id.player_songname);

        return myLayout;
    }


}


