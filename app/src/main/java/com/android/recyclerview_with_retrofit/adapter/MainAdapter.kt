package com.android.recyclerview_with_retrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.android.recyclerview_with_retrofit.databinding.ItemViewBinding
import com.android.recyclerview_with_retrofit.model.Data


class MainAdapter(private val mList: List<Data>) : RecyclerView.Adapter<MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}

class MainViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Data) {
        if (data.images.isNotEmpty()) {
            binding.image.load(data.images[0].src) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
        } else {
            binding.image.load("")
        }
        binding.title.text = data.name
        binding.address.text = data.address

        itemView.setOnClickListener {
            Toast.makeText(itemView.context, data.name, Toast.LENGTH_SHORT).show()
        }
    }
}