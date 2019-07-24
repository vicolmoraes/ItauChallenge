package com.vicolmoraes.itauchallenge.transferencia

import com.vicolmoraes.itauchallenge.model.Usuario

class TransferenciaPresenter {
    lateinit var mainActivity: TransferenciaActivity

    fun setContatos(usuario: List<Usuario>) {

        mainActivity.setRecycler(usuario.get(0).contatos)
    }
}