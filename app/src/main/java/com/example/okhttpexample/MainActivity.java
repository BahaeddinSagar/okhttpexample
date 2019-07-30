package com.example.okhttpexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    String TAG = "OKOKOK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ok(View view) {
        String u = "https://api.openweathermap.org/data/2.5/weather?q=London&mode=json&units=metric&appid=56f68190828428adfaf9f8d42c54e960";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(u).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d(TAG, "ok: " + response.headers());
                Log.d(TAG, "onResponse: " + response.body().string());
                // cannot update UI from here !


            }

        });


    }

    public void PicassoRequest(View view) {
        ImageView imageView = findViewById(R.id.picassoImage);
        Picasso.get().setIndicatorsEnabled(true);
        Picasso.get().load(
                "https://cdn.hswstatic.com/gif/picasso-1.jpg")
                .placeholder(android.R.drawable.btn_plus)
                .error(android.R.drawable.btn_minus)
                .into(imageView);
    }

    public void PicassoRequest2(View view) {
        ImageView imageView = findViewById(R.id.picassoImage2);
        Picasso.get().setIndicatorsEnabled(true);
        Picasso.get().load(
                "https://cdn.hswstatic.com/gif/picasso-1.jpg")
                .placeholder(android.R.drawable.btn_plus)
                .error(android.R.drawable.btn_minus)
                .into(imageView);

    }
}
