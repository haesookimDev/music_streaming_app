package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_search;
    ImageButton btn_favorite1;
    ImageButton btn_favorite2;
    ImageButton  btn_arrow;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializeView();
        this.SetListener();
    }

    public void InitializeView() {
        btn_search = (Button) findViewById(R.id.search_btn1);
        btn_favorite1 = (ImageButton) findViewById(R.id.favorite_btn1);
        btn_favorite2 = (ImageButton) findViewById(R.id.favorite_btn2);
        btn_arrow = (ImageButton) findViewById(R.id.arrow_btn);
    }

    public void SetListener() {
        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.search_btn1:
                        Intent intent_search = new Intent(getApplicationContext(),SearchActivity.class);
                        startActivity(intent_search);
                        break;
                    case R.id.favorite_btn1:
                        Intent intent_favorite = new Intent(getApplicationContext(),Favorite1Activity.class);
                        startActivity(intent_favorite);
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
                }
            }
        };

        btn_search.setOnClickListener(Listener);
        btn_favorite1.setOnClickListener(Listener);
        btn_arrow.setOnClickListener(Listener);
    }
}

