package com.example.myapplication_scroll;

import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Playlist_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private SparseBooleanArray mSelectedItems = new SparseBooleanArray(0);

    public SparseBooleanArray getMSelectedItem() {
        return mSelectedItems;
    }
    public void setMSelectedItem(int position, boolean mSelectedItem) {
        this.mSelectedItems.put(position, mSelectedItem);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPicture;
        ImageView frame;
        TextView songname;
        TextView singername;

        MyViewHolder(View view){
            super(view);
            ivPicture = view.findViewById(R.id.streaming_list1_image);
            songname = view.findViewById(R.id.streaming_list1_song_name);
            singername = view.findViewById(R.id.streaming_list1_singer);
            frame = view.findViewById(R.id.streaming_list1);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (mSelectedItems.get(position, false)) {
                        mSelectedItems.put(position, false);
                        frame.setImageResource(R.drawable.streaming_playlist_color_control);
                    } else {
                        mSelectedItems.put(position, true);
                        frame.setImageResource(R.drawable.streaming_playlist_color_control_change);
                    }
                }
            });
        }
    }

    private ArrayList<Playlist_Info> playlistInfoArrayList;
    Playlist_adapter(ArrayList<Playlist_Info> playlistInfoArrayList){
        this.playlistInfoArrayList = playlistInfoArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_playlist, parent, false);

        return new Playlist_adapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Playlist_adapter.MyViewHolder myViewHolder = (Playlist_adapter.MyViewHolder) holder;

        myViewHolder.ivPicture.setImageResource(playlistInfoArrayList.get(position).drawableId);
        myViewHolder.songname.setText(playlistInfoArrayList.get(position).song);
        myViewHolder.singername.setText(playlistInfoArrayList.get(position).singer);
    }

    @Override
    public int getItemCount() {
        return playlistInfoArrayList.size();
    }
}
