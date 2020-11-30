package com.example.capstonebaru.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.capstonebaru.DetailActivity;
import com.example.capstonebaru.R;
import com.example.capstonebaru.model.HotelItem;
import com.example.capstonebaru.rest.ApiService;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {

    private ArrayList<HotelItem> hotelItems;
    private Context context;

    public HotelAdapter(Context context, ArrayList<HotelItem> hotelItems) {
        this.context = context;
        this.hotelItems = hotelItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final HotelItem ri = hotelItems.get(position);
        holder.tvNamaHotel.setText(hotelItems.get(position).getNama());
        /*Glide.with(context)
                .load(ApiService.URLIMAGE + hotelItems.get(position).getGambarUrl())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.ic_image)
                        .transform(new RoundedCorners(16)))
                .into(holder.iv);*/
        Glide.with( context ).load(ri.getGambarUrl()).into(holder.iv);
        /*Glide.with(context).load(hotelItems.get(position).getGambarUrl()).error(R.drawable.ic_image)
                .override(512, 512)
                .into(holder.iv);*/
        holder.cvKlik.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( context, DetailActivity.class );
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // biar bisa muncul
                i.putExtra("img", ri.getGambarUrl());
                // Glide.with( context ).load( hotelItems.ri.getGambarUrl() ).into( holder.iv);
                i.putExtra("nama", ri.getNama());
                i.putExtra( "alamat", ri.getAlamat());
                i.putExtra("koordinat", ri.getKordinat());
                i.putExtra("telp", String.valueOf(ri.getNomorTelp()));
                context.startActivity(i);
            }
        } );
    }

    @Override
    public int getItemCount() {
        return hotelItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvKlik;
        private ImageView iv;
        private TextView tvNamaHotel;
        /*private TextView tvAlamat;
        private TextView tvKoordinat;
        private TextView tvTelp;*/
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvKlik = itemView.findViewById(R.id.cv_klik);
            iv = itemView.findViewById(R.id.iv);
            tvNamaHotel = itemView.findViewById(R.id.tv_nama_hotel);
            /*tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvKoordinat = itemView.findViewById(R.id.tv_koordinat);
            tvTelp = itemView.findViewById(R.id.tv_telp);*/
        }
    }
}
