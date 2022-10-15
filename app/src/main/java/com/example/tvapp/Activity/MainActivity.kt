package com.example.tvapp.Activity

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.tvapp.Fragments.MainFragment
import com.example.tvapp.R

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_browse_fragment, MainFragment())
                .commitNow()
        }
    }
}