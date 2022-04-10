package com.vikas.groceryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vikas.groceryapp.data.Record
import com.vikas.groceryapp.databinding.LayoutGroceryItemsBinding

class GroceryListAdapter :
    PagingDataAdapter<Record, GroceryListAdapter.GroceryViewHolder>(GroceryDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        return GroceryViewHolder(
            LayoutGroceryItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        val photo = getItem(position)
        if (photo != null) {
            holder.bind(photo)
        }
    }

    class GroceryViewHolder(
        private val binding: LayoutGroceryItemsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Record) {
            binding.apply {
                grocery = item
                tvState.text = grocery?.state
                tvDistrict.text = grocery?.district
                tvMarket.text = grocery?.market
                tvCommodity.text = grocery?.commodity
                tvPrice.text = grocery?.max_price
                executePendingBindings()
            }
        }
    }
}

private class GroceryDiffCallBack : DiffUtil.ItemCallback<Record>() {

    override fun areItemsTheSame(
        oldItem: Record,
        newItem: Record
    ): Boolean {
        return oldItem.commodity == newItem.commodity
    }

    override fun areContentsTheSame(
        oldItem: Record,
        newItem: Record
    ): Boolean {
        return oldItem == newItem
    }
}
