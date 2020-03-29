package com.example.drakorsyn.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.drakorsyn.R;
import com.example.drakorsyn.models.Drakor;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_DRAKOR = "extra_drakor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.img_detail);
        TextView nama = findViewById(R.id.tv_nama_detail);
        TextView deskripsi = findViewById(R.id.tv_desc_detail);
        TextView genre = findViewById(R.id.tv_genre_detail);
        TextView pemeran = findViewById(R.id.tv_pemeran_detail);

        Drakor drakor = getIntent().getParcelableExtra(EXTRA_DRAKOR);

        Glide.with(this).load(drakor.getFoto()).into(imageView);
        nama.setText(drakor.getNama());
        deskripsi.setText(drakor.getDeskripsi());
        genre.setText(drakor.getGenre());
        pemeran.setText(drakor.getPemeran());
    };
}
