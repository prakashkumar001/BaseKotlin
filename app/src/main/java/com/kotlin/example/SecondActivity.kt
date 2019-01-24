package com.kotlin.example

import android.os.Bundle
import com.kotlin.example.callback.Listener

 class SecondActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        callGetApi("json/1",object :Listener{
            override fun onSucess(code: Int, response: String) {
            showToast(response);
            }

            override fun onFailure(code: Int, error: String) {
                showToast(error);
            }

        });
    }


}