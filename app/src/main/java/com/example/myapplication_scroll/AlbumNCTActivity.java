package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class AlbumNCTActivity extends AppCompatActivity {
    Button btn_mini_home;
    Button btn_mini_search;

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_nct);
        this.InitializeView();
        this.SetListener();

        mRecyclerView = findViewById(R.id.album_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Albumlist_Info> albumlistInfoArrayList = new ArrayList<>();
        albumlistInfoArrayList.add(new Albumlist_Info("01", "Elevator(127F)"));
        albumlistInfoArrayList.add(new Albumlist_Info("02", "영웅 (英雄; Kick It)"));
        albumlistInfoArrayList.add(new Albumlist_Info("03", "Day Dream(白日夢)"));

        Albumlist_adapter albumlistadapter = new Albumlist_adapter(albumlistInfoArrayList);

        mRecyclerView.setAdapter(albumlistadapter);
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
                        Intent intent_main = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent_main);
                        break;
                    case R.id.mini_search_btn:
                        Intent intent_search = new Intent(getApplicationContext(),SearchActivity.class);
                        startActivity(intent_search);
                        break;
                    default:
                        break;
                }
            }
        };

        btn_mini_home.setOnClickListener(Listener);
        btn_mini_search.setOnClickListener(Listener);
    }
}
