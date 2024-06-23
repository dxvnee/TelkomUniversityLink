package org.d3if3121.telkomuniversitylink.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.d3if3121.telkomuniversitylink.model.WebinarResponse
import org.d3if3121.telkomuniversitylink.network.UserApi

class WebinarViewModel(): ViewModel() {

    private val _webinarList = MutableStateFlow<List<WebinarResponse>?>(null)
    val webinarList: StateFlow<List<WebinarResponse>?> = _webinarList

    private val _errorMsg = MutableStateFlow<String?>(null)
    val errorMsg: StateFlow<String?> = _errorMsg

    init {
        getAllWebinars()
    }


    private fun getAllWebinars() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _webinarList.value = UserApi.service.getAllWebinars()
            } catch (e: Exception) {
                _errorMsg.value = e.message
            }
        }
    }


}