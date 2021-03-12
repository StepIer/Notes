package com.justnotes.foryou.data

import io.reactivex.Single
import retrofit2.http.GET

interface PlaceHolderApi {
    @GET ("/todos")
    fun getTodos(): Single<List<Todos>>

}

