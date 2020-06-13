package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumNCTActivity extends AppCompatActivity {
    private static String TAG;
    Button btn_mini_home;
    Button btn_mini_search;
    Button btn_select_play;
    Button btn_all_play;
    private ApiService service;
    TextView textAlbumName;
    Albumlist_adapter albumlistadapter;

    MusicListDBManager musicDBManager;
    ArrayList<Playlist_Info> playlistInfoArrayList = new ArrayList<>();
    Playlist_adapter playlistadapter = new Playlist_adapter(playlistInfoArrayList);

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Albumlist_Info> albumlistInfoArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_nct);
        musicDBManager = MusicListDBManager.getInstance(this);
        service = RetrofitClient.getClient().create(ApiService.class);
        this.InitializeView();
        this.SetListener();

        mRecyclerView = findViewById(R.id.album_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        albumData();
        songData();
    }

    public void InitializeView() {
        btn_mini_home = (Button) findViewById(R.id.mini_home_btn);
        btn_mini_search = (Button) findViewById(R.id.mini_search_btn);
        btn_all_play = findViewById(R.id.all_play);
        btn_select_play = findViewById(R.id.select_play);
        TAG = "MainActivity";

        textAlbumName = findViewById(R.id.album_name1);


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
                    case R.id.all_play:
                        int count1 = albumlistadapter.getItemCount();

                        for (int i = count1-1; i >= 0; i--) {
                            addRowValue.put("singer", "NCT127");
                            addRowValue.put("album", "NCT #127 Neo Zone - The 2nd Album");
                            addRowValue.put("title", albumlistInfoArrayList.get(i).song);
                            musicDBManager.insert(addRowValue);
                        }
                    case R.id.select_play:
                        SparseBooleanArray checkedItems = albumlistadapter.getMSelectedItem();
                        int count2 = albumlistadapter.getItemCount();

                        for (int i = count2-1; i >= 0; i--) {
                            if (checkedItems.get(i)) {
                                addRowValue.put("singer", "NCT127");
                                addRowValue.put("album", "NCT #127 Neo Zone - The 2nd Album");
                                addRowValue.put("title", albumlistInfoArrayList.get(i).song);
                                musicDBManager.insert(addRowValue);
                            }
                        }
                        for (int i = count2-1; i >= 0; i--)
                            albumlistadapter.setMSelectedItem(i, false);
                        albumlistadapter.notifyDataSetChanged();
                    default:
                        break;
                }
            }
        };

        btn_mini_home.setOnClickListener(Listener);
        btn_mini_search.setOnClickListener(Listener);
        btn_all_play.setOnClickListener(Listener);
        btn_select_play.setOnClickListener(Listener);
    }

    private void albumData(){
        service.getNCTAlbumData().enqueue(new Callback<AlbumModel>() {
            @Override
            public void onResponse(Call<AlbumModel> call, Response<AlbumModel> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "response is success");
                    AlbumModel albumModel = response.body();
                    if (albumModel != null) {
                        textAlbumName.setText(albumModel.getSAlbumName());
                    } else {
                        Log.d(TAG, "NameSinger is null");
                    }
                } else {
                    int statusCode  = response.code();
                    Log.d(TAG, String.valueOf(statusCode));
                }
            }

            @Override
            public void onFailure(Call<AlbumModel> call, Throwable t) {
                Log.d(TAG, "error loading from API" + t);
            }
        });
    }

    private void songData(){
        service.getNCTSongData().enqueue(new Callback<List<SongModel>>() {
            @Override
            public void onResponse(Call<List<SongModel>> call, Response<List<SongModel>> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "response is success");
                    List<SongModel> songModel = response.body();
                    if (songModel != null) {
                        for (int i = 0; i < songModel.size(); i++){
                            albumlistInfoArrayList.add(new Albumlist_Info(songModel.get(i).getIdSSong(), songModel.get(i).getSSongName()));
                        }
                        albumlistadapter = new Albumlist_adapter(albumlistInfoArrayList);

                        mRecyclerView.setAdapter(albumlistadapter);
                    } else {
                        Log.d(TAG, "NameSinger is null");
                    }
                } else {
                    int statusCode  = response.code();
                    Log.d(TAG, String.valueOf(statusCode));
                }
            }

            @Override
            public void onFailure(Call<List<SongModel>> call, Throwable t) {
                Log.d(TAG, "error loading from API" + t);
            }
        });
    }
}
