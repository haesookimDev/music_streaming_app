package com.example.myapplication_scroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tutorial_op_3_2 extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_op_3_2);

        this.InitializeView();
        this.SetListener();
    }
    public void InitializeView() {
        btn = (Button)findViewById(R.id.button_go_op3_3);
    }

    public void SetListener() {
        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_go_op3_3:
                        Intent intent_tuto_op3_3 = new Intent(getApplicationContext(),Tutorial_op_3_3.class);
                        startActivity(intent_tuto_op3_3);
                        break;
                    default:
                        break;
                }
            }
        };
        btn.setOnClickListener(Listener);
    }
}
