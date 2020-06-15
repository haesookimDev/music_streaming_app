package com.example.myapplication_scroll;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.net.Uri.parse;

public class StreamingMain extends Activity {
    ArrayList<String> musicList;
    MusicListDBManager musicDBManager;
    ArrayList<Playlist_Info> playlistInfoArrayList = new ArrayList<>();
    ArrayList<Albumlist_Info> albumlistInfoArrayList = new ArrayList<>();
    private ApiService service;
    private static String TAG;

    Button btn_mini_playList;
    Button btn_mini_home;

    Button btn_stream_play_stop1;
    SeekBar seekbar;
    String strColorplay = "#ff691bf3";
    String strColorstop = "#fff63e4b";
    Button btn_stream_lyrics;
    String url = "https://music-db.s3-ap-northeast-2.amazonaws.com/";


    Button btn_pre;
    Button btn_next;
    RelativeLayout btn_long_lyrics;

    MediaPlayer mediaPlayer;

    ArrayList<String> fileUri = new ArrayList<>();
    ArrayList<Integer> imgs1 = new ArrayList<>();
    ArrayList<String> title1 =  new ArrayList<>();
    ArrayList<String> singer1 = new ArrayList<>();
    ArrayList<String> lyrics1 = new ArrayList<>();



    int index = 0;


    ImageView img1;
    int cnt = 0;


    TextView tex;
    int text = 0;


    TextView tex1;
    int text1 = 0;


