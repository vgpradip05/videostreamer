package com.pradip.data.user.remote

import com.google.gson.annotations.SerializedName
import com.pradip.data.user.local.entities.VideoDetail
import java.util.*

data class VideoDetailsR(


    @SerializedName("page") val page: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("explicit") val explicit: String,
    @SerializedName("has_more") val hasMore: String,
    @SerializedName("total") val total: Int,
    @SerializedName("list") val list: List<VideoDetail>
)
