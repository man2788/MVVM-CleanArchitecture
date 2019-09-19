package com.example.sphtest.domain.Entity

class DataUsageEntity(var year: Int,
                      var quarter : List<Double>,
                      var totalAmountOfDataUsagePerYear : Double,
                      var isDecreasingFromPreviousQuarter : Boolean,
                      var isFlipped:Boolean?=false)




