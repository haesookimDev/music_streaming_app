package com.example.myapplication_scroll;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Albumlist_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tracknum;
        TextView songname;


        MyViewHolder(View view){
            super(view);
            tracknum = view.findViewById(R.id.songnum);
            songname = view.findViewById(R.id.songname);

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