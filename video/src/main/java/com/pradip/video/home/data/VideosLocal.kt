package com.pradip.video.home.data

import com.pradip.core.extensions.toDataResult
import com.pradip.core.networking.DataResult
import com.pradip.data.user.local.dao.VideoDao
import com.pradip.data.user.local.entities.VideoDetail
import com.pradip.data.user.remote.VideoDetailsR
import com.pradip.video.home.interfaces.FetchVideoList

class VideosLocal(private val dao: VideoDao) : FetchVideoList.Local {
    override suspend fun getVideoList(): DataResult<List<VideoDetail>>  {
        return dao.getVideoDetails().toDataResult()
    }

    override suspend fun addVideoList(vr: VideoDetailsR): List<VideoDetail> {
        dao.upsert(vr.list)
        return vr.list
    }
}