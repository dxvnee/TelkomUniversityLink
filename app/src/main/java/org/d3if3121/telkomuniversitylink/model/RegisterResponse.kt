package org.d3if3121.telkomuniversitylink.model

import com.squareup.moshi.Json

data class RegisterResponse(

	@Json(name="projects")
	val projects: List<Any?>? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="email")
	val email: String? = null,

	@Json(name="webinars")
	val webinars: List<Any?>? = null
)
