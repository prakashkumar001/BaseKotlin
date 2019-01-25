package com.kotlin.example.activities

import android.os.Bundle
import com.google.gson.JsonObject
import com.kotlin.example.BaseActivity
import com.kotlin.example.callback.Listener
import org.json.JSONObject

class ApiCallActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        callVolley();
    }

    fun callRetrofit()
    {
        callRetrofitApi("json/1","GET",JsonObject(),object :Listener{
            override fun onSucess(code: Int, response: String) {
                showToast(response);
            }

            override fun onFailure(code: Int, error: String) {
                showToast(error);
            }

        });
    }

    fun callVolley()
    {
        callVolleyApi("thing/10/collections","POST",JSONObject(),object :Listener{
            override fun onSucess(code: Int, response: String) {
                showToast(response);
            }

            override fun onFailure(code: Int, error: String) {
                showToast(error);
            }

        });
    }
}