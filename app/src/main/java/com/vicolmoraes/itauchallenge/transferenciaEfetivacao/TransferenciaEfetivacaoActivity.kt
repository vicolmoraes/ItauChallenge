package com.vicolmoraes.itauchallenge.transferenciaEfetivacao

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.vicolmoraes.itauchallenge.R
import com.vicolmoraes.itauchallenge.erro.ErroActivity
import com.vicolmoraes.itauchallenge.sucesso.SucessoActivity
import com.vicolmoraes.itauchallenge.utils.MaskEditUtil
import kotlinx.android.synthetic.main.tranferencia_efetivacao_activity.*

class TransferenciaEfetivacaoActivity : AppCompatActivity() {

    lateinit var btConta: Button
    lateinit var etValor: EditText
    lateinit var tvContato: TextView
    lateinit var btConfirmar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tranferencia_efetivacao_activity)

        findViews()
    }

    private fun findViews() {
        val contato = intent.extras.get("contato") as String
        val conta = intent.extras.get("conta") as String

        tvContato = tv_nome_contato_transferencia_efetivacao_activity
        btConta = bt_conta_transferencia_efetivacao_activity
        etValor = et_valor_contato_transferencia_efetivacao_activity
        btConfirmar = bt_confirmar_transferencia_efetivacao_activity

        tvContato.text = contato

        btConta.text = conta

        btConfirmar.setOnClickListener {
            if (getValue()) {
                val intent: Intent = Intent(this, SucessoActivity::class.java)
                startActivity(intent)
            } else {
                val intent: Intent = Intent(this, ErroActivity::class.java)
                startActivity(intent)
            }
        }
        etValor.addTextChangedListener(
            MaskEditUtil.mask(
                etValor,
                MaskEditUtil.FORMAT_REAL
            )
        );
    }

    private fun getValue(): Boolean {
        var valor = MaskEditUtil.unmaskToDouble(etValor.text.toString()).toDouble()
        var valorPermitido = btConta.text.toString()
            .replace(getString(R.string.tranferencia_conta_corrente), "")
            .replace(getString(R.string.tranferencia_conta_poupanca), "")
            .replace("(", "")
            .replace(")", "")
        if (valor > valor.toDouble())
            return false
        return true
    }
}