package com.example.proyectomobil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.proyectomobil.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), VideoAdapter.OnItemClickListener  {

lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retroftiTraer = RetrofitClient.consumirApi.getTraer()

        retroftiTraer.enqueue(object : Callback<Videos>{
            override fun onResponse(call: Call<Videos>, response: Response<Videos>) {
                val videos = response.body()?.videos ?: emptyList()
                val adapter = VideoAdapter(videos, this@MainActivity)
                binding.recyclerView.adapter = adapter
            }


            override fun onFailure(call: Call<Videos>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error al consultar Api Rest", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onItemClick(video: Video, videoUrls: List<String>) {
        val intent = Intent(this, VideoPlayerActivity::class.java)
        intent.putExtra("VIDEO_TITLE", video.title)
        intent.putExtra("VIDEO_SUBTITLE", video.MAS)
        intent.putExtra("VIDEO_URLS", video.sources.toTypedArray())

        startActivity(intent)
    }

}