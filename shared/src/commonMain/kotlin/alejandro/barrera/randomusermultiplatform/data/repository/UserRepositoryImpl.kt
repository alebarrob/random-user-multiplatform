package alejandro.barrera.randomusermultiplatform.data.repository

import alejandro.barrera.randomusermultiplatform.data.api.RandomUserApi
import alejandro.barrera.randomusermultiplatform.data.di.DispatchersProvider
import alejandro.barrera.randomusermultiplatform.data.mapper.toUser
import alejandro.barrera.randomusermultiplatform.domain.repository.UserRepository
import alejandro.barrera.randomusermultiplatform.domain.util.Result
import kotlinx.coroutines.withContext

class UserRepositoryImpl(
    private val api: RandomUserApi,
    private val dispatchers: DispatchersProvider
) : UserRepository {

    override suspend fun getRandomUsers() = withContext(dispatchers.io) {
        Result.from {
            api.getRandomUsers().results.map { result ->
                result.toUser()
            }
        }
    }
}