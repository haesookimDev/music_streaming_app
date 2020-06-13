package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class StreamingSongList extends AppCompatActivity {
    Button btn_mini_home;
    Button btn_mini_play;
    Button btn_del_music;

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    ArrayList<String> musicList;
    MusicListDBManager musicDBManager;
    ArrayList<Playlist_Info> playlistInfoArrayList = new ArrayList<>();
    Playlist_adapter playlistadapter = new Playlist_adapter(playlistInfoArrayList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming_song_list);
        musicDBManager = MusicListDBManager.getInstance(this);
        this.getMusicData();
        this.InitializeView();
        this.SetListener();

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mRecyclerView.setAdapter(playlistadapter);

    }

    public void InitializeView() {
        btn_mini_home = findViewById(R.id.mini_home_btn);
        btn_mini_play = findViewById(R.id.mini_play_btn);
        btn_del_music = findViewById(R.id.delete_lay);
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
                    case R.id.delete_lay:
                        SparseBooleanArray checkedItems = playlistadapter.getMSelectedItem();
                        int count = playlistadapter.getItemCount();

                        for (int i = count-1; i >= 0; i--) {
                            if (checkedItems.get(i)) {
                                int n = playlistInfoArrayList.get(i)._id;
                                musicDBManager.delete(n);
                            }
                        }
                        for (int i = count-1; i >= 0; i--)
                            playlistadapter.setMSelectedItem(i, false);
                        playlistInfoArrayList.clear();
                        getMusicData();
                        playlistadapter.notifyDataSetChanged();
                        mRecyclerView.setAdapter(playlistadapter);
                        break;
                    default:
                        break;
                }
            }
        };
        btn_mini_home.setOnClickListener(Listener);
        btn_mini_play.setOnClickListener(Listener);
        btn_del_music.setOnClickListener(Listener);


    }

    public void getMusicData(){
        musicList = new ArrayList<>();

        String[] columns = new String[] {"_idPlayList", "singer", "album", "title"};

        Cursor cursor = musicDBManager.query(columns, null, null, null, null, null);

        if(cursor != null){
            while(cursor.moveToNext()){
                if (cursor.getString(1).equals("NCT127")) {
                    Playlist_Info currentData = new Playlist_Info(R.drawable.boy1_kickit, cursor.getString(3), cursor.getString(1), cursor.getInt(0));
                    playlistInfoArrayList.add(currentData);
                } else if (cursor.getString(3).equals("이제 나만 믿어요")){
                    Playlist_Info currentData = new Playlist_Info(R.drawable.boy2_music1, cursor.getString(3), cursor.getString(1), cursor.getInt(0));
                    playlistInfoArrayList.add(currentData);
                } else if (cursor.getString(3).equals("상사화")) {
                    Playlist_Info currentData = new Playlist_Info(R.drawable.lovecall, cursor.getString(3), cursor.getString(1), cursor.getInt(0));
                    playlistInfoArrayList.add(currentData);
                } else if ((cursor.getString(3).equals("바램"))|| (cursor.getString(3).equals("어느 60대 노부부이야기"))) {
                    Playlist_Info currentData = new Playlist_Info(R.drawable.mr_trot, cursor.getString(3), cursor.getString(1), cursor.getInt(0));
                    playlistInfoArrayList.add(currentData);
                }
            }
        }
    }
}
