package com.sucho.kodeinexample.feature.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.util.Log
import android.view.View
import com.sucho.kodeinexample.R
import com.sucho.kodeinexample.databinding.MainActivityBinding
import com.sucho.kodeinexample.feature.base.BaseActivity
import com.sucho.kodeinexample.feature.main.randomjoke.RandomJokeFragment
import timber.log.Timber

class MainActivity : BaseActivity<MainActivityBinding, MainViewModel>() {
  override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

  override fun layoutId(): Int = R.layout.activity_main

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    viewModel.dataLoading.observe(this, Observer { handleDataLoadingUi(it!!) })
    viewModel.joke.observe(this, Observer { showRandomJokeFragment(it!!) })

    binding.randomJokeButton.setOnClickListener {
      viewModel.fetchRandomJoke()
    }

  }


  private fun handleDataLoadingUi(loading: Boolean) {
    binding.progressbar.visibility = if (loading) View.VISIBLE else View.INVISIBLE
    binding.randomJokeButton.isEnabled = !loading
  }

  private fun showRandomJokeFragment(joke: String) {
    Timber.d(joke)
    /*val fragment = RandomJokeFragment.newInstance(joke)
    fragment.show(supportFragmentManager, "dialog")*/
  }
}
