package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class databaseActivity extends AppCompatActivity {
    Button btn_clear;
    ArrayList<String> musicList;
    MusicListDBManager musicDBManager;

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    ArrayList<Playlist_Info> playlistInfoArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        musicDBManager = MusicListDBManager.getInstance(this);

        btn_clear = findViewById(R.id.clearDB);

        mRecyclerView = findViewById(R.id.listTest);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        playlistInfoArrayList = new ArrayList<>();
        this.getMusicData();
        Playlist_adapter playlistadapter = new Playlist_adapter(playlistInfoArrayList);

        mRecyclerView.setAdapter(playlistadapter);

        this.InitializeView();
        this.SetListener();
    }

    public void InitializeView() {
        btn_clear = findViewById(R.id.clearDB);
    }

    public void SetListener() {
        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.clearDB:
                        musicDBManager.delete("_idPlayList", null);
                        playlistInfoArrayList.clear();
                        Playlist_adapter playlistadapter = new Playlist_adapter(playlistInfoArrayList);

                        mRecyclerView.setAdapter(playlistadapter);
                        break;
                    default:
                        break;
                }
            }
        };
        btn_clear.setOnClickListener(Listener);

    }

    public void getMusicData(){
        musicList = new ArrayList<>();

        String[] columns = new String[] {"_idPlayList", "singer", "album", "title"};

        Cursor cursor = musicDBManager.query(columns, null, null, null, null, null);

        if(cursor != null){
            while(cursor.moveToNext()){
                Playlist_Info currentData = new Playlist_Info(R.drawable.boy1_kickit, cursor.getString(3), cursor.getString(1));
                playlistInfoArrayList.add(currentData);
            }
        }
    }
}
