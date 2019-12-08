package com.sample.mvvm.ui.main_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.mvvm.BR
import com.sample.mvvm.R
import com.sample.mvvm.base.BaseActivity
import com.sample.mvvm.databinding.ActivityMainBinding
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),

    HasSupportFragmentInjector {


    private lateinit var binding: ActivityMainBinding
    @Inject
    internal lateinit var viewModel: MainViewModel
    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var artistAdapter: ArtistAdapter
    @Inject
    lateinit var mLayoutManager: LinearLayoutManager

    override fun getBindingVariable(): Int = BR.viewModel


    override fun getLayoutId(): Int = R.layout.activity_main


    override fun getViewModel(): MainViewModel {

        return viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = mViewDataBinding
        setUp()

    }

    private fun setUp() {
        binding.artistRecyclerView.layoutManager = mLayoutManager
        binding.artistRecyclerView.itemAnimator = DefaultItemAnimator()
        binding.artistRecyclerView.adapter = artistAdapter

    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }


}
