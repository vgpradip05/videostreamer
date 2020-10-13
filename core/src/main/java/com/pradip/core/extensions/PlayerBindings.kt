package com.pradip.core.extensions

import androidx.databinding.BindingAdapter
import com.dailymotion.android.player.sdk.PlayerWebView
import com.pradip.core.extensions.PlayerBindings.Extensions.initial
import com.pradip.core.extensions.PlayerBindings.Extensions.setControls
import com.pradip.core.extensions.PlayerBindings.Extensions.setMute
import com.pradip.core.extensions.PlayerBindings.Extensions.setVideoQuality
import com.pradip.core.extensions.PlayerBindings.Extensions.setVideos


class PlayerBindings {
    companion object Binding {

        @JvmStatic
        @BindingAdapter("loadVideo")
        fun PlayerWebView.loadVideo(id: String){
            setVideos(id)
        }

        @JvmStatic
        @BindingAdapter("init")
        fun PlayerWebView.init(boolean: Boolean) {
            initial(boolean)
        }


        @JvmStatic
        @BindingAdapter("controls")
        fun PlayerWebView.setControl(boolean: Boolean) {
            setControls(boolean)
        }

        @JvmStatic
        @BindingAdapter("toMute")
        fun PlayerWebView.toMute(boolean: Boolean) {
            setMute(boolean)
        }

        @JvmStatic
        @BindingAdapter("setQuality")
        fun PlayerWebView.setQuality(quality: String) {
            setVideoQuality(quality)
        }

        val params: Map<String?, String?> = mapOf(
            "ui-highlight" to "fff",
            "queue-enabled" to "true",
            "logo" to "false"
        )
        val baseUrl = "https://www.dailymotion.com/embed/"
    }

    object Extensions {

        fun PlayerWebView.setVideos(entry:String) {
            load(mapOf("video" to entry))
        }

        fun PlayerWebView.setControls(boolean: Boolean) {
            showControls(boolean)
        }

        fun PlayerWebView.setMute(boolean: Boolean) {
            if (boolean)
                mute()
        }

        fun PlayerWebView.setVideoQuality(qu: String) {
            quality = qu
        }

        fun PlayerWebView.initial(boolean: Boolean) {
            if (boolean)
                initialize(baseUrl, params, emptyMap())
        }
    }

}
