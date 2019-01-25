package com.kotlin.example.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.kotlin.example.BaseActivity
import com.kotlin.example.R

class MainActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun callActivity(view: View)
    {
        showToast("you click second Activity");
        val intent= Intent(this, ApiCallActivity::class.java)
        startActivity(intent);
    }



}
