package com.vicolmoraes.itauchallenge.model

import java.io.Serializable

data class Usuario(
    var nome: String,
    var conta_corrente: Double,
    var conta_poupanca: Double,
    var contatos: ArrayList<String>
) : Serializable