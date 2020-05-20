package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    Button btn_popular_chart;
    Button btn_main_search;
    ImageButton btn_favorite1;
    ImageButton btn_favorite2;
    ImageButton  btn_arrow;
    Button btn_streaming;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializeView();
        this.SetListener();
    }

    public void InitializeView() {
        btn_main_search = (Button) findViewById(R.id.main_search_btn1);
        btn_favorite1 = (ImageButton) findViewById(R.id.favorite_btn1);
        btn_favorite2 = (ImageButton) findViewById(R.id.favorite_btn2);
        btn_arrow = (ImageButton) findViewById(R.id.arrow_btn);
        btn_popular_chart = (Button) findViewById(R.id.popular_chart);
        btn_streaming  = (Button)findViewById(R.id.streaming_main_btn);
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
    }
}

