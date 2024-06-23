package org.d3if3121.telkomuniversitylink.model

data class User(
    var id: Int = 0,
    var userName: String = "",
    var password: String = "",
    var email: String = "",
    var job: String = "",
    var address: String = "",
    var phone: String = "",
    var about_me: String = ""
)