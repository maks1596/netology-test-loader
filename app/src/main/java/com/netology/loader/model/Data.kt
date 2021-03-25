package com.netology.loader.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class Data(
    @SerialName("groups")
    val groups: List<Group>,

    @SerialName("direction")
    val direction: Direction
)