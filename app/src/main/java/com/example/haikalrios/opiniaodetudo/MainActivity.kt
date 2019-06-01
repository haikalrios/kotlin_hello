package com.example.haikalrios.opiniaodetudo


import android.content.Context

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment

import android.view.inputmethod.InputMethodManager



class MainActivity : AppCompatActivity() {

    private val fragments = mapOf(FORM_FRAGMENT to ::FormFragment, LIST_FRAGMENT to ::ListFragment)
    companion object {
        val FORM_FRAGMENT = "formFragment"
        val LIST_FRAGMENT = "listFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateTo(FORM_FRAGMENT)
        configureBottomMenu()

       /* supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FormFragment())
                .commit()
*/
        configureAutoHiddenKeyboard()

    }

    private fun configureBottomMenu() {
        val bottomNavigationMenu = findViewById<BottomNavigationView>(R.id.bottom_main_menu)
        bottomNavigationMenu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuitem_newitem -> navigateTo(FORM_FRAGMENT)
                R.id.menuitem_listitem -> navigateTo(LIST_FRAGMENT)
            }
            true
        }
    }

    fun navigateTo(item: String) {
        val fragmentInstance: Fragment = fragments[item]?.invoke()!!
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragmentInstance)
                .addToBackStack(item)
                .commit()
    }

    private fun configureAutoHiddenKeyboard() {

        val mainContainer = findViewById<ConstraintLayout>(R.id.main_container)
        mainContainer.setOnTouchListener { v, event ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
    }







}
