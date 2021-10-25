package com.smartdev.samplerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartdev.samplerecyclerview.Constant.getDummyData
import com.smartdev.samplerecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding


    var mAdapter = SampleAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        binding?.rvData!!.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(true)
            adapter = mAdapter
        }

        mAdapter?.apply {

            arrData = getDummyData()  //passing data to adapter
            onItemClickListener = { model, view ->

                when (view.id!!) {
                    R.id.btnView -> {
                        showMessage("Click name is ${model.name}")
                    }
                    else -> {
                        showMessage("item is click")
                    }
                }

            }

        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}