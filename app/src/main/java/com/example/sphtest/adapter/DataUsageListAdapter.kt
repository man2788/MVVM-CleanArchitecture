package com.example.sphtest.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sphtest.R
import com.example.sphtest.domain.Entity.DataUsageEntity
import kotlinx.android.synthetic.main.item_flip_back.view.*
import kotlinx.android.synthetic.main.item_flip_front.view.*
import kotlinx.android.synthetic.main.list_item.view.*
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.BarData
import com.wajahatkarim3.easyflipview.EasyFlipView

class DataUsageListAdapter(
    private var dataUsageItem: MutableList<DataUsageEntity>,
    private val context: Context
) : RecyclerView.Adapter<DataUsageListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataUsageItem!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(dataUsageItem!![position], position)

    fun updateAdapter(listItems: MutableList<DataUsageEntity>) {
        dataUsageItem = listItems.sortedBy { it.year } as MutableList<DataUsageEntity>
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: DataUsageEntity, position: Int) {
            if (itemView != null) {
                with(itemView) {
                    textView_year.text = item.year.toString()
                    textView_totalDataUsage.text = item.totalAmountOfDataUsagePerYear.toString()
                    flipView.setOnClickListener {
                        if (item.isFlipped!!) {
                            item.isFlipped = false
                        } else {
                            item.isFlipped = false
                        }
                        flipView.flipDuration = 700
                        flipView.flipTheView()
                    }
                    val barGroup = ArrayList<BarEntry>()
                    val labels = ArrayList<String>()
                    item.quarter.forEachIndexed { index, value ->
                        barGroup.add(BarEntry(value.toFloat(), index))
                        labels.add("Q".plus(index + 1))
                    }
                    val barDataSet = BarDataSet(barGroup, "DataUsagePerQuarter")
                    val data = BarData(labels, barDataSet)
                    barChart.setDescription("")
                    flipView.setOnFlipListener { easyFlipView, newCurrentSide ->
                        if (newCurrentSide == EasyFlipView.FlipState.BACK_SIDE) {
                            barChart.data = data
                            barChart.animateY(1500)

                        }
                    }


                }

            }
        }
    }


}