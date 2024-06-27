package org.d3if3121.telkomuniversitylink.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.d3if3121.telkomuniversitylink.model.Profile
import org.d3if3121.telkomuniversitylink.model.Project
import org.d3if3121.telkomuniversitylink.model.Webinar
import org.d3if3121.telkomuniversitylink.network.ApiStatus
import org.d3if3121.telkomuniversitylink.network.UserApi

class ProfileViewModel : ViewModel() {

    var status = MutableStateFlow(ApiStatus.LOADING)
        private set

    private var _profile = MutableStateFlow<Profile?>(null)
    val profileData : StateFlow<Profile?> = _profile

    private var _currentWebinar = MutableStateFlow<Webinar?>(null)
    val currentWebinar : StateFlow<Webinar?> = _currentWebinar

    private var _currentProject = MutableStateFlow<Project?>(null)
    val currentProject : StateFlow<Project?> = _currentProject

    fun getProfile(username: String) {
        viewModelScope.launch(Dispatchers.IO){
            status.value = ApiStatus.LOADING
            try {
                val result = UserApi.service.getProfile(username)
                Log.d("rere", result.toString())
                status.value = ApiStatus.SUCCESS
                _profile.value = result

            } catch (e: Exception){
                Log.d("getAllWebinar", "Failure: ${e.message}")
                status.value = ApiStatus.FAILED
            }
        }
    }
    fun getWebinarById(webinarId: String) {
        viewModelScope.launch(Dispatchers.IO){
            status.value = ApiStatus.LOADING
            try {
                val result = UserApi.service.getWebinarById(webinarId)
                status.value = ApiStatus.SUCCESS
                _currentWebinar.value = result

            } catch (e: Exception){
                Log.d("getAllWebinar", "Failure: ${e.message}")
                status.value = ApiStatus.FAILED
            }
        }
    }

    fun getProjectById(projectId: String) {
        viewModelScope.launch(Dispatchers.IO){
            status.value = ApiStatus.LOADING
            try {
                val result = UserApi.service.getProjectById(projectId)
                status.value = ApiStatus.SUCCESS
                _currentProject.value = result

            } catch (e: Exception){
                Log.d("getAllWebinar", "Failure: ${e.message}")
                status.value = ApiStatus.FAILED
            }
        }
    }


}
