package com.aslanjavasky.montekrist_test.starswars.presentation.fragments.shipFragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aslanjavasky.montekrist_test.starswars.App
import com.aslanjavasky.montekrist_test.starswars.R
import com.aslanjavasky.montekrist_test.starswars.databinding.ShipItemBinding
import com.aslanjavasky.montekrist_test.starswars.domain.models.ShipItem
import javax.inject.Inject

class ShipListAdapter @Inject constructor(
    private val viewModel:ShipViewModel
) : PagingDataAdapter<ShipItem,
        ShipListAdapter.ShipListViewHolder>(callback) {


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ShipListViewHolder {

        val binding =
            ShipItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return ShipListViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: ShipListViewHolder, position: Int
    ) {
        val shipItem = getItem(position)
        shipItem?.let { holder.bind(it) }
    }

    inner class ShipListViewHolder(
        val binding: ShipItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(shipItem: ShipItem) {
            binding.tvName.text = shipItem.name
            binding.tvModel.text = "Model is ${shipItem.model}"
            binding.tvLengh.text = "Lengh is ${shipItem.length}"
            binding.btnFavourite.addOnCheckedChangeListener { button, isChecked ->
                if (isChecked){
                    viewModel.saveItem(shipItem)
                    button.icon = App.INSTANCE.getDrawable(R.drawable.favorite_icon)
                } else {
                    viewModel.removeItem(shipItem)
                    button.icon = App.INSTANCE.getDrawable(R.drawable.not_favorite_icon)
                }
            }
        }
    }

    companion object {
        val callback = object : DiffUtil.ItemCallback<ShipItem>() {
            override fun areItemsTheSame(oldItem: ShipItem, newItem: ShipItem): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: ShipItem, newItem: ShipItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}