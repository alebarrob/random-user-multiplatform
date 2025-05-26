package alejandro.barrera.randomusermultiplatform.data.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module
import org.koin.dsl.module

class IosDispatchersProvider : DispatchersProvider {
    override val io: CoroutineDispatcher = Dispatchers.Default
    override val default: CoroutineDispatcher = Dispatchers.Default
}

actual val dispatchersModule: Module = module {
    single<DispatchersProvider> { IosDispatchersProvider() }
}