package com.kotlin.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.kotlin.example.api.ApiClient
import com.kotlin.example.api.ApiInterface
import com.kotlin.example.callback.Listener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.adapter.rxjava2.HttpException

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    fun callGetApi(url: String ,listener: Listener) {

         val apiService:ApiInterface = ApiClient.create();
        apiService.callGetMethod(url).enqueue(object : Callback<Any>
        {
            override fun onFailure(call: Call<Any>, t: Throwable) {
                listener.onFailure(0,t.message.toString());
            }

            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                listener.onSucess(response.code(), response.body().toString());


            }

        })
        /*  apiService.callGetMethod(url)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe ({
                    result ->

                listener.onSucess(1, result.toString());
                Log.e("Response","Response"+result.toString())
            }, { error ->
                var code: Int = (error as HttpException).code()
                listener.onFailure(code,error.message.toString());

                error.printStackTrace()
            })*/
    }

  /*  override fun onFailure(call: Call<Any>, t: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        // var code: Int = (error as HttpException).code()


    }

    override fun onResponse(call: Call<Any>, response: Response<Any>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }
*/
}