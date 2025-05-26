package alejandro.barrera.randomusermultiplatform

import alejandro.barrera.randomusermultiplatform.data.di.apiModule
import alejandro.barrera.randomusermultiplatform.data.di.dispatchersModule
import alejandro.barrera.randomusermultiplatform.data.di.networkModule
import alejandro.barrera.randomusermultiplatform.data.di.repositoryModule
import alejandro.barrera.randomusermultiplatform.domain.di.useCaseModule
import alejandro.barrera.randomusermultiplatform.presentation.di.viewModelModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(configuration: KoinAppDeclaration? = null) = startKoin {
    configuration?.invoke(this)
    modules(
        repositoryModule,
        useCaseModule,
        networkModule,
        dispatchersModule,
        viewModelModule,
        apiModule,
        platformModule()
    )
}