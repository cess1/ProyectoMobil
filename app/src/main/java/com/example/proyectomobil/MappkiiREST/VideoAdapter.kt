package com.example.proyectomobil

// VideoAdapter.kt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomobil.R

class VideoAdapter(private val videos: List<Video>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {



    interface OnItemClickListener {
        fun onItemClick(video: Video,videoUrls: List<String>)
    }

    inner class VideoViewHolder(itemView: View, private val listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        val textTitle: TextView = itemView.findViewById(R.id.textTitle)
        val textSubtitle: TextView = itemView.findViewById(R.id.textSubtitle)
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val video = videos[adapterPosition]
            val videoUrls = video.sources
            listener.onItemClick(video, videoUrls)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = videos[position]
        holder.textTitle.text = video.title
        holder.textSubtitle.text = video.MAS
    }

    override fun getItemCount(): Int {
        return videos.size
    }
}
