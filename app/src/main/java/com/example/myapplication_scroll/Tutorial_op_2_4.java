package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tutorial_op_2_4 extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_op_2_4);

        this.InitializeView();
        this.SetListener();
    }
    public void InitializeView() {
        btn = (Button) findViewById(R.id.button_go_op2_5);
    }

    public void SetListener() {
        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_go_op2_5:
                        Intent intent_tuto_go_op2_5 = new Intent(getApplicationContext(),Tutorial_op_1_4.class);
                        startActivity(intent_tuto_go_op2_5);
                        break;
                    default:
                        break;
                }
            }
        };
        btn.setOnClickListener(Listener);
    }
}
