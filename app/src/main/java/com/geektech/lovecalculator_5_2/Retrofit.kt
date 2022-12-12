package com.geektech.lovecalculator_5_2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class   RetrofitServiсe {
        companion object{
            val retrofit = Retrofit.Builder().baseUrl("https://pixabay.com").
            addConverterFactory(GsonConverterFactory.create()).build()

            var api = retrofit.create(PixaApi::class.java)
        }
    }