    TextView tex2;
    int text2 = 0;

    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = RetrofitClient.getClient().create(ApiService.class);
        setContentView(R.layout.activity_streaming_main);
        musicDBManager = MusicListDBManager.getInstance(this);
        songNCTData();
        getMusicData();
        this.InitializeView();
        this.SetListener();
        MediaPlayer();
        tex.setText(playlistInfoArrayList.get(text).song);
        tex1.setText(playlistInfoArrayList.get(text1).singer);
    }

    public void MediaPlayer() {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), parse("https://music-db.s3-ap-northeast-2.amazonaws.com/music/Kick_It.mp3"));


        btn_next.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.reset();
                //index+=1;
                if (index < fileUri.size() - 1) {
                    try {
                        mediaPlayer.setDataSource(String.valueOf(parse(fileUri.get(++index))));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (cnt < imgs1.size()- 1) {
                    img1.setImageResource(imgs1.get(++cnt));
                }
                if (text < title1.size() - 1) {
                    tex.setText(title1.get(++text));
                }
                if (text1 < singer1.size() - 1) {
                    tex1.setText(singer1.get(++text1));
                }
                if (text2 < lyrics1.size() - 1) {
                    tex2.setText(lyrics1.get(++text2));
                }

                mediaPlayer = MediaPlayer.create(getApplicationContext(), parse(fileUri.get(index)));
                mediaPlayer.start();

            } else {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.activity_toast,findViewById(R.id.toast_frame));
                TextView t_title = layout.findViewById(R.id.text);
                t_title.setText("재생중이 아닙니다!");
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0,325);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            }

        });

        btn_pre.setOnClickListener( v -> {

            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.reset();
                //index-=1;
                if (index > 0) {
                    try {
                        mediaPlayer.setDataSource(getApplicationContext(),parse(fileUri.get(--index)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (cnt > 0) {
                    img1.setImageResource(imgs1.get(--cnt));
                }
                if (text > 0) {
                    tex.setText(title1.get(--text));
                }
                if (text1 > 0) {
                    tex1.setText(singer1.get(--text1));
                }
                if (text2 > 0) {
                    tex2.setText(lyrics1.get(--text2));
                }
                mediaPlayer = MediaPlayer.create(getApplicationContext(), parse(fileUri.get(index)));
                mediaPlayer.start();
            } else {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.activity_toast,findViewById(R.id.toast_frame));
                TextView t_title = layout.findViewById(R.id.text);
                t_title.setText("재생중이 아닙니다!");
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0,325);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            }

        });
        img1 = findViewById(R.id.strem_album_um);
        tex = findViewById(R.id.text9);
        tex1 = findViewById(R.id.text8);
        tex2 = findViewById(R.id.strem_song);

        mediaPlayer.setLooping(true);

        btn_stream_play_stop1 = findViewById(R.id.stream_play_stop1);
        seekbar = findViewById(R.id.seekBar1);

        seekbar.setMax(mediaPlayer.getDuration());

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {

                if (fromUser)
                    mediaPlayer.seekTo(progress);
            }
        });
    }

    public void button(View v) {

        if (mediaPlayer.isPlaying()) {

            mediaPlayer.pause();
            btn_stream_play_stop1.setText(R.string.stream_play);
            btn_stream_play_stop1.setTextColor(Color.parseColor(strColorstop));
        } else {
            mediaPlayer.start();
            btn_stream_play_stop1.setText(R.string.stream_stop);
            btn_stream_play_stop1.setTextColor(Color.parseColor(strColorplay));
            Thread();
        }
    }



    public void Thread() {
        Runnable task = () -> {
            while (mediaPlayer.isPlaying()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                seekbar.setProgress(mediaPlayer.getCurrentPosition());
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }


    @SuppressLint("ResourceType")
    public void InitializeView() {
        btn_mini_playList = findViewById(R.id.mini_playlist_btn);
        btn_mini_home = findViewById(R.id.mini_home_btn);
        btn_stream_lyrics = findViewById(R.id.strem_song);
        btn_pre = findViewById(R.id.strem_before);
        btn_next = findViewById(R.id.strem_nex);
        btn_long_lyrics = (RelativeLayout) findViewById(R.id.long_lyrics);
        TAG = "MainActivity";

    }

    public void SetListener() {
        View.OnClickListener Listener = view -> {
            switch (view.getId()) {
                case R.id.mini_home_btn:
                    Intent intent_main = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent_main);
                    break;
                case R.id.mini_playlist_btn:
                    Intent intent_mini_playlist_btn = new Intent(getApplicationContext(), StreamingSongList.class);
                    startActivity(intent_mini_playlist_btn);
                    break;
                case R.id.strem_song:
                    btn_long_lyrics.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        };
        btn_mini_home.setOnClickListener(Listener);
        btn_mini_playList.setOnClickListener(Listener);
        btn_stream_lyrics.setOnClickListener(Listener);

    }


    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime)
        {
            super.onBackPressed();
        }
        else
        {
            backPressedTime = tempTime;
            btn_long_lyrics.setVisibility(View.INVISIBLE);
        }
    }

    public void getMusicData(){
        musicList = new ArrayList<>();

        String[] columns = new String[] {"_idPlayList", "singer", "album", "title"};

        Cursor cursor = musicDBManager.query(columns, null, null, null, null, null);

        if(cursor != null){
            while(cursor.moveToNext()){
                if (cursor.getString(1).equals("NCT127")) {
                    Playlist_Info currentData = new Playlist_Info(R.drawable.boy1_kickit, cursor.getString(3), cursor.getString(1), cursor.getInt(0));
                    playlistInfoArrayList.add(currentData);
                } else if (cursor.getString(3).equals("이제 나만 믿어요")){
                    Playlist_Info currentData = new Playlist_Info(R.drawable.boy2_music1, cursor.getString(3), cursor.getString(1), cursor.getInt(0));
                    playlistInfoArrayList.add(currentData);
                } else if (cursor.getString(3).equals("상사화")) {
                    Playlist_Info currentData = new Playlist_Info(R.drawable.lovecall_r, cursor.getString(3), cursor.getString(1), cursor.getInt(0));
                    playlistInfoArrayList.add(currentData);
                } else if ((cursor.getString(3).equals("바램"))|| (cursor.getString(3).equals("어느 60대 노부부이야기"))) {
                    Playlist_Info currentData = new Playlist_Info(R.drawable.mr_trot_r, cursor.getString(3), cursor.getString(1), cursor.getInt(0));
                    playlistInfoArrayList.add(currentData);
                }
            }
        }
    }

    private void songNCTData(){
        service.getNCTSongData().enqueue(new Callback<List<SongModel>>() {
            @Override
            public void onResponse(Call<List<SongModel>> call, Response<List<SongModel>> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "responseNCT is success");
                    List<SongModel> songModel = response.body();
                    if (songModel != null) {
                        for (int i = 0; i < songModel.size(); i++){
                            albumlistInfoArrayList.add(new Albumlist_Info(songModel.get(i).getIdSSong(), songModel.get(i).getSSongName(), songModel.get(i).getSSongFile(), songModel.get(i).getSSongLyric()));
                        }
                        setData();
                        Log.d("mainUri", String.valueOf(fileUri.size()));
                        Log.d("mainPlay", String.valueOf(playlistInfoArrayList.size()));
                        Log.d("mainAlbum", String.valueOf(albumlistInfoArrayList.size()));

                    } else {
                        Log.d(TAG, "NameSinger is null");
                    }
                } else {
                    int statusCode  = response.code();
                    Log.d(TAG, String.valueOf(statusCode));
                }
            }

            @Override
            public void onFailure(Call<List<SongModel>> call, Throwable t) {
                Log.d(TAG, "error loading from API" + t);
            }
        });
    }


    public void setData() {
        for (int i = 0; i < playlistInfoArrayList.size() ; i++){
            for (int j = 0; j < albumlistInfoArrayList.size() ; j++){
                if (albumlistInfoArrayList.get(j).song.equals(playlistInfoArrayList.get(i).song)){
                    fileUri.add(url + albumlistInfoArrayList.get(j).file);
                    lyrics1.add(albumlistInfoArrayList.get(j).lyric);
                }
            }
            if (playlistInfoArrayList.get(i).singer.equals("NCT127")){
                imgs1.add(R.drawable.boy1_kickit);
            } else if (playlistInfoArrayList.get(i).song.equals("이제 나만 믿어요")){
                imgs1.add(R.drawable.boy2_music1);
            } else if (playlistInfoArrayList.get(i).song.equals("상사화")){
                imgs1.add(R.drawable.lovecall_r);
            } else if (playlistInfoArrayList.get(i).song.equals("바램") || playlistInfoArrayList.get(i).song.equals("어느 60대 노부부이야기")){
                imgs1.add(R.drawable.mr_trot_r);
            }
            title1.add(playlistInfoArrayList.get(i).song);
            singer1.add(playlistInfoArrayList.get(i).singer);
        }
    }

}
