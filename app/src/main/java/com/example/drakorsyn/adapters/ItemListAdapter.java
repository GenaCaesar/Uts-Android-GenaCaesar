package com.example.drakorsyn.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.drakorsyn.R;
import com.example.drakorsyn.activities.DetailActivity;
import com.example.drakorsyn.models.Drakor;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ListViewHolder> {
    private Context context;
    private ArrayList<Drakor> listDrakor;

    public ItemListAdapter(Context context) {
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
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ListViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, final int position) {
        holder.tvName.setText(getListDrakor().get(position).getNama());
        holder.tvElevation.setText(getListDrakor().get(position).getGenre());

        Glide.with(context).load(getListDrakor().get(position).getFoto()).into(holder.imgList);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
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

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvElevation;
        ImageView imgList;
        RelativeLayout relativeLayout;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_nama_list);
            tvElevation = itemView.findViewById(R.id.tv_genre_list);
            imgList = itemView.findViewById(R.id.img_list);
            relativeLayout = itemView.findViewById(R.id.relative_layout);
        }
    }
}
