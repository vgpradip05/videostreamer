package com.pradip.video.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pradip.data.user.local.entities.VideoDetail
import com.pradip.video.R
import com.pradip.video.databinding.VideoItemLayoutBinding

class VideoAdapter(val clickClickListener: IVideoListClickListener? = null) :
    PagingDataAdapter<VideoDetail, VideoAdapter.VideosViewHolder>(VideoComparator) {

    interface IVideoListClickListener {
        fun onClicked(video: VideoDetail)
    }

    inner class VideosViewHolder(private val binding: VideoItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(video: VideoDetail) {
            binding.videoItem = video


            val params: Map<String?, String?> = mapOf(
                "ui-highlight" to "fff",
                "queue-enabled" to "true",
                "logo" to "false"
            )
            binding.dmPlayerWebView?.initialize(
                "https://www.dailymotion.com/embed/",
                params,
                emptyMap()
            )
            binding.dmPlayerWebView?.load(mapOf("video" to video.id))
            binding.dmPlayerWebView?.showControls(false)
            binding.dmPlayerWebView?.mute()
            binding.dmPlayerWebView?.quality = "240"
            binding.dmPlayerWebView?.play()
            binding.root.setOnClickListener {
                clickClickListener?.onClicked(getItem(absoluteAdapterPosition)!!)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val view: VideoItemLayoutBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.video_item_layout,
            parent,
            false
        )

        return VideosViewHolder(view)
    }


    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
        holder.onBind(getItem(position)!!)

    }

    object VideoComparator : DiffUtil.ItemCallback<VideoDetail>() {
        override fun areItemsTheSame(oldItem: VideoDetail, newItem: VideoDetail): Boolean {
            // Id is unique.
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: VideoDetail, newItem: VideoDetail): Boolean {
            return oldItem == newItem
        }
    }
}