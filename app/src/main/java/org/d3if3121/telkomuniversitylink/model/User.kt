package org.d3if3121.telkomuniversitylink.model

data class User(
    var userId: String = "",
    var userName: String = "",
    var password: String = "",
    var email: String = "",
    var role: String = "",
    var profile: String = ""
)