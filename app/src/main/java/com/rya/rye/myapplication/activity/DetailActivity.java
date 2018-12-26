package com.rya.rye.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
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

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String idcancha = intent.getStringExtra(MainActivity.EXTRA_ID);
        GetCanchaDataService service = RetrofitInstance.getRetrofitInstance().create(GetCanchaDataService.class);
        Call<List<Cancha>> call = service.getCanchaByIdData(idcancha);
        Log.wtf("URL Called", call.request().url() + "");

        

    }

}
