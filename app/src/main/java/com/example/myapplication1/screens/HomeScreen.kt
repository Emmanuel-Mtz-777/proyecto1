package com.example.myapplication1.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController){
    Column {
     Text(text = "Esta es la pantalla de inicio")
        Button(onClick = {navController.navigate("menu")}) {

        }
    }
}