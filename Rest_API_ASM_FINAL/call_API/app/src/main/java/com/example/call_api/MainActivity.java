package com.example.call_api;

import static com.example.call_api.services.retrofitService.BASE_URL;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.call_api.Models.reqlogin;
import com.example.call_api.Models.reslogin;
import com.example.call_api.services.retrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText edtUsername = findViewById(R.id.edtUsername);
        EditText edtPassword = findViewById(R.id.edtPassword);
        Button btnLogin = findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                kiemTra(new reqlogin(username,password));

            }
        });
    }
    private  void kiemTra(reqlogin reqlogin){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitService service = retrofit.create(retrofitService.class);
        service.login(reqlogin).enqueue(new Callback<reslogin>() {
            @Override
            public void onResponse(Call<reslogin> call, Response<reslogin> response) {
                if(response.code() == 200){
                    String token = response.body().getToken();
                    Toast.makeText(MainActivity.this,  "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences =getSharedPreferences("data",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("token",token);
                    editor.apply();

                    // Kiểm tra xem token đã lưu chưa
                    String savedToken = sharedPreferences.getString("token", "");
                    Log.d("MainActivity", "Token saved: " + savedToken); // Log token đã lưu

                    Intent intent = new Intent(MainActivity.this, homeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "username of password required", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<reslogin> call, Throwable throwable) {
                Toast.makeText(MainActivity.this, "Lỗi nữa nè", Toast.LENGTH_SHORT).show();
            }
        });
    }
}