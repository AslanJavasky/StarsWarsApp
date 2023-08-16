package com.aslanjavasky.montekrist_test.starswars.presentation.fragments.peopleFragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aslanjavasky.montekrist_test.starswars.App
import com.aslanjavasky.montekrist_test.starswars.R
import com.aslanjavasky.montekrist_test.starswars.databinding.PeopleItemBinding
import com.aslanjavasky.montekrist_test.starswars.domain.models.PeopleItem
import javax.inject.Inject

class PeopleListAdapter @Inject constructor(
    private val viewModel: PeopleViewModel
) : PagingDataAdapter<PeopleItem,
        PeopleListAdapter.PeopleListViewHolder>(callback) {


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): PeopleListViewHolder {

        val binding =
            PeopleItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return PeopleListViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: PeopleListViewHolder, position: Int
    ) {
        val peopleItem = getItem(position)
        peopleItem?.let { holder.bind(it) }
    }

    inner class PeopleListViewHolder(
        val binding: PeopleItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(peopleItem: PeopleItem) {
            binding.tvName.text = peopleItem.name
            binding.tvGender.text = peopleItem.gender
            binding.tvBirthYear.text = peopleItem.birth_year
            binding.btnFavourite.addOnCheckedChangeListener { button, isChecked ->
                if (isChecked){
                    viewModel.saveItem(peopleItem)
                    button.icon = App.INSTANCE.getDrawable(R.drawable.favorite_icon)
                } else {
                    viewModel.removeItem(peopleItem)
                    button.icon = App.INSTANCE.getDrawable(R.drawable.not_favorite_icon)
                }
            }
        }
    }

    companion object {
        val callback = object : DiffUtil.ItemCallback<PeopleItem>() {
            override fun areItemsTheSame(oldItem: PeopleItem, newItem: PeopleItem): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: PeopleItem, newItem: PeopleItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}