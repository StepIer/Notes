package com.justnotes.foryou.presentation.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.justnotes.foryou.data.PlaceHolderApi
import com.justnotes.foryou.domain.usecase.AddNoteUseCase
import com.justnotes.foryou.domain.usecase.GetNoteUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class LoginViewModel(
    private val addNoteUseCase: AddNoteUseCase,
    private val getNoteUseCase: GetNoteUseCase
) : ViewModel() {

    var loginLiveData = MutableLiveData<String>()
    var passwordLiveData = MutableLiveData<String>()


    lateinit var placeHolderApi: PlaceHolderApi


    init {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        placeHolderApi = retrofit.create(PlaceHolderApi::class.java)

        val disposable = placeHolderApi.getTodos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ todos ->
                todos.forEach { Log.d("todos", it.toString()) }
            }, { exeption ->
                exeption.printStackTrace()
            })


    }


}