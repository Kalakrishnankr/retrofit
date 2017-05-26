package com.example.kalakrishnankr.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kalakrishnan.kr on 24/5/17.
 */
public class ViewResult extends AppCompatActivity {

    public static final  String url = "http://192.168.1.156:8091/";
    List<Questionlist>qlist;
    RecyclerView rcview;
    RecyclerViewAdapter adapter;

    String api;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpage);
        rcview = (RecyclerView)findViewById(R.id.rv) ;
        rcview.setLayoutManager(new LinearLayoutManager(this));
        qlist = new ArrayList<Questionlist>();
        loadJSON();
    }

    private void loadJSON() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

         Retrofit retrofit =new Retrofit.Builder()
//                .baseUrl("https://sprapi.euw.intamac.com/api/users/")
                 .client(httpClient.build())
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService request = retrofit.create(ApiService.class);
        Call<JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                JSONResponse jsonResponse =response.body();
//                qlist = new ArrayList<>(Arrays.asList(jsonResponse.getQuestion()));
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });


    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder>{

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row,null);
            CustomViewHolder holder = new CustomViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {


        }


        @Override
        public int getItemCount() {
            return 0;
        }
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView tv_id,tv_qs;
        public CustomViewHolder(View itemView) {
            super(itemView);
            tv_id = (TextView)itemView.findViewById(R.id.tv_id);
            tv_qs = (TextView)itemView.findViewById(R.id.tv_question);
        }
    }
}
