package com.example.sphtest.domain.pojo


data class Quarter(val qName: String, val qValue: Double, val id: Int)

data class Year(val quarterList: List<Quarter>, val yName: String, var isFlipped : Boolean = false)

