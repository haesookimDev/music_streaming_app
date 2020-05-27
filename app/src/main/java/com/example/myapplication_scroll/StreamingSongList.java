package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class StreamingSongList extends AppCompatActivity {
    Button btn_mini_home;
    Button btn_mini_play;

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming_song_list);

        this.InitializeView();
        this.SetListener();

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Playlist_Info> playlistInfoArrayList = new ArrayList<>();
        playlistInfoArrayList.add(new Playlist_Info(R.drawable.boy1_kickit, "영웅","NCT127"));
        playlistInfoArrayList.add(new Playlist_Info(R.drawable.boy1_cherry, "Cherry Bom","NCT127"));

        Playlist_adapter playlistadapter = new Playlist_adapter(playlistInfoArrayList);

        mRecyclerView.setAdapter(playlistadapter);

    }

    public void InitializeView() {
        btn_mini_home = findViewById(R.id.mini_home_btn);
        btn_mini_play = findViewById(R.id.mini_play_btn);
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
                    case R.id.mini_play_btn:
                        Intent intent_play = new Intent(getApplicationContext(), StreamingMain.class);
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
