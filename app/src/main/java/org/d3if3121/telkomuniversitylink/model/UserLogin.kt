package org.d3if3121.telkomuniversitylink.model

import com.squareup.moshi.Json

data class UserLogin(
    @Json(name="username")
    val username: String?,

    @Json(name="password")
    val password: String?
)
