package com.pradip.video.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pradip.core.dispatchers.Dispatcher
import com.pradip.core.extensions.collectOn
import com.pradip.core.extensions.flowOnBack
import com.pradip.core.viewmodel.BaseViewModel
import com.pradip.data.user.local.entities.VideoDetail
import com.pradip.video.home.di.VideoListModule
import com.pradip.video.home.interfaces.FetchVideoList


class FetchVideosViewModel(
    private val discoverRepo: FetchVideoList.Repository,
    private val dispatcher: Dispatcher

) : BaseViewModel(dispatcher) {


    /** Exposed LiveData **/

    private val _videos: MutableLiveData<PagingData<VideoDetail>> = MutableLiveData()

    val videos: LiveData<PagingData<VideoDetail>>
        get() = _videos


    fun getVideos() {
        launchOnMain {
            discoverRepo.getVideoList().flow.cachedIn(viewModelScope).flowOnBack(dispatcher)
                .collectOn(_videos)
        }
    }

    override fun onCleared() {
        VideoListModule.unload()
        super.onCleared()
    }
}


