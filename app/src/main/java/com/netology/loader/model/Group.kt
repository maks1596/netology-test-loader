package com.netology.loader.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class Group(
    @SerialName("id")
    val id: String,

    @SerialName("link")
    val link: String,

    @SerialName("title")
    val title: String,

    @SerialName("badge")
    val badge: Badge,

    @SerialName("items")
    val items: List<Item>
) {

    @Serializable
    data class Item(
        @SerialName("id")
        val id: String,

        @SerialName("link")
        val link: String,

        @SerialName("title")
        val title: String,

        @SerialName("badge")
        val badge: Badge
    )
}
