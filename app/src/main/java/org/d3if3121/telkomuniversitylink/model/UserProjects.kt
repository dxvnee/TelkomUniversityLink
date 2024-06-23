package org.d3if3121.telkomuniversitylink.model

data class UserGroup(
    val projects: List<ProjectResponse>? = emptyList(),
    val webinars: List<WebinarResponse>? = emptyList()
)

