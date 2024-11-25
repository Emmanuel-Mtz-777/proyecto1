package com.example.myapplication1.data.model.controller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication1.data.model.model.ServiceModel
import com.example.myapplication1.data.model.network.RetrofitClient
import kotlinx.coroutines.launch
import retrofit2.Response

class ServiceViewModel: ViewModel() {
    val api = RetrofitClient.api
    fun getServices(onResult: (Response<List<ServiceModel>>)->Unit) {
        viewModelScope.launch {
            try{
                val response = api.getService()
                onResult(response)
            }catch(exception:Exception){
                print(exception)
            }
        }
    }
    fun showService(id: Int, onResult: (Response<ServiceModel>)->Unit) {
        viewModelScope.launch {
            try{
                val response = api.getService(id)
                onResult(response)
            }catch(exception:Exception){
                print(exception)
            }
        }
    }
    fun createService(service: ServiceModel,onResult: (Response<List<ServiceModel>>)->Unit) {
        viewModelScope.launch {
            try{
                val response = api.createService(service)
                onResult(response)
            }catch(exception:Exception){
                print(exception)
            }
        }
    }
    fun updateService(id: Int, service: ServiceModel,  onResult: (Response<ServiceModel>)->Unit) {
        viewModelScope.launch {
            try{
                val response = api.updateService(id,service)
                onResult(response)
            }catch(exception:Exception){
                print(exception)
            }
        }
    }
    fun deleteService(id: Int,  onResult: (Response<ServiceModel>)->Unit) {
        viewModelScope.launch {
            try{
                val response = api.deleteService(id)
                onResult(response)
            }catch(exception:Exception){
                print(exception)
            }
        }
    }
}

