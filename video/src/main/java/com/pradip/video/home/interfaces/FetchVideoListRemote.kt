package com.pradip.video.home.interfaces

import com.google.gson.JsonObject
import com.pradip.core.networking.DataResult
import com.pradip.core.networking.callApi
import com.pradip.data.ApiService
import com.pradip.data.user.remote.VideoDetailsR


class FetchVideoListRemote(
    private val apiService: ApiService

) : FetchVideoList.Remote {

    override suspend fun getVideoList(requestPage: Int): DataResult<JsonObject> =
        callApi { apiService.getVideoList(requestPage,10) }

}
