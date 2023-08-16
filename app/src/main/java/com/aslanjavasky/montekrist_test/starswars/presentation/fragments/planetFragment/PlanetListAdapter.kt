package com.aslanjavasky.montekrist_test.starswars.presentation.fragments.planetFragment

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
import com.aslanjavasky.montekrist_test.starswars.databinding.PlanetItemBinding
import com.aslanjavasky.montekrist_test.starswars.domain.models.PeopleItem
import com.aslanjavasky.montekrist_test.starswars.domain.models.PlanetItem
import javax.inject.Inject

class PlanetListAdapter @Inject constructor(
    private val viewModel: PlanetsViewModel
) : PagingDataAdapter<PlanetItem,
        PlanetListAdapter.PlanetListViewHolder>(callback) {


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): PlanetListViewHolder {

        val binding =
            PlanetItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return PlanetListViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: PlanetListViewHolder, position: Int
    ) {
        val planetItem = getItem(position)
        planetItem?.let { holder.bind(it) }
    }

    inner class PlanetListViewHolder(
        val binding: PlanetItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(planetItem: PlanetItem) {
            binding.tvName.text = planetItem.name
            binding.tvDiameter.text = "Diameter is ${planetItem.diameter}"
            binding.tvPopulation.text = "Population:${planetItem.population}"
            binding.btnFavourite.addOnCheckedChangeListener { button, isChecked ->
                if (isChecked){
                    viewModel.saveItem(planetItem)
                    button.icon = App.INSTANCE.getDrawable(R.drawable.favorite_icon)
                } else {
                    viewModel.saveItem(planetItem)
                    button.icon = App.INSTANCE.getDrawable(R.drawable.not_favorite_icon)
                }
            }
        }
    }

    companion object {
        val callback = object : DiffUtil.ItemCallback<PlanetItem>() {
            override fun areItemsTheSame(oldItem: PlanetItem, newItem: PlanetItem): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: PlanetItem, newItem: PlanetItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}