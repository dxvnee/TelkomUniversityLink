package org.d3if3121.telkomuniversitylink.viewmodel


import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import org.d3if3121.telkomuniversitylink.firebase.UserRepository
import org.d3if3121.telkomuniversitylink.model.LoginRequest
import org.d3if3121.telkomuniversitylink.model.LoginResponse
import org.d3if3121.telkomuniversitylink.model.RegisterRequest
import org.d3if3121.telkomuniversitylink.model.User
import org.d3if3121.telkomuniversitylink.model.UserGroup
import org.d3if3121.telkomuniversitylink.network.UserApi
import retrofit2.HttpException

class UserViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    private val _registrationSuccess = MutableStateFlow(false)
    val registrationSuccess: StateFlow<Boolean> = _registrationSuccess

    private val _groupList = MutableStateFlow<UserGroup?>(null)
    val groupList: StateFlow<UserGroup?> = _groupList

    private val _registrationError = MutableStateFlow<String?>(null)
    val registrationError: StateFlow<String?> = _registrationError

    private val _errorMsg = MutableStateFlow<String?>(null)
    val errorMsg: StateFlow<String?> = _errorMsg


    fun registerWithApi(user: RegisterRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = UserApi.service.registerUser(user)
                _registrationSuccess.value = true
            } catch (e: Exception) {
                _registrationError.value = e.message
            }
        }
    }

    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess: StateFlow<Boolean> = _loginSuccess

    private val _loginError = MutableStateFlow<String?>(null)
    val loginError: StateFlow<String?> = _loginError

//    fun loginUser(email: String, password: String) {
//        viewModelScope.launch {
//            auth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        _loginSuccess.value = true
//                    } else {
//                        val errorMessage = when (val exception = task.exception) {
//                            is FirebaseAuthException -> when (exception.errorCode) {
//                                "ERROR_INVALID_EMAIL" -> "Email tidak valid."
//                                "ERROR_USER_NOT_FOUND" -> "Email tidak ditemukan."
//                                "ERROR_WRONG_PASSWORD" -> "Password salah."
//                                "ERROR_USER_DISABLED" -> "Akun dinonaktifkan."
//                                "ERROR_TOO_MANY_REQUESTS" -> "Terlalu banyak percobaan. Coba lagi nanti."
//                                else -> "Kesalahan autentikasi."
//                            }
//                            else -> exception?.message ?: "Kesalahan tidak diketahui."
//                        }
//                        _loginError.value = errorMessage
//                    }
//                }
//        }
//    }

    fun loginWithApi(user: LoginRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _currentUser.value = UserApi.service.login(user)
                _loginSuccess.value = true
            } catch (e: Exception) {
                _loginError.value = e.message
            }
        }
    }

    // Update user profile
    private val userRepository = UserRepository()

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser

    private val _updateSuccess = MutableStateFlow(false)
    val updateSuccess: StateFlow<Boolean> get() = _updateSuccess

    private val _updateError = MutableStateFlow<String?>(null)
    val updateError: StateFlow<String?> get() = _updateError

//    init {
//        fetchCurrentUser()
//    }
//
//    private fun fetchCurrentUser() {
//        val userId = userRepository.auth.currentUser?.uid
//        userId?.let {
//            fetchUserData(it)
//        }
//    }

//    private fun fetchUserData(userId: String) {
//        viewModelScope.launch {
//            try {
//                val user = userRepository.getUserById(userId)
//                _currentUser.value = user
//            } catch (e: Exception) {
//                _updateError.value = e.message
//                Log.d("UserViewModel", "Error fetching user data: ${e.message}")
//            }
//        }
//    }

//    fun update(userName: String, newPassword: String?, email: String, gambar: String,  onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
//        val userId = _currentUser.value?.uid ?: return
//        val userDocRef = userRepository.firestore.collection("users").document(userId)
//
//        viewModelScope.launch {
//            try {
//                val updates = hashMapOf<String, Any>(
//                    "userName" to userName,
//                    "email" to email,
//                    "gambar" to gambar
//                )
//
//                if (!newPassword.isNullOrBlank()) {
//                    val user = userRepository.auth.currentUser
//                    user?.updatePassword(newPassword)?.await()
//                    updates["password"] = newPassword
//                }
//                userDocRef.update(updates).await()
//                fetchUserData(userId) // Refresh current user data
//                _updateSuccess.value = true
//                _updateError.value = null
//                Log.d("UserViewModel", "User profile updated successfully.")
//                onSuccess()
//            } catch (e: Exception) {
//                _updateError.value = e.message
//                _updateSuccess.value = false
//                Log.d("UserViewModel", "Error updating user profile: ${e.message}")
//                onFailure(e)
//            }
//        }
//    }

//    private fun saveUserToFirestore(user: User) {
//        firestore.collection("users").document(user.uid)
//            .set(user)
//            .addOnSuccessListener {
//                _registrationSuccess.value = true
//            }
//            .addOnFailureListener { e ->
//                _registrationError.value = e.message
//            }
//    }
    fun getGroup() {
    viewModelScope.launch(Dispatchers.IO) {
        try {
            _groupList.value = UserApi.service.getUserGroup(_currentUser.value!!.id)
        } catch (e: Exception) {
            _errorMsg.value = e.message
        }
    }
    }


    fun logout() {
        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut()
        val authStateListener = FirebaseAuth.AuthStateListener {
            if (it.currentUser == null) {
                Log.d(TAG, "Inside sign out success")
            } else {
                Log.d(TAG, "Inside sign out is not success")
            }
        }
        firebaseAuth.addAuthStateListener(authStateListener)
    }

}