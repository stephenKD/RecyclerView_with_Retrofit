package com.android.recyclerview_with_retrofit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.recyclerview_with_retrofit.adapter.MainAdapter
import com.android.recyclerview_with_retrofit.databinding.ActivityMainBinding
import com.android.recyclerview_with_retrofit.model.AllResponse
import com.android.recyclerview_with_retrofit.model.Data
import com.android.recyclerview_with_retrofit.service.NetworkManager
import com.android.recyclerview_with_retrofit.service.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var dataList = mutableListOf<Data>()
    val mainAdapter = MainAdapter(dataList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = mainAdapter
        }
        requestAPI()
    }

    private fun requestAPI() {
        val service = NetworkManager.client.create(Service::class.java)
        service.getAll("zh-tw", 1).enqueue(object : Callback<AllResponse> {
            override fun onResponse(call: Call<AllResponse>, response: Response<AllResponse>) {
                dataList.clear()
                response.body()?.let { dataList.addAll(it.data) }
                mainAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<AllResponse>, t: Throwable) {

            }

        })
    }
}