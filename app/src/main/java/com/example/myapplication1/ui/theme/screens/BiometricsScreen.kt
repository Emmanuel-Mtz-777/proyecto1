package com.example.myapplication1.ui.theme.screens

import android.widget.Toast
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.example.myapplication1.R


@Composable
fun BiometricsScreen() {
    val context = LocalContext.current
    val biometricManager = BiometricManager.from(context)

    var message by remember { mutableStateOf("") }
    var showBiometricButton by remember { mutableStateOf(true) }
    var isAuthenticated by remember { mutableStateOf(false) }
    var imageResource by remember { mutableIntStateOf(R.drawable.cipher) }

    LaunchedEffect(Unit) {
        when (biometricManager.canAuthenticate()) {
            BiometricManager.BIOMETRIC_SUCCESS -> {
                message = "Dispositivo habilitado para utilizar datos biométricos."
            }

            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                message = "Este dispositivo no contiene lector de datos biométricos."
                showBiometricButton = false
            }

            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                message = "El lector de datos biométricos no se encuentra disponible."
                showBiometricButton = false
            }

            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                message =
                    "El dispositivo no cuenta con datos biométricos cargados. Por favor configure la seguridad."
                showBiometricButton = false
            }
        }
    }

    val executor = ContextCompat.getMainExecutor(context)
    val biometricPrompt = BiometricPrompt(
        context as FragmentActivity,
        executor,
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Toast.makeText(context, "Acceso correcto", Toast.LENGTH_SHORT).show()
                isAuthenticated = true // Cambia el estado a autenticado
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Toast.makeText(context, "Autenticación fallida", Toast.LENGTH_SHORT).show()
            }
        }
    )

    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("Verifica tu identidad")
        .setDescription("Coloca el dedo sobre el lector de huellas")
        .setNegativeButtonText("Cancelar")
        .build()

    if (isAuthenticated) {
        // Muestra el contenido autenticado
        AuthenticatedScreen()
    } else {
        // Muestra la pantalla de inicio de sesión biométrico
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Utiliza tu huella para desbloquear",
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier
                    .size(168.dp)
                    .padding(vertical = 20.dp)
            )

            Text(
                text = message,
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            if (showBiometricButton) {
                Button(
                    onClick = { biometricPrompt.authenticate(promptInfo) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Login")
                }
            }
        }
    }
}

@Composable
fun AuthenticatedScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "¡Bienvenido!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Autenticación biométrica.",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.cipher),
            contentDescription = "Imagen de perfil",
            modifier = Modifier.size(128.dp)
        )
    }
}