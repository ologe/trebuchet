package dev.olog.feature.main.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

internal class HomeFragmentViewModel @ViewModelInject constructor(

) : ViewModel() {

    val data: List<HomeFragmentModel> = listOf(
        HomeFragmentModel.Search
    )

}