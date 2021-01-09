package me.sanchez.shared.services

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.*

class NetworkService {
    @KtorExperimentalAPI
    val httpClient = HttpClient {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
            acceptContentTypes += ContentType("application","json")
            acceptContentTypes += ContentType("text","javascript")
        }
    }

    private val baseUrl = "http://www.recipepuppy.com/api"

    val testUrl = "${baseUrl}?i=meatballs%2C+chicken+broth&q=meat&oi=1"

    fun composeUrlFromRequest(queryWord: String = "", withPics: Boolean): String {
        val onlyWithImages = if (withPics) 1 else 0
        return "${baseUrl}?q=${queryWord}&oi=${onlyWithImages}"
    }

    @KtorExperimentalAPI
    suspend inline fun <reified T> fetch(url: String): T? {
        return httpClient.get<T>(url)
    }
}