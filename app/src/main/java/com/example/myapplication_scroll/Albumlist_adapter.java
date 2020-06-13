package com.example.myapplication_scroll;

import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Albumlist_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private SparseBooleanArray mSelectedItems = new SparseBooleanArray(0);

    public SparseBooleanArray getMSelectedItem() {
        return mSelectedItems;
    }
    public void setMSelectedItem(int position, boolean mSelectedItem) {
        this.mSelectedItems.put(position, mSelectedItem);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tracknum;
        TextView songname;
        RelativeLayout frame;

        MyViewHolder(View view){
            super(view);
            tracknum = view.findViewById(R.id.songnum);
            songname = view.findViewById(R.id.songname);
            frame = view.findViewById(R.id.song_play1);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (mSelectedItems.get(position, false)) {
                        mSelectedItems.put(position, false);
                        frame.setBackgroundResource(R.drawable.streaming_playlist_color_control);
                    } else {
                        mSelectedItems.put(position, true);
                        frame.setBackgroundResource(R.drawable.streaming_playlist_color_control_change);
                    }
                }
            });

        }
    }

    private ArrayList<Albumlist_Info> albumlistInfoArrayList;
    Albumlist_adapter(ArrayList<Albumlist_Info> albumlistInfoArrayList){
        this.albumlistInfoArrayList = albumlistInfoArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_albumlist, parent, false);

        return new Albumlist_adapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Albumlist_adapter.MyViewHolder myViewHolder = (Albumlist_adapter.MyViewHolder) holder;

        myViewHolder.tracknum.setText(albumlistInfoArrayList.get(position).num);
        myViewHolder.songname.setText(albumlistInfoArrayList.get(position).song);
    }

    @Override
    public int getItemCount() {
        return albumlistInfoArrayList.size();
    }
}