package alejandro.barrera.randomusermultiplatform.domain.repository

import alejandro.barrera.randomusermultiplatform.domain.model.User
import alejandro.barrera.randomusermultiplatform.domain.util.Result

interface UserRepository {
    suspend fun getRandomUsers(): Result<List<User>>
}