package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tutorial_op_3_3 extends AppCompatActivity {

    Button btn_search;
    EditText text_search;
    String favorite2_song = "이제나만믿어요";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_op_3_3);

        this.InitializeView();
        this.SetListener();
    }
    public void InitializeView() {
        btn_search = (Button) findViewById(R.id.button_go_op3_4);
        text_search = (EditText)findViewById(R.id.search_text);
    }

    public void SetListener() {
        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_go_op3_4:
                        String value_search = text_search.getText().toString();
                        if(favorite2_song.equals(value_search)){
                            Intent intent_tuto_op3_4 = new Intent(getApplicationContext(),Tutorial_op_3_4.class);
                            startActivity(intent_tuto_op3_4);
                        }
                        break;
                    default:
                        break;
                }
            }
        };
        btn_search.setOnClickListener(Listener);
    }
}