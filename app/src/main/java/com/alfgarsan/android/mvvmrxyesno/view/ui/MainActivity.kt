package com.alfgarsan.android.mvvmrxyesno.view.ui

import android.os.Bundle
import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity
import com.alfgarsan.android.mvvmrxyesno.R
import com.alfgarsan.android.mvvmrxyesno.viewmodel.AnswerViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.container,
                        AnswerFragment.newInstance()
                    )
                    .commitNow()
        }
    }
}
