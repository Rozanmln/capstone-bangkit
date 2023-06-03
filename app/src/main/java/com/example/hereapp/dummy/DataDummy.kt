package com.example.hereapp.dummy

import android.icu.text.AlphabeticIndex.Record
import com.example.hereapp.data.model.DataArticle
import com.example.hereapp.data.model.DataFeature
import com.example.hereapp.data.model.RecordHospital

object DataDummy {

    fun generateRecordHospitalDummy(): List<RecordHospital> {
        val list = ArrayList<RecordHospital>()

        for(i in 0..10) {
            list.add(
                RecordHospital(
                    "19 May 2023",
                    "Albarra Zikrillah",
                    "12345678910111213"
                )
            )
        }
        return list
    }
    fun generateMainImage(): List<String> {
        val list = ArrayList<String>()

        for(i in 0..10) {
            list.add("https://images.pexels.com/photos/5878511/pexels-photo-5878511.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
        }
        return list
    }

    fun generateFeatureData(): ArrayList<DataFeature> {
        val list = ArrayList<DataFeature>()

        for(i in 0..3) {
            val data = DataFeature (
                "https://cdn-icons-png.flaticon.com/512/809/809957.png",
                "Feature name")
            list.add(data)
        }
        return list
    }

    fun generateArticleData(): ArrayList<DataArticle> {
        val list = ArrayList<DataArticle>()

        for (i in 0..10) {
            val data = DataArticle(
                "https://cdn-icons-png.flaticon.com/512/809/809957.png",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
            )
            list.add(data)
        }
        return list
    }
}