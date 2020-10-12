package com.pradip.video.home.di

import com.pradip.core.dependencies.base.BaseModule
import com.pradip.video.home.data.VideoListRepo
import com.pradip.video.home.data.VideosLocal
import com.pradip.video.home.interfaces.FetchVideoList
import com.pradip.video.home.interfaces.FetchVideoListRemote
import com.pradip.video.home.viewmodel.FetchVideosViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.dsl.module

/**
 * Dependency injection for Discover Videos
 */
object VideoListModule : BaseModule {
    override fun load() = loadKoinModules(videoListModule)
    override fun unload() = unloadKoinModules(videoListModule)
}

private val videoListModule = module {

    factory<FetchVideoList.Remote> { FetchVideoListRemote(apiService = get()) }
    factory<FetchVideoList.Local> { VideosLocal(dao = get()) }

    factory<FetchVideoList.Repository> {
        VideoListRepo(
            remote = get()
        )
    }
    viewModel { FetchVideosViewModel(dispatcher = get(), discoverRepo = get()) }

}
