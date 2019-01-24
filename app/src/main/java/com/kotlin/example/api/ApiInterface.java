package com.kotlin.example.api;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

public interface ApiInterface {
    @GET("search/users")
    Observable<Object> search();
    @GET
    Call<Object> callGetMethod(@Url String url);

    @GET
    Observable<Object> callGetMethod(@Url String url, @Header("Authorization") String access_token);

    @POST()
    Observable<Object> callPostMethod(@Url String url, @Body Object request);

    @POST()
    Observable<Object> callPostMethod(@Url String url, @Body Object request, @Header("Authorization") String access_token);

    @POST
    Observable<ResponseBody> multiPartUpload(@Url String url, @Body RequestBody files);

    @POST
    Observable<Object> multiPartUpload(@Url String url, @Body RequestBody files, @Header("Authorization") String accesstoken);

}
