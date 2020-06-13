package com.example.myapplication_scroll;

import android.provider.ContactsContract;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Popularlist_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private SparseBooleanArray mSelectedItems = new SparseBooleanArray(0);

    public SparseBooleanArray getMSelectedItem() {
        return mSelectedItems;
    }
    public void setMSelectedItem(int position, boolean mSelectedItem) {
        this.mSelectedItems.put(position, mSelectedItem);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView album;
        ImageView frame;
        TextView rank_num;
        TextView songname;
        TextView singername;

        MyViewHolder(View view){
            super(view);
            album = view.findViewById(R.id.album_image);
            rank_num = view.findViewById(R.id.rank);
            songname = view.findViewById(R.id.song);
            singername = view.findViewById(R.id.singer);
            frame = view.findViewById(R.id.popular_musiclist_tool);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (mSelectedItems.get(position, false)) {
                        mSelectedItems.put(position, false);
                        frame.setImageResource(R.drawable.popular_musiclist_color);
                    } else {
                        mSelectedItems.put(position, true);
                        frame.setImageResource(R.drawable.popular_musiclist_color_change);
                    }
                }
            });
        }
    }

    private ArrayList<Popularlist_Info> popularlist_InfoArrayList;
    Popularlist_adapter(ArrayList<Popularlist_Info> popularlist_InfoArrayList){
        this.popularlist_InfoArrayList = popularlist_InfoArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_popularlist, parent, false);

        return new Popularlist_adapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Popularlist_adapter.MyViewHolder myViewHolder = (Popularlist_adapter.MyViewHolder) holder;

        myViewHolder.rank_num.setText(popularlist_InfoArrayList.get(position).rank_num);
        myViewHolder.album.setImageResource(popularlist_InfoArrayList.get(position).album);
        myViewHolder.songname.setText(popularlist_InfoArrayList.get(position).song);
        myViewHolder.singername.setText(popularlist_InfoArrayList.get(position).singer);
    }

    @Override
    public int getItemCount() {
        return popularlist_InfoArrayList.size();
    }
}