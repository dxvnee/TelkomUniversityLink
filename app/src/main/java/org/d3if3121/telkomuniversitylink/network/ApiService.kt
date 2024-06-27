package org.d3if3121.telkomuniversitylink.network


import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3121.telkomuniversitylink.model.LoginStatus
import org.d3if3121.telkomuniversitylink.model.OpStatus
import org.d3if3121.telkomuniversitylink.model.Profile
import org.d3if3121.telkomuniversitylink.model.Project
import org.d3if3121.telkomuniversitylink.model.UserRegister
import org.d3if3121.telkomuniversitylink.model.User
import org.d3if3121.telkomuniversitylink.model.UserLogin
import org.d3if3121.telkomuniversitylink.model.Webinar
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

private const val BASE_URL = "https://2cb5-2404-8000-1024-18ef-70d4-c272-f1d8-e713.ngrok-free.app/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    //User
    @POST("/telulink/register")
    suspend fun registerUser(
        @Body request: UserRegister
    ): OpStatus

    @POST("/telulink/login")
    suspend fun loginUser(
        @Body user: UserLogin,
    ): LoginStatus

    @GET("/telulink/getUser/{id}")
    suspend fun getUser(
        @Path("id") userId: String,
    ): User

    //Content
    @GET("/telulink/webinar")
    suspend fun getAllWebinar(): List<Webinar>
    @GET("/telulink/webinar/{contentId}")
    suspend fun getWebinarById(
        @Path("contentId") webinarId: String
    ): Webinar

    @GET("/telulink/project/{contentId}")
    suspend fun getProjectById(
        @Path("contentId") projectId: String
    ): Project

    @GET("/telulink/project")
    suspend fun getAllProject(): List<Project>

    //Profile

    @GET("/telulink/profile")
    suspend fun getProfile(
        @Header("Authorization") username: String
    ): Profile


}

object UserApi {
    val service: ApiService by lazy {
        try {
            retrofit.create(ApiService::class.java)
        } catch (e: Exception) {
            Log.e("UserApi", "Error creating ApiService", e)
            throw e
        }
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }