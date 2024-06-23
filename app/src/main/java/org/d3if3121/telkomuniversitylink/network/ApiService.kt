package org.d3if3121.telkomuniversitylink.network


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3121.telkomuniversitylink.model.LoginRequest
import org.d3if3121.telkomuniversitylink.model.RegisterRequest
import org.d3if3121.telkomuniversitylink.model.RegisterResponse
import org.d3if3121.telkomuniversitylink.model.User
import org.d3if3121.telkomuniversitylink.model.ProjectResponse
import org.d3if3121.telkomuniversitylink.model.UserGroup
import org.d3if3121.telkomuniversitylink.model.WebinarResponse

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

private const val BASE_URL = "https://929d-139-228-112-175.ngrok-free.app"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @POST("/register")
    suspend fun registerUser(
        @Body request: RegisterRequest
    ): RegisterResponse

    @POST("/v1/posts/login")
    suspend fun login(
        @Body request: LoginRequest
    ): User


    @GET("/v1/posts/users/{user_id}")
    suspend fun getUserGroup(
        @Path("user_id") id: Int
    ): UserGroup


    @GET("/v1/posts/users/{user_id}/projects/{project_id}")
    suspend fun getUserData()

    @GET("/v1/posts/webinars/")
    suspend fun getAllWebinars(): List<WebinarResponse>

    @GET("/v1/posts/projects/")
    suspend fun getAllProjects(): List<ProjectResponse>

    @GET("/v1/posts/projects/{project_id}")
    suspend fun getCurrentProject(
        @Path("project_id") id: Int
    ): ProjectResponse

    @POST("/v1/posts/users/{user_id}/projects/{project_id}")
    suspend fun registerToProject(
        @Path("user_id") userId: Int,
        @Path("project_id") id: Int
    ): Boolean

    @POST("/v1/posts/users/{user_id}/webinars/{webinar_id}")
    suspend fun registerToWebinar(
        @Path("user_id") userId: Int,
        @Path("webinar_id") id: Int
    ): Boolean


}

object UserApi {
    val service: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }