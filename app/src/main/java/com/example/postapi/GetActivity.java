package com.example.postapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostApi postApi;
    private List<UserModel> userModels;
    private TextView responseText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);

        recyclerView = findViewById(R.id.recyclerView);
        responseText = findViewById(R.id.textViewResponse);
        userModels = new ArrayList<>();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        postApi = retrofit.create(PostApi.class);

        Call<List<UserModel>> call = postApi.getUsers() ;

        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                if(!response.isSuccessful())
                {
                    responseText.setText("CODE=" + response.code());
                    return;
                }
                List<UserModel> userModels1 = response.body();

                for (UserModel user:userModels1) {

                    userModels.add(user);
                }
                putDataInToAdapter(userModels);
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                    responseText.setText(t.getMessage());
            }
        });

    }
    public void putDataInToAdapter(List<UserModel> userModels){
        UserModelAdapter adapter = new UserModelAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setUserModels(userModels);
        recyclerView.setAdapter(adapter);
    }
}