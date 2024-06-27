package org.d3if3121.telkomuniversitylink.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.d3if3121.telkomuniversitylink.model.Project
import org.d3if3121.telkomuniversitylink.model.Webinar
import org.d3if3121.telkomuniversitylink.network.ApiStatus
import org.d3if3121.telkomuniversitylink.network.UserApi

class ContentViewModel : ViewModel() {

    var status = MutableStateFlow(ApiStatus.LOADING)
        private set

    private var _webinar = MutableStateFlow<List<Webinar>>(emptyList())
    val webinarData : StateFlow<List<Webinar>> = _webinar


    private var _project = MutableStateFlow<List<Project>>(emptyList())
    val projectData : StateFlow<List<Project>> = _project

    fun getAllWebinar() {
        viewModelScope.launch(Dispatchers.IO){
            status.value = ApiStatus.LOADING
            try {
                val result = UserApi.service.getAllWebinar()
                status.value = ApiStatus.SUCCESS
                _webinar.value = result



            } catch (e: Exception){
                Log.d("getAllWebinar", "Failure: ${e.message}")
                status.value = ApiStatus.FAILED
            }
        }
    }


    fun getAllProject() {
        viewModelScope.launch(Dispatchers.IO){
            status.value = ApiStatus.LOADING
            try {
                val result = UserApi.service.getAllProject()
                status.value = ApiStatus.SUCCESS
                _project.value = result

            } catch (e: Exception){
                Log.d("getAllWebinar", "Failure: ${e.message}")
                status.value = ApiStatus.FAILED
            }
        }
    }

    fun registerWebinar(){
        viewModelScope.launch(Dispatchers.IO){
            try {

            } catch (e: Exception){
                Log.d("getAllWebinar", "Failure: ${e.message}")
            }
        }
    }

}
