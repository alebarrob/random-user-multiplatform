package alejandro.barrera.randomusermultiplatform.util

import alejandro.barrera.randomusermultiplatform.presentation.ExploreViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.jvm.JvmStatic

object KoinHelpers : KoinComponent {
    private val viewModel: ExploreViewModel by inject()

    @JvmStatic
    fun provideExploreViewModel(): ExploreViewModel = viewModel
}