package com.netology.loader.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class Badge(
    @SerialName("text")
    val text: String,

    @SerialName("color")
    val color: String,

    @SerialName("bgColor")
    val backgroundColor: String
)
