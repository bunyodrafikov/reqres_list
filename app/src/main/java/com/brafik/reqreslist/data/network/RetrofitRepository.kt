package com.brafik.reqreslist.data.network

import com.brafik.reqreslist.data.models.UsersList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class RetrofitRepository @Inject constructor(
    private val reqresAPI: ReqresAPI,
) {
    suspend fun makeApiCall(query: String?): Response<UsersList> =
        withContext(Dispatchers.IO) {
            val call = reqresAPI.getDataFromAPI(query!!)
            call
        }
}