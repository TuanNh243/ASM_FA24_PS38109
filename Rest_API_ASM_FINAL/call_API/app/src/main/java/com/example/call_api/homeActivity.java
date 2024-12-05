package com.example.call_api;

import static com.example.call_api.services.retrofitService.BASE_URL;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.call_api.Models.product;
import com.example.call_api.Models.resProduct;
import com.example.call_api.services.retrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class homeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private  ArrayList<product> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerView);
        getData();

    }

    private void getData(){

        // chổ lưu token
        SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        String token = "Bearer " + sharedPreferences.getString("token","");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitService service = retrofit.create(retrofitService.class);
        service.GetAllProduct(token).enqueue(new Callback<resProduct>() {
            @Override
            public void onResponse(Call<resProduct> call, Response<resProduct> response) {
//                assert response.body() != null;
                list = response.body().getData();

                LinearLayoutManager manager = new LinearLayoutManager(homeActivity.this);
                recyclerView.setLayoutManager(manager);
                adapterProduct adapter = new adapterProduct(homeActivity.this, list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<resProduct> call, Throwable throwable) {
                Log.d("abc","lỗi" + throwable.getMessage());
                Toast.makeText(homeActivity.this, "Ko fetch dc API", Toast.LENGTH_SHORT).show();
            }
        });
    }
}