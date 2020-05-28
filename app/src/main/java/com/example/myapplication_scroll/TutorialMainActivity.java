package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class TutorialMainActivity extends AppCompatActivity {

    Button btn_mini_home;

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_main);
        
        this.MakeTheView();
        this.InitializeView();
        this.SetListener();
    }

    public void InitializeView() {
        btn_mini_home = findViewById(R.id.mini_home_btn);
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
                    default:
                        break;
                }
            }
        };

        btn_mini_home.setOnClickListener(Listener);
    }
    public void MakeTheView(){
        mRecyclerView = findViewById(R.id.tutorial_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Tutorial_op_Info> tutorial_InfoArrayList = new ArrayList<>();
        tutorial_InfoArrayList.add(new Tutorial_op_Info(R.drawable.tuto_popular, R.string.tuto_op1));
        tutorial_InfoArrayList.add(new Tutorial_op_Info(R.drawable.tuto_song, R.string.tuto_op2));
        tutorial_InfoArrayList.add(new Tutorial_op_Info(R.drawable.tuto_singer, R.string.tuto_op3));
        tutorial_InfoArrayList.add(new Tutorial_op_Info(R.drawable.tuto_delete, R.string.tuto_op4));
        Tutorial_op_Adapter tutorial_adapter = new Tutorial_op_Adapter(tutorial_InfoArrayList);

        mRecyclerView.setAdapter(tutorial_adapter);
    }
}