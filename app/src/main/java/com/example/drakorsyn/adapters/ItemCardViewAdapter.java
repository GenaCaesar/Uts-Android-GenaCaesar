package com.example.drakorsyn.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.drakorsyn.R;
import com.example.drakorsyn.activities.DetailActivity;
import com.example.drakorsyn.models.Drakor;

import java.util.ArrayList;

public class ItemCardViewAdapter extends RecyclerView.Adapter<ItemCardViewAdapter.CardViewHolder> {
    private Context context;
    private ArrayList<Drakor> listDrakor;

    public ItemCardViewAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Drakor> getlistDrakor() {
        return listDrakor;
    }

    public void setListDrakor(ArrayList<Drakor> listDrakor) {
        this.listDrakor = listDrakor;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, final int position) {
        holder.tvNama.setText(getlistDrakor().get(position).getNama());
        holder.tvDeskripsi.setText(getlistDrakor().get(position).getDeskripsi());
        Glide.with(context).load(getlistDrakor().get(position).getFoto()).into(holder.imgPhoto);

        // intent parcelable menuju detail
        holder.button.setOnClickListener(new View.OnClickListener() {
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
        return getlistDrakor().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvNama, tvDeskripsi;
        Button button;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_card);
            tvNama = itemView.findViewById(R.id.tv_nama_card);
            tvDeskripsi = itemView.findViewById(R.id.tv_desc_card);
            button = itemView.findViewById(R.id.button);
        }
    }
}
