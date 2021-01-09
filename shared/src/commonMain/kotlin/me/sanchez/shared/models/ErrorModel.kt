package me.sanchez.shared.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorModel(@SerialName("message") var errorMessage: String,
                      @SerialName("code") var errorCode: Int)
