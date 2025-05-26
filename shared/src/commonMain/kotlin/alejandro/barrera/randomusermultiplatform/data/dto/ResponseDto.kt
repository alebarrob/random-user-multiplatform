package alejandro.barrera.randomusermultiplatform.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDto(
    @SerialName("results") val results: List<ResultDto> = emptyList()
) {
    @Serializable
    data class ResultDto(
        @SerialName("name") val name: NameDto? = null,
        @SerialName("email") val email: String? = null,
        @SerialName("cell") val cell: String? = null,
        @SerialName("picture") val picture: PictureDto? = null
    )

    @Serializable
    data class NameDto(
        @SerialName("first") val first: String? = null,
        @SerialName("last") val last: String? = null
    )

    @Serializable
    data class PictureDto(
        @SerialName("large") val large: String? = null
    )
}