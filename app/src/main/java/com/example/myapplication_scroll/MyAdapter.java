package com.example.myapplication_scroll;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPicture;
        TextView songname;
        TextView singername;

        MyViewHolder(View view){
            super(view);
            ivPicture = view.findViewById(R.id.streaming_list1_image);
            songname = view.findViewById(R.id.streaming_list1_song_name);
            singername = view.findViewById(R.id.streaming_list1_singer);
        }
    }

    private ArrayList<Playlist_Info> playlistInfoArrayList;
    MyAdapter(ArrayList<Playlist_Info> playlistInfoArrayList){
        this.playlistInfoArrayList = playlistInfoArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.ivPicture.setImageResource(playlistInfoArrayList.get(position).drawableId);
        myViewHolder.songname.setText(playlistInfoArrayList.get(position).song);
        myViewHolder.singername.setText(playlistInfoArrayList.get(position).singer);
    }

    @Override
    public int getItemCount() {
        return playlistInfoArrayList.size();
    }
}
