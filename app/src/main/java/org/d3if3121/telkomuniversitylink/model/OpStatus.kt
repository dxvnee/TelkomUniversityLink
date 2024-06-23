package org.d3if3121.telkomuniversitylink.model

import com.squareup.moshi.Json

data class OpStatus(
    @Json(name="message")
    val message: String?,

    @Json(name="status")
    val status: String?
)
