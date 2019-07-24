package com.vicolmoraes.itauchallenge.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Usuario(
    @SerializedName("nome")
    var nome: String,

    @SerializedName("conta_corrente")
    var conta_corrente: Double,

    @SerializedName("conta_poupanca")
    var conta_poupanca: Double,

    @SerializedName("contatos")
    var contatos: ArrayList<String>
) : Serializable