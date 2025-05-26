package alejandro.barrera.randomusermultiplatform.data.api

import alejandro.barrera.randomusermultiplatform.data.dto.ResponseDto

interface RandomUserApi {
    suspend fun getRandomUsers(
        nationality: String = DEFAULT_NATIONALITY,
        results: Int = DEFAULT_RESULTS,
        seed: String = DEFAULT_SEED,
        page: Int = DEFAULT_PAGE
    ): ResponseDto

    companion object {
        const val DEFAULT_RESULTS = 20
        const val DEFAULT_NATIONALITY = "es"
        const val DEFAULT_SEED = "random"
        const val DEFAULT_PAGE = 1
    }
}