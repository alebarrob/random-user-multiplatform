package alejandro.barrera.randomusermultiplatform.presentation.mapper

import alejandro.barrera.randomusermultiplatform.domain.model.User
import alejandro.barrera.randomusermultiplatform.presentation.model.UserVo

fun User.toUserVo() = UserVo(
    name = name,
    email = email,
    phone = phone,
    pictureUrl = pictureUrl
)