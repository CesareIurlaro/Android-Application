package com.example.myapplication.rawresponses.createresponces

import kotlinx.serialization.Serializable

@Serializable
data class CreateRegistrationJSON(
    val userLink: String,
    val matchLink: String,
    val outcome: String? = null
)