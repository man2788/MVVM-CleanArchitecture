package com.example.sphtest.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast
import com.example.sphtest.domain.Entity.Year


fun Context.hasNetwork(): Boolean {
    var isConnected: Boolean = false // Initial Value
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    if (activeNetwork != null && activeNetwork.isConnected)
        isConnected = true
    return isConnected
}

fun Context.showTaost(message: String) {
    val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
    toast.show()
}

fun Year.totalValue() = quarterList.sumByDouble { it.qValue }

fun Year.isDecreased(): Boolean {
    var lastValue = Double.MIN_VALUE
    quarterList.forEach {
        if (it.qValue < lastValue) {
            return true
        }
        lastValue = it.qValue
    }
    return false
}
