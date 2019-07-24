package com.vicolmoraes.itauchallenge

import com.vicolmoraes.itauchallenge.model.Usuario
import retrofit2.Call
import retrofit2.http.GET

interface UsuarioService {
    @GET("itau.json")
    fun list(): Call<Usuario>
}