package dev.olog.feature.main

import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.core.view.doOnPreDraw
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

internal class MainFragment : DaggerFragment(R.layout.fragment_main) {

    @Inject
    lateinit var controller: MainFragmentController

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
                    R.id.settings -> with(controller) { navigateToSettings() }
                    R.id.logout -> with(controller) { logout() }
                }

                false // should be true but the emulator don't dismiss the popup

            }
            popup.show()
        }

        val adapter = MainFragmentAdapter { repo, v ->
            with(controller) { navigateToDetail(repo, v) }
        }
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(requireContext())

        controller.observeRepositories()
            .onEach {
                adapter.submitList(it)
            }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

}