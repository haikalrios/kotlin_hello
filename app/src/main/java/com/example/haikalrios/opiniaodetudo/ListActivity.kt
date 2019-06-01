package com.example.haikalrios.opiniaodetudo



import android.support.v7.app.AppCompatActivity
import android.os.Bundle


class ListActivity : AppCompatActivity() {

    //private lateinit var reviews : MutableList<Review>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.list_review_activity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, ListFragment())
                .commit()
    }


 /*   override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
*/





}
