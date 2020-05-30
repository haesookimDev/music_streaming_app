package com.example.myapplication_scroll;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_popular_chart;
    Button btn_main_search;
    ImageButton btn_favorite1;
    ImageButton btn_favorite2;
    ImageButton  btn_arrow;
    Button btn_streaming;
    Button tuto;

    int i = 0;

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        openDialog();

        this.InitializeView();
        this.SetListener();

        mRecyclerView = findViewById(R.id.main_popular_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Mainpopularlist_Info> mainpopularlistInfoArrayList = new ArrayList<>();
        mainpopularlistInfoArrayList.add(new Mainpopularlist_Info(R.drawable.boy1_kickit,"1", "영웅","NCT127"));
        mainpopularlistInfoArrayList.add(new Mainpopularlist_Info(R.drawable.boy2_music1,"2", "이제 나만 믿어요","임영웅"));
        mainpopularlistInfoArrayList.add(new Mainpopularlist_Info(R.drawable.boy2_music2,"3", "계단말고 엘리베이터","임영웅"));
        mainpopularlistInfoArrayList.add(new Mainpopularlist_Info(R.drawable.boy1_kickit,"4", "day dream","NCT127"));
        Mainpopularlist_adapter mainpopularlistadapter = new Mainpopularlist_adapter(mainpopularlistInfoArrayList);

        mRecyclerView.setAdapter(mainpopularlistadapter);
    }

    public void InitializeView() {
        btn_main_search = (Button) findViewById(R.id.main_search_btn1);
        btn_favorite1 = (ImageButton) findViewById(R.id.favorite_btn1);
        btn_favorite2 = (ImageButton) findViewById(R.id.favorite_btn2);
        btn_arrow = (ImageButton) findViewById(R.id.arrow_btn);
        btn_popular_chart = (Button) findViewById(R.id.popular_chart);
        btn_streaming  = (Button)findViewById(R.id.streaming_main_btn);
        tuto = (Button)findViewById(R.id.tuto_test_btn);

    }

    public void SetListener() {
        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.popular_chart:
                        Intent intent_popular_chart = new Intent(getApplicationContext(),Popular_Song_Activity.class);
                        startActivity(intent_popular_chart);
                        break;
                    case R.id.main_search_btn1:
                        Intent intent_search = new Intent(getApplicationContext(),SearchActivity.class);
                        startActivity(intent_search);
                        break;
                    case R.id.favorite_btn1:
                        Intent intent_favorite = new Intent(getApplicationContext(), ArtistYEONGActivity.class);
                        startActivity(intent_favorite);
                        break;
                    case R.id.favorite_btn2:
                        Intent intent_favorite2 = new Intent(getApplicationContext(), ArtistNCTActivity.class);
                        startActivity(intent_favorite2);
                        break;
                    case  R.id.tuto_test_btn:
                        Intent intent_tuto = new Intent(getApplicationContext(), TutorialMainActivity.class);
                        startActivity(intent_tuto);
                        break;
                    case R.id.arrow_btn:
                        i = 1-i;
                        if(i==0){
                            btn_favorite2.setVisibility(View.VISIBLE);
                            btn_favorite1.setVisibility(View.INVISIBLE);
                        }else{
                            btn_favorite1.setVisibility(View.VISIBLE);
                            btn_favorite2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case R.id.streaming_main_btn:
                        Intent intent_streaming_main = new Intent(getApplicationContext(), StreamingMain.class);
                        startActivity(intent_streaming_main);
                        break;
                    default:
                        break;
                }
            }
        };
        btn_popular_chart.setOnClickListener(Listener);
        btn_main_search.setOnClickListener(Listener);
        btn_favorite1.setOnClickListener(Listener);
        btn_favorite2.setOnClickListener(Listener);
        btn_arrow.setOnClickListener(Listener);
        btn_streaming.setOnClickListener(Listener);
        tuto.setOnClickListener(Listener);
    }

    public void openDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this,R.style.MyAlertDialogStyle);
        alertDialogBuilder.setView(R.layout.activity_pop_up);

        alertDialogBuilder.setPositiveButton("방법 도전하기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent intent_tuto = new Intent(getApplicationContext(), TutorialMainActivity.class);
                startActivity(intent_tuto);
            }

        });

        alertDialogBuilder.setNegativeButton("닫기",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}

