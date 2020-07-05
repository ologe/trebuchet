package dev.olog.feature.detail.list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dev.olog.domain.entity.Pokemon
import dev.olog.navigation.Navigator
import javax.inject.Provider

internal class PokedexFragmentViewModel @ViewModelInject constructor(
    private val navigator: Navigator,
    private val pagingSource: Provider<PokemonPagingSource>
) : ViewModel() {

    companion object {
        private const val PAGE_SIZE = 20
    }

    val data = Pager(PagingConfig(PAGE_SIZE)) {
        pagingSource.get()
    }.flow.cachedIn(viewModelScope)

    fun navigateToDetail(pokemon: Pokemon) {
        navigator.toPokedexDetail(pokemon)
    }

}