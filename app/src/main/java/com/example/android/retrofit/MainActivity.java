package com.example.android.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.android.retrofit.pojo.EventMain;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private RecyclerAdapter adapter;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<EventMain> call = apiInterface.getData();

        call.enqueue(new Callback<EventMain>() {
            @Override
            public void onResponse(Call<EventMain> call, Response<EventMain> response) {
                EventMain eventMain = response.body();
                adapter = new RecyclerAdapter(eventMain.getFeatures());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<EventMain> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Can't connect to server this time ", Toast.LENGTH_SHORT).show();
                Log.e(getApplicationContext().toString(),"Check the path");
            }

        });
    }
}
