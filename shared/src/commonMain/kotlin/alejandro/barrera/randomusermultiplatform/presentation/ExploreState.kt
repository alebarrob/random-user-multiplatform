package alejandro.barrera.randomusermultiplatform.presentation

import alejandro.barrera.randomusermultiplatform.presentation.model.UserVo

data class ExploreState(
    val isLoading: Boolean = false,
    val users: List<UserVo> = emptyList(),
    val error: String? = null
)