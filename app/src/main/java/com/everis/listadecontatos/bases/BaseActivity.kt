package com.everis.listadecontatos.bases

import android.view.MenuItem
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.everis.listadecontatos.R

open class BaseActivity : AppCompatActivity() {
    protected fun steupToolBar (toolbar: Toolbar, title: String, navgationBack: Boolean, toolBar: Any) {
        toolBar.title = title
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(navgationBack)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                this.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}