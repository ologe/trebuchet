package dev.olog.feature.main

import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
internal class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postponeEnterTransition()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.doOnPreDraw {
            startPostponedEnterTransition()
        }

        menu.setOnClickListener {
            val popup = PopupMenu(requireContext(), it)
            popup.inflate(R.menu.overflow)
            popup.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.settings -> viewModel.navigateToSettings(requireActivity())
                    R.id.logout -> viewModel.logout(requireActivity())
                }
                false // should be true but the emulator don't dismiss the popup
            }
            popup.show()
        }

        val adapter = MainFragmentAdapter { repo, v ->
            viewModel.navigateToDetail(requireActivity(), repo, v)
        }
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(requireContext())

        viewModel.observeRepositories()
            .onEach {
                adapter.submitList(it)
            }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

}