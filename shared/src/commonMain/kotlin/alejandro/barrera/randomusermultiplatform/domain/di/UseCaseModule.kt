package alejandro.barrera.randomusermultiplatform.domain.di

import alejandro.barrera.randomusermultiplatform.domain.use_case.GetRandomUsers
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::GetRandomUsers)
}