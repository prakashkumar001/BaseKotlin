package com.kotlin.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.gson.JsonObject
import com.kotlin.example.retrofit.ApiClient
import com.kotlin.example.retrofit.ApiInterface
import com.kotlin.example.callback.Listener
import com.kotlin.example.volley.VolleyRequestResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    fun callRetrofitApi(url: String, method: String, request: JsonObject, listener: Listener) {

        val apiService: ApiInterface = ApiClient.create();

        if (method.equals("GET", true)) {
            apiService.callGetMethod(url).enqueue(object : Callback<Any> {
                override fun onFailure(call: Call<Any>, t: Throwable) {
                    listener.onFailure(0, t.message.toString());
                }

                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    listener.onSucess(response.code(), response.body().toString());


                }

            })
        } else {
            apiService.callPostMethod(url, request).enqueue(object : Callback<Any> {
                override fun onFailure(call: Call<Any>, t: Throwable) {
                    listener.onFailure(0, t.message.toString());
                }

                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    listener.onSucess(response.code(), response.body().toString());


                }

            })
        }


    }

    fun callVolleyApi(url: String, method: String, request: JSONObject, listener: Listener) {
        val call = VolleyRequestResponse();

        if (method.equals("GET", true)) {
            call.post(url,method,JSONObject(),listener)

        } else {
            call.post(url,method,request,listener)

        }
    }

}