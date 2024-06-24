package org.d3if3121.telkomuniversitylink.model

import com.squareup.moshi.Json

data class LoginStatus(
    @Json(name="message")
    val message: String?,

    @Json(name="username")
    val username: String?,

    @Json(name="userId")
    val userId: String?
)
