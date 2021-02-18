package com.example.diffutilrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilrecyclerview.databinding.ItemRowFilterBinding

class FoodAdapter : ListAdapter<Food,FoodAdapter.FoodVH>(FoodCallback()) {

    class FoodCallback : DiffUtil.ItemCallback<Food>(){
        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem == newItem
        }

    }
    inner class FoodVH(val binding : ItemRowFilterBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Food){
            binding.food = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodVH {
        val view = ItemRowFilterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FoodVH(view)
    }

    override fun onBindViewHolder(holder: FoodVH, position: Int) {
        holder.bind(getItem(position))
    }
}