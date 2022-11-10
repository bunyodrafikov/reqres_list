package com.brafik.reqreslist.ui.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brafik.reqreslist.data.local.UserRepository
import com.brafik.reqreslist.data.models.User
import com.brafik.reqreslist.data.network.RetrofitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val retrofitRepository: RetrofitRepository,
    private val roomRepository: UserRepository,
) : ViewModel() {

    private val statusMessage = MutableLiveData<String>()
    val message: LiveData<String>
        get() = statusMessage

    fun getAllUsers(): LiveData<List<User>> {
        return roomRepository.getAllRecords()
    }

    @SuppressLint("ShowToast")
    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val call = retrofitRepository.makeApiCall("2")
                if (call.isSuccessful) {
                    roomRepository.deleteAllRecords()
                    statusMessage.postValue("Success")
                    call.body()?.data?.forEach {
                        roomRepository.insertRecord(it)
                    }
                    Log.d("logging", "Success")
                }
            } catch (ex: Exception) {
                when (ex) {
                    is IOException -> statusMessage.postValue("Network Failure")
                    else -> statusMessage.postValue(ex.message.toString())
                }
            }
        }
    }
}