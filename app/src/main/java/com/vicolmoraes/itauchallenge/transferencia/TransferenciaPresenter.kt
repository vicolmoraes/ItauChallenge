package com.vicolmoraes.itauchallenge.transferencia

import com.vicolmoraes.itauchallenge.model.Usuario

class TransferenciaPresenter {
    lateinit var mainActivity: TransferenciaActivity

    fun setContatos(usuario: Usuario) {
        mainActivity.setRecycler(usuario.contatos)
        mainActivity.setValores(usuario)
    }
}