package com.geektech.lovecalculator_5_2

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Query



    interface PixaApi {

        @GET("/api/")
        fun getImage(
            @Query("q") keyWord:String,
            @Query("key") key:String = "31514133-499c512266452a0c0a7e32b08",
            @Query("page") page:Int,
            @Query("per_page") per_page:Int = 5
        ): retrofit2.Call<PixaModel>
    }
