package alejandro.barrera.randomusermultiplatform.data.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module
import org.koin.dsl.module

class AndroidDispatchersProvider : DispatchersProvider {
    override val io: CoroutineDispatcher = Dispatchers.IO
    override val default: CoroutineDispatcher = Dispatchers.Default
}

actual val dispatchersModule: Module = module {
    single<DispatchersProvider> { AndroidDispatchersProvider() }
}