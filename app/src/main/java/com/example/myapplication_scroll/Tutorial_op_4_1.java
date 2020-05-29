package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tutorial_op_4_1 extends AppCompatActivity {

    Button btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_op_4_1);

        this.InitializeView();
        this.SetListener();
    }
    public void InitializeView() {
        btn_ok = (Button) findViewById(R.id.tuto_ok_btn);
    }

    public void SetListener() {
        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.tuto_ok_btn:
                        Intent intent_tuto_op4_2 = new Intent(getApplicationContext(),Tutorial_op_4_2.class);
                        startActivity(intent_tuto_op4_2);
                        break;
                    default:
                        break;
                }
            }
        };
        btn_ok.setOnClickListener(Listener);
    }
}