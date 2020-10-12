package com.pradip.data.user.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pradip.data.user.remote.VideoDetailsR

@Entity(tableName = "VideoDetails")
data class VideoDetail(
    @PrimaryKey val id: String,
    val title: String,
    val channel: String,
    val owner: String

)
