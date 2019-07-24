package com.vicolmoraes.itauchallenge.transferencia

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import com.vicolmoraes.itauchallenge.R
import com.vicolmoraes.itauchallenge.model.Usuario
import com.vicolmoraes.itauchallenge.transferenciaEfetivacao.TransferenciaEfetivacaoActivity
import kotlinx.android.synthetic.main.tranferencia_activity.*

class TransferenciaActivity : AppCompatActivity() {

    lateinit var interactor: TransferenciaInteractor
    lateinit var usuario: Usuario
    lateinit var rvContatos: RecyclerView
    lateinit var btContaCorrente: Button
    lateinit var btContaPoupanca: Button
    lateinit var tvPara: TextView
    var conta: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tranferencia_activity)

        TransferenciaConfigurator.INSTANCE.setCleanArchitecture(this)

        findViews()
    }

    private fun findViews() {
        btContaCorrente = bt_conta_corrente_transferencia_activity
        btContaPoupanca = bt_poupanca_transferencia_activity
        rvContatos = rv_contatos_transferencia_activity
        tvPara = tv_para_transferencia_activity
        interactor.fetch()

        btContaCorrente.setOnClickListener {
            btContaCorrente.isEnabled = false
            btContaPoupanca.isEnabled = true
            tvPara.visibility = VISIBLE
            rvContatos.visibility = VISIBLE
            conta = 0
        }

        btContaPoupanca.setOnClickListener {
            btContaCorrente.isEnabled = true
            btContaPoupanca.isEnabled = false
            tvPara.visibility = VISIBLE
            rvContatos.visibility = VISIBLE
            conta = 1
        }
    }

    fun setValores(usuario: Usuario) {
        this.usuario = usuario
        btContaCorrente.text =
            getString(R.string.tranferencia_conta_corrente) + "(" + usuario.conta_corrente.toString() + ")"
        btContaPoupanca.text =
            getString(R.string.tranferencia_conta_poupanca) + "(" + usuario.conta_poupanca.toString() + ")"
    }

    fun setRecycler(lista: ArrayList<String>) {
        rvContatos.adapter = ContatosAdapter(
            lista,
            this,
            { partItem: String -> partItemClicked(partItem) })
    }

    private fun partItemClicked(contato: String) {
        val intent: Intent = Intent(this, TransferenciaEfetivacaoActivity::class.java)
        if (conta == 0)
            intent.putExtra("conta", btContaCorrente.text)
        else
            intent.putExtra("conta", btContaPoupanca.text)

        intent.putExtra("contato", contato)
        startActivity(intent)
    }
}