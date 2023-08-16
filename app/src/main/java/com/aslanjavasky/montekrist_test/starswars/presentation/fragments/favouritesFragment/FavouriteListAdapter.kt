package com.aslanjavasky.montekrist_test.starswars.presentation.fragments.favouritesFragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aslanjavasky.montekrist_test.starswars.App
import com.aslanjavasky.montekrist_test.starswars.R
import com.aslanjavasky.montekrist_test.starswars.databinding.FavouriteItemBinding
import com.aslanjavasky.montekrist_test.starswars.databinding.PeopleItemBinding
import com.aslanjavasky.montekrist_test.starswars.domain.models.FavouriteItem
import com.aslanjavasky.montekrist_test.starswars.domain.models.PeopleItem

class FavouriteListAdapter : ListAdapter<FavouriteItem,
        FavouriteListAdapter.FavouriteListViewHolder>(callback) {


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): FavouriteListViewHolder {

        val binding =
            FavouriteItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return FavouriteListViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: FavouriteListViewHolder, position: Int
    ) {
        val favouriteItem = getItem(position)
        favouriteItem?.let { holder.bind(it) }
    }

    inner class FavouriteListViewHolder(
        val binding: FavouriteItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(favouriteItem: FavouriteItem) {
            binding.tvName.text = favouriteItem.name
            binding.tvField2.text = favouriteItem.field2
            binding.tvField3.text = favouriteItem.field3
            binding.tvType.text = favouriteItem.type
            binding.btnFavourite.addOnCheckedChangeListener { button, isChecked ->
                if (isChecked){
                    button.icon = App.INSTANCE.getDrawable(R.drawable.favorite_icon)
                } else {
                    button.icon = App.INSTANCE.getDrawable(R.drawable.not_favorite_icon)
                }
            }
        }
    }

    companion object {
        val callback = object : DiffUtil.ItemCallback<FavouriteItem>() {
            override fun areItemsTheSame(oldItem: FavouriteItem, newItem: FavouriteItem): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: FavouriteItem, newItem: FavouriteItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}