package com.geektech.lovecalculator_5_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.geektech.lovecalculator_5_2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var adapter = ImageAdapter(arrayListOf())
    private var page:Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        with(binding){


            BTN.setOnClickListener {
                doRequest(++page)
            }

            BTN2.setOnClickListener {
                page = 1
                doRequest(page)

            }
        }
    }

    private fun ActivityMainBinding.doRequest(i: Int) {
        RetrofitServiсe.api.getImage(EDT.text.toString(), page = page)
            .enqueue(object : Callback<PixaModel> {
                override fun onResponse(call: Call<PixaModel>, response: Response<PixaModel>) {
                    if (response.isSuccessful) {
                        response.body()?.hits?.let {
                            it.forEach{
                                adapter.addImage(it)
                            }
                            binding.Recycler.adapter = adapter
                        }
                    }
                    Log.e("ololo", "onResponse: ${response.body()!!.hits[0].largeImageURL}")
                }

                override fun onFailure(call: Call<PixaModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message}")
                }

            })
    }

}