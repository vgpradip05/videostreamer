package com.pradip.video.home.paging

import androidx.paging.PagingSource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pradip.core.networking.DataResult
import com.pradip.data.user.local.entities.VideoDetail
import com.pradip.data.user.remote.VideoDetailsR
import com.pradip.video.home.interfaces.FetchVideoList
import java.io.IOException

class VideoPagingSource(private val remote: FetchVideoList.Remote) :
    PagingSource<Int, VideoDetail>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, VideoDetail> {
        try {
            // Start refresh at page 1 if undefined.
            val nextPage = params.key ?: 1
            return when (val response = remote.getVideoList(nextPage)) {
                is DataResult.Success -> {
                    val t = object : TypeToken<VideoDetailsR>() {}.type
                    val data = Gson().fromJson<VideoDetailsR>(response.data, t)
                    return LoadResult.Page(
                        data = data.list,
                        prevKey = if (nextPage == 1) null else nextPage - 1,
                        nextKey = data.page + 1
                    )
                }
                is DataResult.Failure -> {
                    LoadResult.Error(IOException("No Movie-list found."))
                }
                else -> LoadResult.Error(IOException("Failed to get list!"))
            }
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

}