package com.example.drakorsyn.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.drakorsyn.R;
import com.example.drakorsyn.activities.DetailActivity;
import com.example.drakorsyn.models.Drakor;

import java.util.ArrayList;

public class ItemGridAdapter extends RecyclerView.Adapter<ItemGridAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Drakor> listDrakor;

    public ItemGridAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Drakor> getListDrakor() {
        return listDrakor;
    }

    public void setListDrakor(ArrayList<Drakor> listDrakor) {
        this.listDrakor = listDrakor;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int position) {
        Glide.with(context).load(getListDrakor().get(position).getFoto()).into(holder.imgGrid);
        holder.imgGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailActivity = new Intent(context, DetailActivity.class);
                detailActivity.putExtra(DetailActivity.EXTRA_DRAKOR, listDrakor.get(position));
                context.startActivity(detailActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListDrakor().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgGrid;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgGrid = itemView.findViewById(R.id.img_grid);
        }
    }
}
