package com.kotlin.example.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.kotlin.example.BaseActivity
import com.kotlin.example.R
import com.kotlin.example.adapter.ListAdapter
import com.kotlin.example.callback.Listener
import com.kotlin.example.interfaces.ResultDataListner
import com.kotlin.example.model.Response
import kotlinx.android.synthetic.main.activity_main.*
import com.google.gson.reflect.TypeToken
import org.json.JSONObject


class MainActivity : BaseActivity(),ResultDataListner{



    val datalist: ArrayList<String> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //add dynamic data
        getRandomData();


    }

    fun callActivity(view: View)
    {
       /* showToast("you click second Activity");
        val intent= Intent(this, ApiCallActivity::class.java)
        startActivity(intent);*/

        /*var response:String="{\n" +
                "\"success\": true,\n" +
                "\"message\": \"Image uploaded successfully\",\n" +
                "\"data\": {\n" +
                "\"profile_image\": \"http://128.199.235.122/muon/public/uploads/profile/1552025215_IMG-5345.JPG\"\n" +
                "}\n" +
                "}"*/

        var resp:String;

        callRetrofitApi("http://192.168.1.59/test_api/test.php","GET", JsonObject(),object: Listener{
            override fun onSucess(code: Int, response: String) {
                resp=response;

                var gson=Gson()
                var res:Response=gson.fromJson(resp,Response::class.java)
                showToast(res.message)


            }

            override fun onFailure(code: Int, error: String) {

            }

        })

       /* callVolleyApi("http://192.168.1.59/test_api/test.php","GET", JSONObject(),object :Listener{
            override fun onSucess(code: Int, response: String) {
                var gson=Gson()
                var res:Response=gson.fromJson(response,Response::class.java)
                showToast(res.message)


            }

            override fun onFailure(code: Int, error: String) {
            }

        })
*/

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
