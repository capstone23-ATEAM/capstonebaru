package com.example.capstonebaru;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.capstonebaru.adapter.HotelAdapter;
import com.example.capstonebaru.model.HotelItem;
import com.example.capstonebaru.model.HotelModel;
import com.example.capstonebaru.rest.ApiConfigServer;
import com.example.capstonebaru.rest.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;

    private ArrayList<HotelItem> list = new ArrayList<>();
    private HotelAdapter hotelAdapter;
    ImageView imgNotification;
    ApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        apiService = ApiConfigServer.getApiService();
        hotelAdapter = new HotelAdapter(getApplicationContext(), list);

        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setAdapter(hotelAdapter);

        getDataview();
    }

    private void getDataview() {
        apiService.getData().enqueue(new Callback<HotelModel>() {
            @Override
            public void onResponse(Call<HotelModel> call, Response<HotelModel> response) {
                if (response.isSuccessful()){
                    list = response.body().getHotel();
                    rv.setAdapter(new HotelAdapter(getApplicationContext(), list));
                    hotelAdapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(MainActivity.this, "Gagal mengambil data !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<HotelModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}