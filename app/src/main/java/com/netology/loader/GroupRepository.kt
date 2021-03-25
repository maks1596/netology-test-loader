package com.netology.loader

import com.netology.loader.model.Data
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

internal object GroupRepository {

    private const val URL =
        "https://gitcdn.link/cdn/netology-code/rn-task/76cfe1a32000eec05b18894de3f2a43bebfae874/netology.json"

    suspend fun getData(): List<Data> = withContext(Dispatchers.IO) {
        HttpClient(CIO).use { client ->
            val httpResponse: HttpResponse = client.get(URL)

            if (httpResponse.status.isSuccess()) {
                val responseText = httpResponse.readText()
                Json.decodeFromString<GetDataResponse>(responseText).data
            } else emptyList()
        }
    }

    @Serializable
    private class GetDataResponse(
        @SerialName("data")
        val data: List<Data>
    )
}