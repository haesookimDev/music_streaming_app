package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Popular_Song_Activity extends AppCompatActivity {
    Button btn_mini_home;
    Button btn_mini_search;
    Button btn_select_play;
    Button btn_all_play;
//    Button btn_music_1;
    MusicListDBManager musicDBManager;


    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    Popularlist_adapter popularlist_adapter;
    ArrayList<Popularlist_Info> popularlist_InfoArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_song);
        musicDBManager = MusicListDBManager.getInstance(this);

        this.InitializeView();
        this.SetListener();

        mRecyclerView = findViewById(R.id.popular_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        popularlist_InfoArrayList.add(new Popularlist_Info("1",R.drawable.boy1_kickit, "영웅","NCT127"));
        popularlist_InfoArrayList.add(new Popularlist_Info("2",R.drawable.boy1_cherry, "Cherry Bomb","NCT127"));
        popularlist_InfoArrayList.add(new Popularlist_Info("3",R.drawable.boy2_music1, "이제 나만 믿어요","임영웅"));
        popularlist_InfoArrayList.add(new Popularlist_Info("4",R.drawable.boy1_kickit, "Elevator(127F)","NCT127"));
        popularlist_InfoArrayList.add(new Popularlist_Info("5",R.drawable.mr_trot, "어느 60대 노부부이야기","임영웅"));
        popularlist_InfoArrayList.add(new Popularlist_Info("6",R.drawable.boy1_kickit, "꿈(boom)","NCT127"));
        popularlist_InfoArrayList.add(new Popularlist_Info("7",R.drawable.lovecall, "상사화","임영웅"));
        popularlist_InfoArrayList.add(new Popularlist_Info("8",R.drawable.boy1_kickit, "Day dream","NCT127"));
        popularlist_InfoArrayList.add(new Popularlist_Info("9",R.drawable.mr_trot, "바램","임영웅"));
        popularlist_InfoArrayList.add(new Popularlist_Info("10",R.drawable.boy1_kickit, "우산(Love Song)","NCT127"));
        popularlist_adapter = new Popularlist_adapter(popularlist_InfoArrayList);

        mRecyclerView.setAdapter(popularlist_adapter);
    }
    public void InitializeView() {
        btn_mini_home = (Button) findViewById(R.id.mini_home_btn);
        btn_mini_search = (Button) findViewById(R.id.mini_search_btn);
        btn_all_play = findViewById(R.id.all_play);
        btn_select_play = findViewById(R.id.select_play);

    }

    public void SetListener() {
        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues addRowValue = new ContentValues();
                switch (view.getId()) {
                    case R.id.mini_home_btn:
                        Intent intent_main = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent_main);
                        break;
                    case R.id.mini_search_btn:
                        Intent intent_search = new Intent(getApplicationContext(), SearchActivity.class);
                        startActivity(intent_search);
                        break;
                    case R.id.all_play:
                        int count1 = popularlist_adapter.getItemCount();

                        for (int i = count1-1; i >= 0; i--) {
                            addRowValue.put("singer", popularlist_InfoArrayList.get(i).singer);
                            addRowValue.put("album", "");
                            addRowValue.put("title", popularlist_InfoArrayList.get(i).song);
                            musicDBManager.insert(addRowValue);
                        }
                    case R.id.select_play:
                        SparseBooleanArray checkedItems = popularlist_adapter.getMSelectedItem();
                        int count2 = popularlist_adapter.getItemCount();

                        for (int i = count2-1; i >= 0; i--) {
                            if (checkedItems.get(i)) {
                                addRowValue.put("singer", popularlist_InfoArrayList.get(i).singer);
                                addRowValue.put("album", "");
                                addRowValue.put("title", popularlist_InfoArrayList.get(i).song);
                                musicDBManager.insert(addRowValue);
                            }
                        }
                        for (int i = count2-1; i >= 0; i--)
                            popularlist_adapter.setMSelectedItem(i, false);
                        popularlist_adapter.notifyDataSetChanged();
//                    case R.id.popular_chart_music_1:
//                        Intent intent_music_1_album = new Intent(getApplicationContext(), AlbumYEONGActivity.class);
//                        startActivity(intent_music_1_album);
//                        break;

                    default:
                        break;
                }
            }
        };

        btn_mini_home.setOnClickListener(Listener);
        btn_mini_search.setOnClickListener(Listener);
        btn_select_play.setOnClickListener(Listener);
        btn_all_play.setOnClickListener(Listener);
//        btn_music_1.setOnClickListener(Listener);

    }
}
