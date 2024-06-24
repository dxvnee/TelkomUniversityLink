package org.d3if3121.telkomuniversitylink.model

data class Webinar(
    var webinarId : String,
    var name : String,
    var company : String,
    var content: String,
    var image : String, 
    var userOrdered : List<String>
)