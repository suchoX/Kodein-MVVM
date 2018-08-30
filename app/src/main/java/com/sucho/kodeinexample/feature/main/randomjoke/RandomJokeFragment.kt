package com.sucho.kodeinexample.feature.main.randomjoke

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.os.Bundle
import com.sucho.kodeinexample.R
import com.sucho.kodeinexample.databinding.RandomJokeFragmentBinding
import com.sucho.kodeinexample.feature.base.BaseDialogFragment

class RandomJokeFragment : BaseDialogFragment<RandomJokeFragmentBinding, RandomJokeViewModel>(), LifecycleOwner {
  override fun getViewModelClass(): Class<RandomJokeViewModel> = RandomJokeViewModel::class.java

  override fun layoutId(): Int = R.layout.fragment_random_joke

  companion object {
    private const val JOKE_INTENT = "JOKE_INTENT"

    fun newInstance(joke: String): RandomJokeFragment {
      val fragment = RandomJokeFragment()
      val args = Bundle()
      args.putString(JOKE_INTENT, joke)
      fragment.arguments = args
      return fragment
    }
  }

  override fun getLifecycle(): Lifecycle {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

}