package com.example.sphtest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sphtest.R
import com.example.sphtest.adapter.DataUsageListAdapter
import com.example.sphtest.adapter.GridItemDecoration
import com.example.sphtest.extensions.hasNetwork
import com.example.sphtest.extensions.showTost
import com.example.sphtest.viewmodel.DataUsageViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DataUsageListActivity : AppCompatActivity() {

    private val dataUsageViewModel: DataUsageViewModel by viewModel()
    private var isLoading: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkNetworkExists()
        initProgressbar()
        prepareRecyclerView()
    }

    private fun checkNetworkExists() {
        if (!this.hasNetwork()) {
            this.showTost(getString(R.string.internet_connection))
        }
    }

    private fun initProgressbar() {
        dataUsageViewModel.isLoadingLiveData.observe(this, Observer {
            isLoading = it
            if (isLoading) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }
        })
    }

    private fun prepareRecyclerView() {
        recyclerView_dataList.layoutManager = GridLayoutManager(this, 2)
        recyclerView_dataList.addItemDecoration(GridItemDecoration(10, 2))
        val dataUsageAdapter = DataUsageListAdapter()
        recyclerView_dataList.adapter = dataUsageAdapter
        recyclerView_dataList.setHasFixedSize(true)
        dataUsageViewModel.dataUsageListLiveData.observe(this, Observer {
            if (!it.isNullOrEmpty())
                dataUsageAdapter.updateAdapter(it)
        })
    }
}
