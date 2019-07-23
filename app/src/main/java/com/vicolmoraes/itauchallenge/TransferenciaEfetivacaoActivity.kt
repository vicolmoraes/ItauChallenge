package com.vicolmoraes.itauchallenge

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.tranferencia_efetivacao_activity.*

class TransferenciaEfetivacaoActivity : AppCompatActivity() {

    lateinit var btConta: Button
    lateinit var etValor: EditText
    lateinit var btConfirmar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tranferencia_efetivacao_activity)

        findViews()
    }

    private fun findViews() {
        btConta = bt_conta_transferencia_efetivacao_activity
        etValor = et_valor_contato_transferencia_efetivacao_activity
        btConfirmar = bt_confirmar_transferencia_efetivacao_activity
    }
}