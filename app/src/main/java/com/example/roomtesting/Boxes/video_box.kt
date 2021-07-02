package com.tutomoney.by.roomtesting.Boxes

data class video_box(
    var p: Long,
    var i: String? = null, //image url of video
    var l: String? = null, //download url of video
    var n: String? = null, //name of video
    var s: String? = null, //size of video
    var t: String? = null  //time of video
)
{
    fun isNotEmpty(): Boolean {
        return  i != null && l != null && n != null && s != null && t != null
    }

}