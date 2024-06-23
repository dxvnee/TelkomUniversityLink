package org.d3if3121.telkomuniversitylink.model

data class WebinarResponse(
    val id: Int,
    val title: String,
    val subtitle: String,
    val description: String
)

data class WebinarRequest(
    val title: String,
    val subtitle: String,
    val description: String
)
