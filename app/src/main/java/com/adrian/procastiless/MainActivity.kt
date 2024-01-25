package com.adrian.procastiless

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.adrian.procastiless.ui.theme.ProcrastilessTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private var uiState: ProcrastilessUiState by mutableStateOf(
        value = ProcrastilessUiState.Loading
    )
    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        Create the splash screen if we decide there will be any.
         */
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel
                    .uiState
                    .onEach(::onStateChanged)
                    .collect()
            }
        }

        setContent {
            ProcrastilessTheme {
                    Scaffold { paddingValues ->
                        Column(modifier = Modifier.padding(paddingValues)) {
                            val state = if (uiState is ProcrastilessUiState.Success) {
                                "User found"
                            }else {
                                "User not found"
                            }
                            Text("$state")
                        }
                    }
            }
        }
    }

    private fun onStateChanged(procrastilessUiState: ProcrastilessUiState) {
        uiState = procrastilessUiState
    }
}