package com.vicolmoraes.itauchallenge

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import kotlinx.android.synthetic.main.landing_page_activity.*

class LandingPageActivity : AppCompatActivity() {

    lateinit var cardTransferencia: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing_page_activity)

        findViews()
    }

    private fun findViews() {
        cardTransferencia = cv_transferencia_landing_page_activity
        cardTransferencia.setOnClickListener {
            val intent: Intent = Intent(this, TransferenciaActivity::class.java)
            startActivity(intent)
        }
    }
}