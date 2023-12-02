package com.example.proyectomobil.Video

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectomobil.R

class VideoVC : AppCompatActivity() {

    lateinit var videoView: VideoView
    lateinit var videoTitleTextView: TextView
    var urlVideo: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_v_c)

        videoView = findViewById(R.id.vdPromocional)
        videoTitleTextView = findViewById(R.id.videoTitleTextView)

        // Obténer los extras del intent
        val videoTitle = intent.getStringExtra("VIDEO_TITLE") ?: "Video"
        val videoSources = intent.getStringArrayExtra("VIDEO_URLS") ?: emptyArray()

        if (videoSources.isNotEmpty()) {
            urlVideo = videoSources[0]
            val uri: Uri = Uri.parse(urlVideo)
            videoView.setVideoURI(uri)

            val mediaController = MediaController(this)
            mediaController.setAnchorView(videoView)
            mediaController.setMediaPlayer(videoView)
            videoView.setMediaController(mediaController)

            videoView.start()

            // Actualiza el TextView con el título del video
            videoTitleTextView.text = videoTitle

        }
    }
}