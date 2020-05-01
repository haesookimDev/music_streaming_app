package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {
    Button btn_search;
    EditText text_search;
    String favorite1 = "NCT127";
    String favorite2 = "임영웅";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        this.InitializeView();
        this.SetListener();
    }

    public void InitializeView() {
        btn_search = (Button) findViewById(R.id.search_btn);
        text_search = (EditText)findViewById(R.id.search_text);

    }
    public void SetListener() {
        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.search_btn:
                        String value_search = text_search.getText().toString();
                        if(favorite1.equals(value_search)){
                            Intent intent_favorite2 = new Intent(getApplicationContext(),Favorite2Activity.class);
                            startActivity(intent_favorite2);
                        }
                        if(favorite2.equals(value_search)){
                            Intent intent_favorite1 = new Intent(getApplicationContext(),Favorite1Activity.class);
                            startActivity(intent_favorite1);
                        }
                }
            }
        };
        btn_search.setOnClickListener(Listener);
    }
}
