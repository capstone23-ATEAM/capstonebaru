package com.example.capstonebaru;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private CardView cvKlik;
    private ImageView iv;
    private TextView tvNamaHotel;
    private TextView tvAlamat;
    private TextView tvKoordinat;
    private TextView tvTelp;
    String img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        img = getIntent().getStringExtra("");
        tvNamaHotel.setText(getIntent().getStringExtra("nama"));
        tvAlamat.setText(getIntent().getStringExtra("alamat"));
        tvKoordinat.setText(getIntent().getStringExtra("koordinat"));
        tvTelp.setText(getIntent().getStringExtra("telp"));
        Glide.with(DetailActivity.this).load(img).into(iv);

    }

    private void initView() {
        cvKlik = findViewById(R.id.cv_klik);
        iv = findViewById(R.id.iv);
        tvNamaHotel = findViewById(R.id.tv_nama_hotel);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvKoordinat = findViewById(R.id.tv_koordinat);
        tvTelp = findViewById(R.id.tv_telp);
    }
}