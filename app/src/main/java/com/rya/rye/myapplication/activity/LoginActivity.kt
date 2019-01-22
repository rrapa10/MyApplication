package com.rya.rye.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rya.rye.myapplication.R
import com.rya.rye.myapplication.model.Usuario
import com.rya.rye.myapplication.my_interface.GetCanchaDataService
import com.rya.rye.myapplication.network.RetrofitInstance
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener {
            val service = RetrofitInstance.getRetrofitInstance().create(GetCanchaDataService::class.java)
            val call = service.getUsuarioData(txtUser.text.toString(), txtPass.text.toString())
            Log.wtf("URL Called", call.request().url().toString() + "")
            call.enqueue(object : Callback<List<Usuario>> {
                override fun onResponse(call: Call<List<Usuario>>, response: Response<List<Usuario>>) {
                    if (response.isSuccessful) {
                        val usuario = response.body() as List<Usuario>
                        if (response.body() != null && usuario.isNotEmpty()) {
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        } else {
                            Toast.makeText(this@LoginActivity, "Usuario y/o Contraseña Incorrecto", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onFailure(call: Call<List<Usuario>>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Something went wrong...Error message: " + t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
