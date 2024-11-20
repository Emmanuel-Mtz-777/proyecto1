package com.example.myapplication1.data.model.network

import com.example.myapplication1.data.model.model.ServiceModel
import retrofit2.Response
import retrofit2.http.*
import retrofit2.http.GET


interface ApiService {
    @GET("service")
    suspend fun getService(): Response<List<ServiceModel>>

    @GET("service/{id}")
    suspend fun getService(@Path("id")id: Int): Response<ServiceModel>

    @POST("service")
    suspend fun createService(@Body service: ServiceModel): Response<List<ServiceModel>>

    @PUT("service/{id}")
    suspend fun updateService(@Path("id")id: Int, @Body service: ServiceModel): Response<ServiceModel>

    @DELETE("service/{id}")
    suspend fun deleteService(@Path("id")id: Int): Response<ServiceModel>
}
