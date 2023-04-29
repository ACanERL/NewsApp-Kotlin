package com.example.newsapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.contants.Constants

import com.example.newsapp.model.NewsResponse
import com.example.newsapp.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository):ViewModel(){
    private val _response=MutableLiveData<NewsResponse>()
    private val _responseBusiness=MutableLiveData<NewsResponse>()
    private val _responseHealt=MutableLiveData<NewsResponse>()
    private val _responseSport=MutableLiveData<NewsResponse>()
    var loadingProgressBar=MutableLiveData<Boolean>()


    val newsResponse:LiveData<NewsResponse>
        get() = _response

    val businessResponse:LiveData<NewsResponse>
        get() = _responseBusiness

    val healtResponse:LiveData<NewsResponse>
        get() = _responseHealt

    val sportResponse:LiveData<NewsResponse>
        get() = _responseSport

    init {
        getGeneral()
        getBusiness()
        getHealt()
        getSport()
    }

    private fun getGeneral()=viewModelScope.launch {
        repository.getGenerals("in","general", apiKey = Constants.apiKey).let {
            if(it.isSuccessful){
                _response.postValue(it.body())
                loadingProgressBar.value=false
            }
            else{
                Log.d("response", "error: ${it.code()}")
            }
        }
    }
    private fun getBusiness()=viewModelScope.launch {
        repository.getGenerals("in","business", apiKey = Constants.apiKey).let {
            if(it.isSuccessful){
                _responseBusiness.postValue(it.body())
                loadingProgressBar.value=false
            }else{
                Log.d("response", "error: ${it.code()}")
            }
        }
    }
    private fun getHealt()=viewModelScope.launch{
        repository.getGenerals("in","health", apiKey = Constants.apiKey).let {
            if(it.isSuccessful){
                _responseHealt.postValue(it.body())
                loadingProgressBar.value=false
            }else{
                Log.d("response", "error: ${it.code()}")
            }
        }
    }

    private fun getSport()=viewModelScope.launch {
        repository.getGenerals("in","sport", apiKey = Constants.apiKey).let {
            if(it.isSuccessful){
                _responseSport.postValue(it.body())
                loadingProgressBar.value=false
            }else{
                Log.d("response", "error: ${it.code()}")
            }
        }
    }

}