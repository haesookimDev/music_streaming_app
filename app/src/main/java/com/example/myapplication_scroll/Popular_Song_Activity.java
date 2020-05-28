package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Popular_Song_Activity extends AppCompatActivity {
    Button btn_mini_home;
    Button btn_mini_search;
//    Button btn_music_1;


    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_song);

        this.InitializeView();
        this.SetListener();

        mRecyclerView = findViewById(R.id.popular_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Popularlist_Info> popularlist_InfoArrayList = new ArrayList<>();
        popularlist_InfoArrayList.add(new Popularlist_Info("1",R.drawable.boy1_kickit, "영웅","NCT127"));
        popularlist_InfoArrayList.add(new Popularlist_Info("2",R.drawable.boy1_cherry, "Cherry Bomb","NCT127"));

        Popularlist_adapter popularlist_adapter = new Popularlist_adapter(popularlist_InfoArrayList);

        mRecyclerView.setAdapter(popularlist_adapter);
    }
    public void InitializeView() {
        btn_mini_home = (Button) findViewById(R.id.mini_home_btn);
        btn_mini_search = (Button) findViewById(R.id.mini_search_btn);

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
                    case R.id.mini_search_btn:
                        Intent intent_search = new Intent(getApplicationContext(), SearchActivity.class);
                        startActivity(intent_search);
                        break;
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
//        btn_music_1.setOnClickListener(Listener);

    }
}
