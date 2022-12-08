package com.smartdev.samplerecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import com.smartdev.samplerecyclerview.databinding.ItemDataBinding

class SampleAdapter : RecyclerView.Adapter<SampleAdapter.DataViewHolder>() {


    var arrData = mutableListOf<DataModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    lateinit var onItemClickListener: (DataModel, View) -> Unit
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SampleAdapter.DataViewHolder {
        return DataViewHolder(
            ItemDataBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        var model = arrData.get(position);

        with(holder.binding)
        {
            txxName.setText(model.name)
            txxEmail.setText(model.email)

            bindClickEvent(root,model)
            bindClickEvent(btnView,model)
        }

    }


    fun bindClickEvent(view: View, model: DataModel) {
        view.setOnClickListener {

            onItemClickListener(model, it)
        }
    }


    override fun getItemCount(): Int {
        return arrData.size
    }

    inner class DataViewHolder(var binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root)


}