package me.sanchez.shared.services

import io.ktor.util.*
import me.sanchez.shared.models.RecipeList

class RecipeService {
    private val networkService = NetworkService()

    @KtorExperimentalAPI
    suspend fun loadRecipes(): RecipeList? {
        return networkService.fetch<RecipeList>(networkService.testUrl)
    }

    @KtorExperimentalAPI
    suspend fun searchRecipes(query: String, withPics: Boolean): RecipeList? {
        return networkService.fetch<RecipeList>(networkService.composeUrlFromRequest(query, withPics))
    }
}