package com.pradip.video.home.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pradip.core.ui.BaseFragment
import com.pradip.data.user.local.entities.VideoDetail
import com.pradip.video.R
import com.pradip.video.home.di.VideoListModule
import com.pradip.video.home.viewmodel.FetchVideosViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : BaseFragment(R.layout.fragment_home), VideoAdapter.IVideoListClickListener {

    override val fragmentTag = TAG
    lateinit var manager: LinearLayoutManager
    private lateinit var videoListAdapter: VideoAdapter
    private val viewModel: FetchVideosViewModel by sharedViewModel()

    override fun loadDependencies() = VideoListModule.load()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        manager = LinearLayoutManager(context)
        rv_videos.layoutManager = manager
        rv_videos.addItemDecoration(DividerItemDecoration(context, manager.orientation))
        videoListAdapter = VideoAdapter(this)
        rv_videos.adapter = videoListAdapter
        viewModel.getVideos()

        viewModel.videos.observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                videoListAdapter.submitData(it)
            }
        }
    }

    private fun showError(ex: Throwable) {
        // TODO
    }

    companion object {
        const val TAG = "HomeFragment"
    }

    override fun onClicked(video: VideoDetail) {

    }
}
