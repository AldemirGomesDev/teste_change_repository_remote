package com.example.retryretrofit

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retryretrofit.retrofit.RetrofitClient
import com.example.retryretrofit.retrofit.UserResponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var txvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txvResult = findViewById(R.id.txvResults)

        val apiService = RetrofitClient.getApiService()

        apiService.getUsers().enqueue(object : Callback<ArrayList<UserResponse?>>{
            override fun onFailure(call: Call<ArrayList<UserResponse?>>, t: Throwable) {
                txvResult.text = t.message
                Log.e("mainActivity", "error: $t")
                Toast.makeText(applicationContext, "Failure " + t.message, Toast.LENGTH_LONG)
                    .show()
            }

            override fun onResponse(call: Call<ArrayList<UserResponse?>>, response: Response<ArrayList<UserResponse?>>) {
                if (response.isSuccessful) {
                    txvResult.setText(response.code().toString())
                    Toast.makeText(
                        applicationContext, "Success " + response.code(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        })
    }
}