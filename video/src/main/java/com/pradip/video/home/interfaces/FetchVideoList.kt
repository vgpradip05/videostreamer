package com.pradip.video.home.interfaces

import androidx.paging.Pager
import androidx.paging.PagingData
import com.google.gson.JsonObject
import com.pradip.core.networking.DataResult
import com.pradip.data.user.local.entities.VideoDetail
import com.pradip.data.user.remote.VideoDetailsR
import kotlinx.coroutines.flow.Flow


interface FetchVideoList {

    interface Repository {
        suspend fun getVideoList(): Pager<Int, VideoDetail>
    }

    interface Local {
        suspend fun getVideoList(): DataResult<List<VideoDetail>>
        suspend fun addVideoList(list:VideoDetailsR): List<VideoDetail>
    }

    interface Remote {
        suspend fun getVideoList(requestPage: Int = 1): DataResult<JsonObject>
    }
}
