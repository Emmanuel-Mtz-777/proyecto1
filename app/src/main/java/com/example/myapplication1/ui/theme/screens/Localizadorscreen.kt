package com.example.myapplication1.ui.theme.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication1.ui.theme.theme.MyApplication1Theme
import com.example.myapplication1.Navegation.NavManager
import com.example.myapplication1.viewmodels.SearchViewModel

@Composable
fun LocalizacionScreen(viewModel: SearchViewModel) {
    MyApplication1Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavManager(viewModel)
        }
    }
}