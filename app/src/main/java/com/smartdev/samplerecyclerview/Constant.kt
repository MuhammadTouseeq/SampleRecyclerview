package com.smartdev.samplerecyclerview

object Constant {

    fun getDummyData(): MutableList<DataModel> {
        var arrData = mutableListOf<DataModel>();
        for (i in 0..8) {
            arrData.add(DataModel("Touseeq", "developertouseeq@gmail.com"));
        }
        return arrData
    }

}