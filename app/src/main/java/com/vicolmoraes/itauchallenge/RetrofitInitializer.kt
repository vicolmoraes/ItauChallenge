package com.vicolmoraes.itauchallenge


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/vicolmoraes/ItauChallenge/master/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun buildingService(): UsuarioService {
        return retrofit.create(UsuarioService::class.java)
    }
}