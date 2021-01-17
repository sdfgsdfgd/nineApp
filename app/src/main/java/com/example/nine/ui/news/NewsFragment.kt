package com.example.nine.ui.news

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.nine.databinding.FragmentNewsBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * News grid/recyclerview [Fragment] subclass as the default destination in the navigation.
 */
open class NewsFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentNewsBinding

    private val viewModel: NewsViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)

        if (activity?.resources?.configuration?.orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding.newsList.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            viewModel.setPortraitOrientation(true)

            PagerSnapHelper().attachToRecyclerView(binding.newsList)
        } else {
            binding.newsList.layoutManager = GridLayoutManager(requireContext(), 2)

            viewModel.setPortraitOrientation(false)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.navigateToWebview.observe(viewLifecycleOwner) { url ->
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    }
}