package com.example.drakorsyn.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.drakorsyn.R;
import com.example.drakorsyn.models.Drakor;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_DRAKOR = "extra_drakor";
    private Button btnLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.img_detail);
        TextView nama = findViewById(R.id.tv_nama_detail);
        TextView deskripsi = findViewById(R.id.tv_desc_detail);
        TextView genre = findViewById(R.id.tv_genre_detail);
        TextView pemeran = findViewById(R.id.tv_pemeran_detail);
        btnLink = (Button)findViewById(R.id.btnLink);

        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://ratudrama.id/"));
                startActivity(intent);
            }
        });

        Drakor drakor = getIntent().getParcelableExtra(EXTRA_DRAKOR);

        Glide.with(this).load(drakor.getFoto()).into(imageView);
        nama.setText(drakor.getNama());
        deskripsi.setText(drakor.getDeskripsi());
        genre.setText(drakor.getGenre());
        pemeran.setText(drakor.getPemeran());
    }
}
