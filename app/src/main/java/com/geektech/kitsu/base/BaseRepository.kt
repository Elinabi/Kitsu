package com.geektech.kitsu.base

import androidx.lifecycle.liveData
import com.geektech.kitsu.Resource
import java.security.cert.Extension

abstract class BaseRepository {

        fun <T> doRequest(request: suspend () -> T) = liveData{
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        }catch (exception: Exception){
            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
        }
    }
}