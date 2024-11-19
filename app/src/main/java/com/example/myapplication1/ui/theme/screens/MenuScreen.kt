package com.example.myapplication1.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp




@Composable
fun MenuScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A192F))
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxWidth()  ) {
            // Texto de "Componentes"
            Text(
                text = "Componentes",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp)
            )

            // Botón de "Componentes"
            FloatingActionButton(
                onClick = { navController.navigate("component") },
                containerColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(start = 16.dp)
            ) {}

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Elige una API a usar",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        // Segunda columna con separación
        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 48.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Segundo Plano",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
            FloatingActionButton(
                onClick = { navController.navigate("SegundoPlano") },
                containerColor = MaterialTheme.colorScheme.secondary
            ) {}

            Text(
                text = "Geolocalización",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
            FloatingActionButton(
                onClick = { navController.navigate("Location") },
                containerColor = Color(0xFF4CAF50)
            ) {}

            Text(
                text = "Contactos y calendario",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
            FloatingActionButton(
                onClick = { navController.navigate("ContactCalendar") },
                containerColor = MaterialTheme.colorScheme.tertiary
            ) {}

            Text(
                text = "Datos biométricos",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
            FloatingActionButton(
                onClick = { navController.navigate("BiometricsScreen") },
                containerColor = Color(0xFFFF5722)
            ) {}

            Text(
                text = "Cámara y archivos",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
            FloatingActionButton(
                onClick = { navController.navigate("CamaraScreen") },
                containerColor = MaterialTheme.colorScheme.error
            ) {}

            Text(
                text = "Conectividad",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
            FloatingActionButton(
                onClick = { navController.navigate("wifidatos") },
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ) {}
        }
    }
}
