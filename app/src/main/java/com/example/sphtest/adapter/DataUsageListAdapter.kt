package com.example.sphtest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sphtest.R
import com.example.sphtest.domain.Entity.Year
import com.example.sphtest.extensions.isDecreased
import com.example.sphtest.extensions.totalValue
import kotlinx.android.synthetic.main.item_flip_back.view.*
import kotlinx.android.synthetic.main.item_flip_front.view.*
import kotlinx.android.synthetic.main.list_item.view.*
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.BarData
import com.wajahatkarim3.easyflipview.EasyFlipView

class DataUsageListAdapter(
    private var dataUsageItem: List<Year> = listOf()
) : RecyclerView.Adapter<DataUsageListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataUsageItem.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(dataUsageItem[position])

    fun updateAdapter(listItems: List<Year>) {
        dataUsageItem = listItems
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Year) {
            with(itemView) {
                textView_year.text = item.yName
                textView_totalDataUsage.text = item.totalValue().toString()
                if (item.isDecreased()) {
                    info_image.visibility = View.VISIBLE
                    flipView.setOnClickListener {
                        if (item.isFlipped) {
                            item.isFlipped = false
                        } else {
                            item.isFlipped = false
                        }
                        flipView.flipDuration = 700
                        flipView.flipTheView()
                    }
                } else {
                    info_image.visibility = View.GONE
                }

                val barGroup = ArrayList<BarEntry>()
                val labels = ArrayList<String>()
                item.quarterList.forEachIndexed { index, value ->
                    barGroup.add(BarEntry(value.qValue.toFloat(), index))
                    labels.add(value.qName)
                }
                val barDataSet = BarDataSet(barGroup, "DataUsagePerQuarter")
                val data = BarData(labels, barDataSet)
                barChart.setDescription("")
                flipView.setOnFlipListener { easyFlipView, newCurrentSide ->
                    if (newCurrentSide == EasyFlipView.FlipState.BACK_SIDE) {
                        barChart.data = data
                        barChart.animateY(1400)
                    }
                }
            }
        }
    }


}