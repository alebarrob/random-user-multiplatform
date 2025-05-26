package alejandro.barrera.randomusermultiplatform.presentation.di

import alejandro.barrera.randomusermultiplatform.presentation.ExploreViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val viewModelModule = module {
    factoryOf(::ExploreViewModel)
}