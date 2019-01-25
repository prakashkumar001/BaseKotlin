package com.kotlin.example.retrofit;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface ApiInterface {

    @GET
    Call<Object> callGetMethod(@Url String url);

    @GET
    Call<Object> callGetMethod(@Url String url, @Header("Authorization") String access_token);

    @POST()
    Call<Object> callPostMethod(@Url String url, @Body Object request);

    @POST()
    Call<Object> callPostMethod(@Url String url, @Body Object request, @Header("Authorization") String access_token);

    @POST
    Call<ResponseBody> multiPartUpload(@Url String url, @Body RequestBody files);

    @POST
    Call<Object> multiPartUpload(@Url String url, @Body RequestBody files, @Header("Authorization") String accesstoken);

}
