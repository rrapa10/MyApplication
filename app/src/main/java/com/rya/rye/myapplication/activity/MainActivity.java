package com.rya.rye.myapplication.activity;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.rya.rye.myapplication.R;
import com.rya.rye.myapplication.adapter.CanchaAdapter;
import com.rya.rye.myapplication.model.Cancha;
import com.rya.rye.myapplication.my_interface.GetCanchaDataService;
import com.rya.rye.myapplication.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "com.rya.rye.myaplication.activity.DetailActivity";
    private CanchaAdapter adapter;
    private RecyclerView recyclerView;
    public SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        GetCanchas();
        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        GetCanchas();

                    }
                }
        );
    }

    public void LoadView(View view)
    {
        Intent intent = new Intent(this, DetailActivity.class);
        TextView id = (TextView) findViewById(R.id.txt_id);
        String envia = id.getText().toString();
        intent.putExtra(EXTRA_ID, envia);
        startActivity(intent);

    }



    private void GetCanchas() {
        final ProgressBar loader = findViewById(R.id.loader);
        loader.setVisibility(View.VISIBLE);
        GetCanchaDataService service = RetrofitInstance.getRetrofitInstance().create(GetCanchaDataService.class);
        Call<List<Cancha>> call = service.getCanchaData();
        Log.wtf("URL Called", call.request().url() + "");
        call.enqueue(new Callback<List<Cancha>>() {
            @Override
            public void onResponse(Call<List<Cancha>> call, Response<List<Cancha>> response) {
                loader.setVisibility(View.GONE);
                recyclerView = findViewById(R.id.recycler_view_notice_list);
                adapter = new CanchaAdapter(MainActivity.this, response.body());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<Cancha>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}
