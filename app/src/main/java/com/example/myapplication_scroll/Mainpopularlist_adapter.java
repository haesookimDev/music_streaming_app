package com.example.myapplication_scroll;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Mainpopularlist_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView albumImage;
        TextView ranknum;
        TextView song;
        TextView singer;


        MyViewHolder(View view){
            super(view);
            albumImage= view.findViewById(R.id.popular_chart_album);
            ranknum = view.findViewById(R.id.popular_chart_rank_num);
            song = view.findViewById(R.id.popular_chart_song);
            singer = view.findViewById(R.id.popular_chart_singer);
        }
    }

    private ArrayList<Mainpopularlist_Info> mainpopularlistInfoArrayList;
    Mainpopularlist_adapter(ArrayList<Mainpopularlist_Info> mainpopularlistInfoArrayList){
        this.mainpopularlistInfoArrayList = mainpopularlistInfoArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_mainpopularlist, parent, false);

        return new  Mainpopularlist_adapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Mainpopularlist_adapter.MyViewHolder myViewHolder = (Mainpopularlist_adapter.MyViewHolder) holder;

        myViewHolder.albumImage.setImageResource(mainpopularlistInfoArrayList.get(position).albumImage);
        myViewHolder.ranknum.setText(mainpopularlistInfoArrayList.get(position).rankNum);
        myViewHolder.song.setText(mainpopularlistInfoArrayList.get(position).song);
        myViewHolder.singer.setText(mainpopularlistInfoArrayList.get(position).singer);
    }

    @Override
    public int getItemCount() {
        return mainpopularlistInfoArrayList.size();
    }
}