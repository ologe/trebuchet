package dev.olog.feature.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.olog.feature.main.R
import dev.olog.shared.android.lazyFast
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeFragmentViewModel by viewModels()

    private val adapter by lazyFast {
        HomeFragmentAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(requireContext())

        adapter.submitList(viewModel.data)
    }

}

