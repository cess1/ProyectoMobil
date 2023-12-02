package com.example.proyectomobil.Video

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectomobil.databinding.ActivityVideosComidaBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), VideoAdapter.OnItemClickListener  {

    lateinit var binding: ActivityVideosComidaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideosComidaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retroftiTraer = RetrofitViComidas.consumirApi.getTraer()

        retroftiTraer.enqueue(object : Callback<Videos> {
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
        val intent = Intent(this, VideoVC::class.java)
        intent.putExtra("VIDEO_TITLE", video.title)
        intent.putExtra("VIDEO_MAS", video.MAS)
        intent.putExtra("VIDEO_URLS", video.sources.toTypedArray())

        startActivity(intent)
    }

}
