package org.d3if3121.telkomuniversitylink.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.d3if3121.telkomuniversitylink.model.ProjectResponse
import org.d3if3121.telkomuniversitylink.model.User
import org.d3if3121.telkomuniversitylink.network.UserApi

class ProjectViewModel(): ViewModel() {


    private val _projectList = MutableStateFlow<List<ProjectResponse>?>(null)
    val projectList: StateFlow<List<ProjectResponse>?> = _projectList

    private val _currentProject = MutableStateFlow<ProjectResponse?>(null)
    val currentProject: StateFlow<ProjectResponse?> = _currentProject

    private val _errorMsg = MutableStateFlow<String?>(null)
    val errorMsg: StateFlow<String?> = _errorMsg

    private val _registerSuccess = MutableStateFlow(false)
    val registerSuccess: StateFlow<Boolean> = _registerSuccess


    init {
        getAllProjects()
    }

    fun getCurrentProject(project_id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _currentProject.value = UserApi.service.getCurrentProject(project_id)
            } catch (e: Exception) {
                _errorMsg.value = e.message
            }
        }
    }

     fun loadDummyProjects() {
        val dummyProjects = listOf(
            ProjectResponse(
                id = 1,
                name = "Project Alpha",
                subtitle = "Engineer",
                detail = "Description for Project Alpha"
            ),
            ProjectResponse(
                id = 2,
                name = "Project Beta",
                subtitle = "Engineer",
                detail = "Description for Project Alpha"
            ),
            ProjectResponse(
                id = 3,
                name = "Project Gamma",
                subtitle = "Engineer",
                detail = "Description for Project Alpha"
            )
        )
        _projectList.value = dummyProjects
    }
    private fun getAllProjects() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _projectList.value = UserApi.service.getAllProjects()
            } catch (e: Exception) {
                _errorMsg.value = e.message
            }
        }
    }

    fun registerToProject(userId: Int, webinarId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _registerSuccess.value = UserApi.service.registerToProject(userId, webinarId)
            } catch (e: Exception) {
                _errorMsg.value = e.message
            }
        }
    }
}