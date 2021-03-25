package com.netology.loader.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class Direction(
    @SerialName("id")
    val id: String,

    @SerialName("link")
    val link: String,

    @SerialName("title")
    val title: String,

    @SerialName("badge")
    val badge: Badge
)
