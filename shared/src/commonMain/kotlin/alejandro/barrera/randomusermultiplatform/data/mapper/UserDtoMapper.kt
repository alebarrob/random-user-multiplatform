package alejandro.barrera.randomusermultiplatform.data.mapper

import alejandro.barrera.randomusermultiplatform.data.dto.ResponseDto
import alejandro.barrera.randomusermultiplatform.domain.model.User

private const val UNAVAILABLE_EMAIL = "Email no disponible"
private const val UNAVAILABLE_PHONE = "Teléfono no disponible"
private const val SPAIN_AREA_CODE = "+34"

fun ResponseDto.ResultDto.toUser() = User(
    name = "${name?.first} ${name?.last}",
    email = email ?: UNAVAILABLE_EMAIL,
    phone = convertPhone(input = cell),
    pictureUrl = picture?.large
)

private fun convertPhone(input: String?) = input?.let { userPhone ->
    "$SPAIN_AREA_CODE ${userPhone.filter { it.isDigit() }}"
} ?: UNAVAILABLE_PHONE