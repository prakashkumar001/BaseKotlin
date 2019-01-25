package com.kotlin.example.volley

import android.util.Log
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyLog
import com.android.volley.toolbox.JsonObjectRequest
import com.kotlin.example.callback.Listener
import com.kotlin.example.common.GlobalClass
import org.json.JSONObject

 class VolleyRequestResponse  {
    val TAG = VolleyRequestResponse::class.java.simpleName
    val basePath = "http://0dy0e.mocklab.io/"

     fun post(path: String,request:String, param: JSONObject,listener : Listener) {

         var methodType:Int;
         val params:JSONObject;
     if (request.equals("GET")) {
             methodType = Request.Method.GET;
             params = JSONObject();
         } else {
             methodType = Request.Method.POST;
             params=param;
         }

         val jsonObjReq = object : JsonObjectRequest(methodType, basePath + path, params,
                Response.Listener<JSONObject> { response ->
                    Log.d(TAG, "/post request OK! Response: $response")
                    listener.onSucess(1,response.toString());

                },
                Response.ErrorListener { error ->
                    VolleyLog.e(TAG, "/post request fail! Error: ${error.message}")
                    listener.onFailure(1,error.message.toString());
                }) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers.put("Content-Type", "application/json")
                return headers
            }
        }

         GlobalClass.instance?.addToRequestQueue(jsonObjReq, TAG)
    }
}