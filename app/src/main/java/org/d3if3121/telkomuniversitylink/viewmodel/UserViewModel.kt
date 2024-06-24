package org.d3if3121.telkomuniversitylink.viewmodel


import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.d3if3121.telkomuniversitylink.firebase.UserRepository
import org.d3if3121.telkomuniversitylink.model.Profile
import org.d3if3121.telkomuniversitylink.model.Project
import org.d3if3121.telkomuniversitylink.model.UserRegister
import org.d3if3121.telkomuniversitylink.model.User
import org.d3if3121.telkomuniversitylink.model.Webinar
import org.d3if3121.telkomuniversitylink.network.UserApi

class UserViewModel : ViewModel() {

    var status = MutableStateFlow(ApiStatus.LOADING)
        private set
    var errorMessage = mutableStateOf<String?>(null)
        private set
    var loginSuccess = mutableStateOf<Boolean?>(false)
        private set

    private var _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser

    private var _currentProfile = MutableStateFlow<Profile?>(null)
    val currentProfile: StateFlow<Profile?> = _currentProfile

    private var _project = MutableStateFlow<List<Project>>(emptyList())
    val project: StateFlow<List<Project>> = _project

    private var _webinar = MutableStateFlow<List<Webinar>>(emptyList())
    val webinar : StateFlow<List<Webinar>> = _webinar


    fun registerUser(user: UserRegister) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = UserApi.service.registerUser(user)

                if (result.status == "success")
                else
                    throw Exception(result.message)

            } catch (e: Exception) {
                Log.d("UserViewModel-registerUser", "Failure: ${e.message}")
            }
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = UserApi.service.loginUser(email, password)

                if (result.message == "Failed") {
                    errorMessage.value = "Username/password doesn't match!"
                }
                if (result.message == "Success") {
                    _currentUser.value = UserApi.service.getUser(result.userId!!)
                    loginSuccess.value = true
                }

            } catch (e: Exception) {
                Log.d("UserViewModel-getUser", "Failure: ${e.message}")
            }
        }
    }

    fun getProfile(userId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = UserApi.service.getProfile(userId);

            } catch (e: Exception) {
                Log.d("UserViewModel-getUser", "Failure: ${e.message}")
            }
        }
    }

    fun getProject(userId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = UserApi.service.getProject()
                _project.value = result

            } catch (e: Exception) {
                Log.d("UserViewModel-getUser", "Failure: ${e.message}")
            }
        }
    }

    fun getWebinar(userId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = UserApi.service.getWebinar()
                _webinar.value = result

            } catch (e: Exception) {
                Log.d("UserViewModel-getUser", "Failure: ${e.message}")
            }
        }
    }


}

enum class ApiStatus { LOADING, SUCCESS, FAILED }