package com.example.myapplication1

import ComponentScreen
import android.os.Bundle
import android.content.Context
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication1.ui.theme.screens.HomeScreen
import com.example.myapplication1.ui.theme.screens.MenuScreen
import com.example.myapplication1.ui.theme.screens.CameraScreen
import androidx.navigation.NavHostController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMultisCreenApp(this)  // Pasamos el contexto aquí
        }
    }
}

@Composable
fun ComposeMultisCreenApp(context: Context){
    val navController = rememberNavController()
    Surface(color = Color.White) {
        SetupNavGraph(navController = navController, context = context)  // Pasamos el contexto aquí
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController, context: Context) {
    NavHost(
        navController = navController,
        startDestination = "camera"
    ) {
        composable("menu") {
            MenuScreen(navController)
        }
        composable("home") {
            HomeScreen(navController)
        }
        composable("components") {
            ComponentScreen(navController)
        }
        composable("camera") {
            CameraScreen(navController, context)
        }
    }
}
