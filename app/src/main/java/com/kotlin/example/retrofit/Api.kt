package com.kotlin.example.retrofit

import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @GET
    abstract fun callGetMethod(@Url url: String): Call<ResponseBody>

    @GET
    abstract fun callGetMethod(@Url url: String, @Header("Authorization") access_token: String): Call<ResponseBody>

    @POST
    abstract fun callPostMethod(@Url url: String, @Body request: Any): Call<ResponseBody>

    @POST
    abstract fun callPostMethod(@Url url: String, @Body request: Any, @Header("Authorization") access_token: String): Call<ResponseBody>

    @POST
    abstract fun multiPartUpload(@Url url: String, @Body files: RequestBody): Call<ResponseBody>

    @POST
    abstract fun multiPartUpload(@Url url: String, @Body files: RequestBody, @Header("Authorization") accesstoken: String): Call<ResponseBody>

}