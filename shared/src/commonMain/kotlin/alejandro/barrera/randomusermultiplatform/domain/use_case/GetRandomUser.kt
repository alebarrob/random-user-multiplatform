package alejandro.barrera.randomusermultiplatform.domain.use_case

import alejandro.barrera.randomusermultiplatform.domain.repository.UserRepository

class GetRandomUsers(
    private val userRepository: UserRepository
) {
    suspend fun invoke() = userRepository.getRandomUsers()
}