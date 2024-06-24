package org.d3if3121.telkomuniversitylink.model

data class Profile(
    var fullname: String,
    var phone: String,
    var location: String,
    var bio: List<String>,
    var picture: String,
    var webinars: List<String>,
    var project: List<String>,
)