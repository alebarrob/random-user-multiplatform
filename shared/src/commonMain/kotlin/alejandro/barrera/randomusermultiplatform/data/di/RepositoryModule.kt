package alejandro.barrera.randomusermultiplatform.data.di

import alejandro.barrera.randomusermultiplatform.data.repository.UserRepositoryImpl
import alejandro.barrera.randomusermultiplatform.domain.repository.UserRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val repositoryModule = module {
    factoryOf(::UserRepositoryImpl) { bind<UserRepository>() }
}