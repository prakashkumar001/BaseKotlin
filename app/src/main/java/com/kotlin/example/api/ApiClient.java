package com.kotlin.example.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
     * Factory class for convenient creation of the Api Service interface
     */
   public class ApiClient {

        public static ApiInterface create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://0dy0e.mocklab.io/")
                    .build();

            return retrofit.create(ApiInterface.class);
        }
    }