package alejandro.barrera.randomusermultiplatform.data.api

import alejandro.barrera.randomusermultiplatform.data.dto.ResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path

class KtorRandomUserApi(
    private val client: HttpClient
) : RandomUserApi {

    override suspend fun getRandomUsers(
        nationality: String,
        results: Int,
        seed: String,
        page: Int
    ): ResponseDto = client.get {
        url {
            protocol = URLProtocol.HTTPS
            host = "randomuser.me"
            path("api/")
            parameters.apply {
                append("nat", nationality)
                append("results", results.toString())
                append("seed", seed)
                append("page", page.toString())
            }
        }
    }.body()
}