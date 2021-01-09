package me.sanchez.shared.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeList(@SerialName("title") var title: String,
                      @SerialName("results") var items: List<Recipe>)