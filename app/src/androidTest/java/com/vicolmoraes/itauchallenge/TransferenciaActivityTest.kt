package com.vicolmoraes.itauchallenge

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.vicolmoraes.itauchallenge.transferencia.TransferenciaActivity
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class TransferenciaActivityTest {

    @Rule
    @JvmField
    val rule = IntentsTestRule(TransferenciaActivity::class.java)

    @Test
    fun checkContaPoupanca() {

        Thread.sleep(2000)
        assertEquals("Conta Poupança(5000.5)", rule.activity.btContaPoupanca.text.toString())

    }

    @Test
    fun checkContaCorrente() {

        Thread.sleep(2000)
        assertEquals("Conta Corrente(1000.0)", rule.activity.btContaCorrente.text.toString())

    }

    @Test
    fun clickContaCorrente() {

        Thread.sleep(2000)
        rule.activity.btContaCorrente.performClick()
        Thread.sleep(2000)
        Espresso.onView(ViewMatchers.withId(R.id.rv_contatos_transferencia_activity))
            .check(ViewAssertions.matches(ViewMatchers.hasChildCount(9)))

        onView(withId(R.id.rv_contatos_transferencia_activity)).perform(
            actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        );
    }
}
