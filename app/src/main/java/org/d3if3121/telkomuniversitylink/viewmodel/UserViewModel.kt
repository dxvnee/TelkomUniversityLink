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
import org.d3if3121.telkomuniversitylink.model.UserLogin
import org.d3if3121.telkomuniversitylink.model.Webinar
import org.d3if3121.telkomuniversitylink.network.ApiStatus
import org.d3if3121.telkomuniversitylink.network.UserApi
import java.util.Optional.empty

class UserViewModel : ViewModel() {

    var status = MutableStateFlow(ApiStatus.LOADING)
        private set
    var errorMessage = mutableStateOf<String?>(null)
        private set
    var loginSuccess = mutableStateOf<Boolean?>(false)
        private set
    var loginError = mutableStateOf<Boolean?>(false)
        private set

    var registerSuccess = mutableStateOf<Boolean?>(false)
        private set

    var registerError = mutableStateOf<String?>("Username cannot be empty")
        private set
    var registerErrorBoolean = mutableStateOf<Boolean>(false)
        private set

    private var _currentUser = MutableStateFlow<User>(User())
    val currentUser: StateFlow<User> = _currentUser

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
                    registerSuccess.value = true
                else
                    registerErrorBoolean.value = true
                    throw Exception(result.message)

            } catch (e: Exception) {
                Log.d("UserViewModel-registerUser", "Failure: ${e.message}")
            }
        }
    }

    fun loginUser(user: UserLogin) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = UserApi.service.loginUser(user)
                Log.d("User: ", user.toString())

                if (result.message == "User error" || result.message == "Password error") {
                    loginError.value = true
                }

                if (result.message == "Success") {
                    _currentUser.value = UserApi.service.getUser(result.userId!!)
                    if (_currentUser.value != null){
                        Log.d("HEHEHE ", result.toString())
                        Log.d("HEHEHE ", result.userId.toString())
                        Log.d("HEHEHE ", currentUser.value!!.toString())
                        loginError.value = false
                        loginSuccess.value = true
                    }
                }

            } catch (e: Exception) {
                Log.d("UserViewModel-getUser", "Failure: ${e.message}")
            }
        }
    }




}
