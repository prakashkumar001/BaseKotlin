package com.kotlin.example.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.kotlin.example.BaseActivity
import com.kotlin.example.R
import com.kotlin.example.adapter.ListAdapter
import com.kotlin.example.interfaces.ResultDataListner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),ResultDataListner{



    val datalist: ArrayList<String> = ArrayList();
    var listAdapter: ListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //add dynamic data
        getRandomData();

        showToast(getData().toString());
        demo_listView.layoutManager=LinearLayoutManager(this);
        listAdapter= ListAdapter(datalist,this);
        demo_listView.adapter=listAdapter
    }

    fun callActivity(view: View)
    {
        showToast("you click second Activity");
        val intent= Intent(this, ApiCallActivity::class.java)
        startActivity(intent);
    }


    fun getRandomData()
    {
        for( i in 0..5)
        {
            if(i==2)
            {
                datalist.add("item changed condition "+i.toString());

            }else
            {
                datalist.add("Item "+i.toString());

            }

        }
    }
    override fun getData(): ArrayList<String> {

        return datalist
    }

    //convert arraylist to array
    fun arraydata(): Array<String> {
        val array = arrayOfNulls<String>(datalist.size)

        datalist.toArray(array)
        return datalist.toTypedArray()
    }


}
