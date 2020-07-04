package dev.olog.feature.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dev.olog.domain.interactor.ObserveRepositoryByIdUseCase

internal class DetailFragmentViewModel @ViewModelInject constructor(
    private val observeRepositoryByIdUseCase: ObserveRepositoryByIdUseCase
) : ViewModel()