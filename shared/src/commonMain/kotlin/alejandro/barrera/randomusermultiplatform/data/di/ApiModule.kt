package alejandro.barrera.randomusermultiplatform.data.di

import alejandro.barrera.randomusermultiplatform.data.api.KtorRandomUserApi
import alejandro.barrera.randomusermultiplatform.data.api.RandomUserApi
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val apiModule = module {
    singleOf(::KtorRandomUserApi) { bind<RandomUserApi>() }
}