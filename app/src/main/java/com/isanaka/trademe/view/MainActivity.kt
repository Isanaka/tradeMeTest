package com.isanaka.trademe.view

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.isanaka.trademe.R
import com.isanaka.trademe.base.BaseActivity
import com.isanaka.trademe.base.BaseInteractions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), BaseInteractions {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar()
    }

    override fun onSupportNavigateUp() = NavHostFragment.findNavController(nav_host_fragment).navigateUp()

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        toolbar.setupWithNavController(NavHostFragment.findNavController(nav_host_fragment))
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }
}
