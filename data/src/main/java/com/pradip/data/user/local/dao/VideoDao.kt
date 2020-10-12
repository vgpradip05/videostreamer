package com.pradip.data.user.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.pradip.data.user.local.entities.VideoDetail
import com.pradip.data.util.BaseDao

@Dao
abstract class VideoDao : BaseDao<VideoDetail> {

    @Query("SELECT * FROM VideoDetails")
    abstract fun getVideoDetails(): List<VideoDetail>

}
