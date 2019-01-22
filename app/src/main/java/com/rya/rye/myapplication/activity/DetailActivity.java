package com.rya.rye.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;

import com.rya.rye.myapplication.R;
import com.rya.rye.myapplication.model.Cancha;
import com.rya.rye.myapplication.my_interface.GetCanchaDataService;
import com.rya.rye.myapplication.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;

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
