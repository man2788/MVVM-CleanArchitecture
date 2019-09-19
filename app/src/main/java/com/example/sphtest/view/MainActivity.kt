package com.example.sphtest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sphtest.R
import com.example.sphtest.adapter.DataUsageListAdapter
import com.example.sphtest.adapter.GridItemDecoration
import com.example.sphtest.domain.Entity.DataUsageEntity
import com.example.sphtest.extensions.hasNetwork
import com.example.sphtest.extensions.showTaost
import com.example.sphtest.viewmodel.DataUsageViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val dataUsageViewModel: DataUsageViewModel by viewModel()
    private var isLoading: Boolean? = false
    var data = mutableListOf<DataUsageEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(this.hasNetwork()){
            this.showTaost(getString(R.string.internet_connection))
        }
        dataUsageViewModel.isLoadingLiveData.observe(this, Observer {
            isLoading = it
        })
        prepareRecyclerView()
    }

    private fun prepareRecyclerView() {
        recyclerView_dataList.layoutManager = GridLayoutManager(this, 2)
        recyclerView_dataList.addItemDecoration(GridItemDecoration(10, 2))
        val dataUsageAdapter = DataUsageListAdapter(data, this)
        recyclerView_dataList.adapter = dataUsageAdapter
        recyclerView_dataList.setHasFixedSize(true)
        dataUsageViewModel.datausageList.observe(this, Observer {
            if(!it.isNullOrEmpty())
            dataUsageAdapter.updateAdapter(it)
        })
    }
}