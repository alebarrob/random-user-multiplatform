package alejandro.barrera.randomusermultiplatform.data.di

import alejandro.barrera.randomusermultiplatform.data.repository.UserRepositoryImpl
import alejandro.barrera.randomusermultiplatform.domain.repository.UserRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
}