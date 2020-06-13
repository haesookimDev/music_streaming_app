package com.example.myapplication_scroll;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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


    Button btn_play;
    Button btn_pre1;
    Button btn_next1;


    MediaPlayer mediaPlayer;
    int[] array = {R.raw.nct_um,R.raw.yeong_be,R.raw.nct_hero,R.raw.yeong_st};
    int index = 0;


    ImageView img1;
    int imgs[] = {R.drawable.boy1_kickit, R.drawable.boy2_music1, R.drawable.boy1_kickit, R.drawable.boy2_music2};
    int cnt = 0;


    TextView tex;
    int title[] = {R.string.nct_love_song,R.string.album_name5,R.string.nct_kick_it,R.string.yeong_elevator};
    int text = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        deleteDialogStatus(); //다이얼로그 한번만 보기 선택후 종료후 데이터 지워서 다시 팝업 실행
        openDialog();
        this.InitializeView();
        this.SetListener();

        mRecyclerView = findViewById(R.id.main_popular_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        MusicListDBManager musicDB = MusicListDBManager.getInstance(this);
        ArrayList<Mainpopularlist_Info> mainpopularlistInfoArrayList = new ArrayList<>();
        mainpopularlistInfoArrayList.add(new Mainpopularlist_Info(R.drawable.boy1_kickit,"1", "영웅","NCT127"));
        mainpopularlistInfoArrayList.add(new Mainpopularlist_Info(R.drawable.boy2_music1,"2", "이제 나만 믿어요","임영웅"));
        mainpopularlistInfoArrayList.add(new Mainpopularlist_Info(R.drawable.boy2_music2,"3", "계단말고 엘리베이터","임영웅"));
        mainpopularlistInfoArrayList.add(new Mainpopularlist_Info(R.drawable.boy1_kickit,"4", "day dream","NCT127"));
        Mainpopularlist_adapter mainpopularlistadapter = new Mainpopularlist_adapter(mainpopularlistInfoArrayList);

        mRecyclerView.setAdapter(mainpopularlistadapter);


        //#------------------------------------------


        btn_pre1 = (Button)findViewById(R.id.album_name1);
        btn_next1 = (Button)findViewById(R.id.album_name2);
        btn_play = (Button)findViewById(R.id.stream_play_stop);


        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.nct_um);


        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    btn_play.setText("재생");

                }else{
                    //getApplicationContext() 현재 액티비티 정보얻어오기
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), array[index]);
                    mediaPlayer.start();
                    btn_play.setText("정지");
                }
            }
        });



        btn_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
//                    index+=1;
                    if(index<array.length-1){
                        mediaPlayer.setAudioSessionId(array[++index]);
                    }
                    if (cnt<imgs.length-1) {
                        img1.setImageResource(imgs[++cnt]);
                    }
                    if (text<title.length-1) {
                        tex.setText(title[++text]);
                    }
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), array[index]);
                    mediaPlayer.start();

                }else{
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.activity_toast,(ViewGroup)findViewById(R.id.toast_frame));
                    TextView t_title = (TextView)layout.findViewById(R.id.text);
                    t_title.setText("재생중이 아닙니다!");
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0,350);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();
                }

            }

        });

        btn_pre1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
//                    index-=1;
                    if(index > 0){
                        mediaPlayer.setAudioSessionId(array[--index]);
                    }
                    if (cnt > 0) {
                        img1.setImageResource(imgs[--cnt]);
                    }
                    if (text > 0) {
                        tex.setText(title[--text]);
                    }
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), array[index]);
                    mediaPlayer.start();
                }else{
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.activity_toast,(ViewGroup)findViewById(R.id.toast_frame));
                    TextView t_title = (TextView)layout.findViewById(R.id.text);
                    t_title.setText("재생중이 아닙니다!");
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0,350);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();
                }

            }
        });

        img1 = (ImageView)findViewById(R.id.player_songimage);
        tex = (TextView)findViewById(R.id.player_songname);


    }





    public void InitializeView() {
        btn_main_search = (Button) findViewById(R.id.main_search_btn1);
        btn_favorite1 = (ImageButton) findViewById(R.id.favorite_btn1);
        btn_favorite2 = (ImageButton) findViewById(R.id.favorite_btn2);
        btn_arrow = (ImageButton) findViewById(R.id.arrow_btn);
        btn_popular_chart = (Button) findViewById(R.id.popular_chart);
        btn_streaming  = (Button)findViewById(R.id.Play_S_name);
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
                    case R.id.Play_S_name:
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
        View mView = getLayoutInflater().inflate(R.layout.activity_pop_up, null);
        CheckBox mCheckBox = mView.findViewById(R.id.checkBox);
        alertDialogBuilder.setView(mView);
        alertDialogBuilder.setPositiveButton("방법 도전하기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent intent_tuto = new Intent(getApplicationContext(), TutorialMainActivity.class);
                startActivity(intent_tuto);
            }
        });
        alertDialogBuilder.setNegativeButton("이 창 닫기",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    storeDialogStatus(true);
                }else{
                    storeDialogStatus(false);
                }
            }
        });
        if(getDialogStatus()){
            alertDialog.hide();
        }else{
            alertDialog.show();
        }
    }
    private void storeDialogStatus(boolean isChecked){
        SharedPreferences mSharedPreferences = getSharedPreferences("CheckItem", MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putBoolean("item", isChecked);
        mEditor.apply();
    }
    private boolean getDialogStatus(){
        SharedPreferences mSharedPreferences = getSharedPreferences("CheckItem", MODE_PRIVATE);
        return mSharedPreferences.getBoolean("item", false);
    }
    private void deleteDialogStatus(){
        SharedPreferences mSharedPreferences = getSharedPreferences("CheckItem", MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.clear();
        mEditor.commit();
    }

}