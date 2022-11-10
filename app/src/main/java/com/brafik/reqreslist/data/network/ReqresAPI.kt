package com.brafik.reqreslist.data.network

import com.brafik.reqreslist.data.models.UsersList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresAPI {
    @GET("users")
    suspend fun getDataFromAPI(@Query("page") query: String): Response<UsersList>
}