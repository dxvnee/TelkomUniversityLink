package org.d3if3121.telkomuniversitylink.model

import com.squareup.moshi.Json

data class RegisterRequest(

	@Json(name="password")
	val password: String,

	@Json(name="name")
	val name: String,

	@Json(name="email")
	val email: String
)
