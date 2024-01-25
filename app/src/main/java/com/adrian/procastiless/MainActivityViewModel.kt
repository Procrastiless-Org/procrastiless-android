package com.adrian.procastiless

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrian.procastiless.data.userrepository.api.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    userRepository: UserRepo
): ViewModel() {
    val uiState: StateFlow<ProcrastilessUiState> = userRepository.userData.map { data ->
        ProcrastilessUiState.Success(data)
    }.stateIn(
        scope = viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        initialValue = ProcrastilessUiState.Loading
    )
}

sealed class ProcrastilessUiState {
    // Fake a loading screen for now.
    object Loading: ProcrastilessUiState()
    data class Success(val userData: com.adrian.procastiless.data.userrepository.models.UserModel): ProcrastilessUiState()
}