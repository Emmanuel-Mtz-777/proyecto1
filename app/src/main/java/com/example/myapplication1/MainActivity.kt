package com.example.myapplication1

import android.content.Context
import android.graphics.Picture
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication1.ui.theme.theme.MyApplication1Theme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication1.views.HomeView
import com.example.myapplication1.ui.theme.screens.MenuScreen
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.activity
import com.example.myapplication1.ui.theme.screens.BiometricsScreen
import com.example.myapplication1.ui.theme.screens.CameraScreen
import com.example.myapplication1.ui.theme.screens.ComponentScreen
import com.example.myapplication1.ui.theme.screens.ContactCalendarScreen
import com.example.myapplication1.ui.theme.screens.HomeScreen
import com.example.myapplication1.ui.theme.screens.LocalizacionScreen
import com.example.myapplication1.ui.theme.screens.MenuScreen
import com.example.myapplication1.ui.theme.screens.SegundoPlanoScreen
import com.example.myapplication1.ui.theme.screens.WifiDatosScreen

//import androidx.navigation.compose.NavHostController

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()//abarca el 100% de la pantalla
        setContent {
            ComposeMultiScreenApp()
        }
    }
}
@Composable
fun ComposeMultiScreenApp(){
    val navController = rememberNavController()
    Surface(color = Color.White) {
        SetupNavGraph(navController = navController)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController,startDestination = "menu"){
        composable("menu"){ MenuScreen(navController) }
        composable("home"){ HomeScreen(navController) }
        composable("component"){ ComponentScreen(navController) }
        //expo 1 programación de tareas en 2do plano
        composable("SegundoPlano"){ SegundoPlanoScreen() }
        //expo 2 servicios de rastreo y geolocalización
        composable("Location"){ LocalizacionScreen(viewModel()) }
        //expo 3 Acceso a contactos y calendario
        composable("ContactCalendar"){ ContactCalendarScreen() }
        //expo 4 Acceso a sensores biométricos
        composable("BiometricsScreen") { BiometricsScreen() }
        //expo 5 Acceso a cámara y manejo de archivos del dispositivo
        composable("CamaraScreen"){ CameraScreen() }
        //expo 6 Conectividad Wifi y datos celulares
        composable("wifidatos") {
            WifiDatosScreen(
                wifiManager = LocalContext.current.getSystemService(Context.WIFI_SERVICE) as WifiManager,
                connectivityManager = LocalContext.current.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager,
                context = LocalContext.current as ComponentActivity
            )
        }
    }
}