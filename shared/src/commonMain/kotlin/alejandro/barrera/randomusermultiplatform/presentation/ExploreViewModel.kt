package alejandro.barrera.randomusermultiplatform.presentation

import alejandro.barrera.randomusermultiplatform.domain.use_case.GetRandomUsers
import alejandro.barrera.randomusermultiplatform.presentation.mapper.toUserVo
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class ExploreViewModel(
    private val getRandomUsers: GetRandomUsers
) {
    private val scope = MainScope()

    private val _state = MutableStateFlow(ExploreState())
    val state: StateFlow<ExploreState> = _state

    fun subscribe(onState: (ExploreState) -> Unit) {
        scope.launch {
            state.collect { onState(it) }
        }
    }

    fun load() {
        _state.update { it.copy(isLoading = true, error = null) }
        scope.launch {
            getRandomUsers.invoke().fold(
                success = { list ->
                    _state.update { ExploreState(users = list.map { it.toUserVo() }) }
                },
                failure = { e ->
                    _state.update { ExploreState(error = e?.message) }
                }
            )
        }
    }

    fun clear() {
        scope.cancel()
    }
}