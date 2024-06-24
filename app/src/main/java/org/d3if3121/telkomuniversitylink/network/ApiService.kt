package org.d3if3121.telkomuniversitylink.network


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3121.telkomuniversitylink.model.LoginStatus
import org.d3if3121.telkomuniversitylink.model.OpStatus
import org.d3if3121.telkomuniversitylink.model.Profile
import org.d3if3121.telkomuniversitylink.model.Project
import org.d3if3121.telkomuniversitylink.model.UserRegister
import org.d3if3121.telkomuniversitylink.model.User
import org.d3if3121.telkomuniversitylink.model.Webinar
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
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
        @Body request: UserRegister
    ): OpStatus

    @POST("/login")
    suspend fun loginUser(
        @Body username: String,
        @Body password: String,
    ): LoginStatus

    @GET("/getUser/{id}")
    suspend fun getUser(
        @Path("id") userId: String,
    ): User

    @GET("/getProfile")
    suspend fun getProfile(
        @Header("Authorization") username: String,
    ): Profile

    @GET("/project")
    suspend fun getProject(
    ): List<Project>

    @GET("/webinar")
    suspend fun getWebinar(
    ): List<Webinar>



}

object UserApi {
    val service: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }