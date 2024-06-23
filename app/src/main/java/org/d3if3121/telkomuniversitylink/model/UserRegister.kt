package org.d3if3121.telkomuniversitylink.model

import com.squareup.moshi.Json

data class UserRegister(
	@Json(name="username")
	val username: String,

	@Json(name="email")
	val email: String,

	@Json(name="password")
	val password: String,
)
