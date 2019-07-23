package com.vicolmoraes.itauchallenge

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.tranferencia_activity.*

class TransferenciaActivity : AppCompatActivity() {

    lateinit var rvContatos: RecyclerView
    lateinit var btContaCorrente: Button
    lateinit var btContaPoupanca: Button
    lateinit var tvPara: TextView
    var conta: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tranferencia_activity)

        findViews()
    }

    private fun findViews() {
        btContaCorrente = bt_conta_corrente_transferencia_activity
        btContaPoupanca = bt_poupanca_transferencia_activity
        rvContatos = rv_contatos_transferencia_activity
        tvPara = tv_para_transferencia_activity

        btContaCorrente.setOnClickListener {
            btContaCorrente.isEnabled = false
            btContaPoupanca.isEnabled = true
            tvPara.visibility = VISIBLE
            rvContatos.visibility = VISIBLE
            setRecycler()
            conta = 0
        }

        btContaPoupanca.setOnClickListener {
            btContaCorrente.isEnabled = true
            btContaPoupanca.isEnabled = false
            tvPara.visibility = VISIBLE
            rvContatos.visibility = VISIBLE
            setRecycler()
            conta = 1
        }
    }

    private fun setRecycler() {
        var lista: ArrayList<String> = ArrayList()
        lista.add("joao")
        lista.add("marcia")

        rvContatos.adapter = ContatosAdapter(lista, this, { partItem: String -> partItemClicked(partItem) })
    }

    private fun partItemClicked(contato: String) {
        val intent: Intent = Intent(this, TransferenciaEfetivacaoActivity::class.java)
        intent.putExtra("contato", contato)
        startActivity(intent)
    }
}