package com.example.myapplication_scroll;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Tutorial_op_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView optionname;

        public MyViewHolder(View view){
            super(view);
            image = view.findViewById(R.id.image);
            optionname = view.findViewById(R.id.text);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    switch (position){
                        case 0:
                            Intent firstOp = new Intent(v.getContext(),SearchActivity.class);
                            v.getContext().startActivity(firstOp);
                            break;
                        case 1:
                            Intent secondOp = new Intent(v.getContext(),MainActivity.class);
                            v.getContext().startActivity(secondOp);
                            break;
                        case 2:
                            Intent thirdOp = new Intent(v.getContext(),ArtistYEONGActivity.class);
                            v.getContext().startActivity(thirdOp);
                            break;
                        case 3:
                            Intent forthOp = new Intent(v.getContext(),ArtistNCTActivity.class);
                            v.getContext().startActivity(forthOp);
                            break;
                    }

                }
            });
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
