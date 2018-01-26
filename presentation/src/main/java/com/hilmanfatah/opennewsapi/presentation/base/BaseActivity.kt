package com.hilmanfatah.opennewsapi.presentation.base

import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity


abstract class BaseActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getResourceLayout())
        onViewReady(savedInstanceState)
    }

    protected abstract fun getResourceLayout(): Int

    protected abstract fun onViewReady(savedInstanceState: Bundle?)


}