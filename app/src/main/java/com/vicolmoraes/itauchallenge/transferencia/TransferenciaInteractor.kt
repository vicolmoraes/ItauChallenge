package com.vicolmoraes.itauchallenge.transferencia

import com.vicolmoraes.itauchallenge.RetrofitInitializer
import com.vicolmoraes.itauchallenge.model.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TransferenciaInteractor {

    lateinit var presenter: TransferenciaPresenter

    fun fetch() {
        val call = RetrofitInitializer().buildingService().list()
        call.enqueue(object : Callback<List<Usuario>?> {
            override fun onResponse(
                call: Call<List<Usuario>?>?,
                response: Response<List<Usuario>?>?
            ) {
                val usuarios: List<Usuario> = response?.body()!!
                presenter.setContatos(usuarios)
            }

            override fun onFailure(
                call: Call<List<Usuario>?>?,
                t: Throwable?
            ) {
            }
        })
    }
}