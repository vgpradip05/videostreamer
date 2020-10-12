package com.pradip.video.home.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.pradip.video.home.interfaces.FetchVideoList
import com.pradip.video.home.paging.VideoPagingSource

class VideoListRepo(
    private val remote: FetchVideoList.Remote

) : FetchVideoList.Repository {
    override suspend fun getVideoList() =
        Pager(PagingConfig(pageSize = 10)) {
            VideoPagingSource(remote)
        }
}
