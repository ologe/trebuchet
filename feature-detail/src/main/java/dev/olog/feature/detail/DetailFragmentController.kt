package dev.olog.feature.detail

import dev.olog.domain.interactor.ObserveRepositoryByIdUseCase
import javax.inject.Inject

internal class DetailFragmentController @Inject constructor(
    private val observeRepositoryByIdUseCase: ObserveRepositoryByIdUseCase
)