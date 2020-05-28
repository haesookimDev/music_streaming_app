package com.example.myapplication_scroll;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Tutorial_op_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView optionname;

        MyViewHolder(View view){
            super(view);
            image = view.findViewById(R.id.image);
            optionname = view.findViewById(R.id.text);
        }
    }

    private ArrayList<Tutorial_op_Info> tutorial_op_InfoArrayList;
    Tutorial_op_Adapter(ArrayList<Tutorial_op_Info> tutorial_op_InfoArrayList){
        this.tutorial_op_InfoArrayList = tutorial_op_InfoArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_tutorial_op, parent, false);

        return new Tutorial_op_Adapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Tutorial_op_Adapter.MyViewHolder myViewHolder = (Tutorial_op_Adapter.MyViewHolder) holder;

        myViewHolder.image.setImageResource(tutorial_op_InfoArrayList.get(position).tuto_op_image);
        myViewHolder.optionname.setText(tutorial_op_InfoArrayList.get(position).option_name);
    }

    @Override
    public int getItemCount() {
        return tutorial_op_InfoArrayList.size();
    }
}
