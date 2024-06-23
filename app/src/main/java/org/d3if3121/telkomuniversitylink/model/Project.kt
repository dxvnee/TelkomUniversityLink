package org.d3if3121.telkomuniversitylink.model

data class ProjectResponse(
    val id: Int,
    val name: String,
    val subtitle: String,
    val detail: String
)

data class ProjectRequest(
    val name: String,
    val subtitle: String,
    val detail: String
)

