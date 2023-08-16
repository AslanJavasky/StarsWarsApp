package com.aslanjavasky.montekrist_test.starswars.presentation.fragments.favouritesFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import com.aslanjavasky.montekrist_test.starswars.R
import com.aslanjavasky.montekrist_test.starswars.databinding.FragmentFavouritesBinding
import com.aslanjavasky.montekrist_test.starswars.databinding.FragmentPeopleBinding
import com.aslanjavasky.montekrist_test.starswars.presentation.fragments.peopleFragment.PeopleListAdapter
import com.aslanjavasky.montekrist_test.starswars.presentation.fragments.peopleFragment.PeopleViewModel
import com.aslanjavasky.montekrist_test.starswars.presentation.fragments.peopleFragment.PeopleViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FavouritesFragment : Fragment() {

    @Inject
    lateinit var VMFactory: FavouriteViewModelFactory

    private val viewModel: FavouritesViewModel by viewModels {
        VMFactory
    }

    private var _binding: FragmentFavouritesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvAdapter = FavouriteListAdapter()
        binding.rvFavourites.adapter = rvAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.items.collect {
                    rvAdapter.submitList(it)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}