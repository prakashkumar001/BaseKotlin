package com.kotlin.example

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun callActivity(view: View)
    {
        showToast("you click second Activity");
        val intent= Intent(this,SecondActivity::class.java)
        startActivity(intent);
    }



}
