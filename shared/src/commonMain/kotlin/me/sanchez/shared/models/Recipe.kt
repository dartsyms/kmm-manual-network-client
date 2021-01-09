package me.sanchez.shared.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Recipe(@SerialName("title") var title: String?,
                  @SerialName("href") var href: String,
                  @SerialName("ingredients") var ingredients: String?,
                  @SerialName("thumbnail") var imgUrl: String?)