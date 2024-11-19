package com.example.myapplication1.ui.theme.screens

import android.Manifest
import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.myapplication1.Alarm.AlarmWorker
import java.util.*
import java.util.concurrent.TimeUnit

@SuppressLint("DefaultLocale")
@Composable
fun SegundoPlanoScreen() {
    val context = LocalContext.current
    var hasNotificationPermission by remember { mutableStateOf(false) }
    var selectedTime by remember { mutableStateOf("") }
    var calendar = Calendar.getInstance()

    // Solicitar permiso para notificaciones en Android 13+
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !hasNotificationPermission) {
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            hasNotificationPermission = isGranted
            if (!isGranted) {
                Toast.makeText(context, "Permiso de notificaciones denegado", Toast.LENGTH_SHORT).show()
            }
        }
        LaunchedEffect(Unit) {
            launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    } else {
        hasNotificationPermission = true // Para versiones anteriores a Android 13
    }

    // UI para configurar la alarma
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Configura la Alarma", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))
        Text(text = "Hora seleccionada: $selectedTime", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            TimePickerDialog(
                context,
                { _, hour: Int, minute: Int ->
                    calendar = Calendar.getInstance().apply {
                        set(Calendar.HOUR_OF_DAY, hour)
                        set(Calendar.MINUTE, minute)
                        set(Calendar.SECOND, 0)
                    }
                    selectedTime = String.format("%02d:%02d", hour, minute)

                    val currentTime = Calendar.getInstance().timeInMillis
                    val delayInMillis = calendar.timeInMillis - currentTime

                    if (delayInMillis > 0) {
                        if (hasNotificationPermission) {
                            scheduleAlarm(context, delayInMillis)
                        } else {
                            Toast.makeText(context, "No tienes permiso para notificaciones", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(context, "Selecciona una hora futura", Toast.LENGTH_SHORT).show()
                    }
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
            ).show()
        }) {
            Text("Seleccionar Hora")
        }
    }
}

// Función para programar la alarma usando WorkManager
fun scheduleAlarm(context: Context, delayInMillis: Long) {
    val workRequest = OneTimeWorkRequestBuilder<AlarmWorker>()
        .setInitialDelay(delayInMillis, TimeUnit.MILLISECONDS)
        .build()

    WorkManager.getInstance(context).enqueue(workRequest)
    Toast.makeText(context, "Alarma programada", Toast.LENGTH_SHORT).show()
}