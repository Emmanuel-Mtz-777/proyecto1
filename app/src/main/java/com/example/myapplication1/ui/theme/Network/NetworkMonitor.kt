package com.example.myapplication1.ui.theme.Network



import android.Manifest
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.TrafficStats
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.myapplication1.MainActivity
import kotlinx.coroutines.delay

class NetworkMonitor(
    private val wifiManager: WifiManager,
    private val connectivityManager: ConnectivityManager,
    private val activity: MainActivity
) {

    private fun getConnectionStatus(): String {
        val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        val isWifiConnected = wifiManager.isWifiEnabled && networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) == true
        val isMobileConnected = networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) == true

        return when {
            isWifiConnected -> {
                if (ContextCompat.checkSelfPermission(
                        activity,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    val wifiInfo: WifiInfo? = wifiManager.connectionInfo
                    val ssid = wifiInfo?.ssid?.replace("\"", "") ?: "Desconocido"
                    "Conectado a WiFi: $ssid"
                } else {
                    "Conectado a WiFi (Nombre de red no disponible)"
                }
            }
            isMobileConnected -> "Conectado a Datos Móviles"
            else -> "Sin conexión a Internet"
        }
    }

    fun isUsingMobileData(): Boolean {
        return connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            ?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) == true
    }

    @Composable
    fun NetworkMonitorScreen() {
        var connectionStatus by remember { mutableStateOf("Sin conexión a Internet") }
        var mobileDataUsage by remember { mutableStateOf(0L) }
        var wifiDataUsage by remember { mutableStateOf(0L) }
        var networkSpeed by remember { mutableStateOf(0) }
        var isHighQualityImage by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            activity.requestPermissionsIfNeeded()

            var lastMobileBytes = TrafficStats.getMobileRxBytes() + TrafficStats.getMobileTxBytes()
            var lastWifiBytes = TrafficStats.getTotalRxBytes() - lastMobileBytes

            while (true) {
                connectionStatus = getConnectionStatus()
                val isMobileConnected = isUsingMobileData()
                isHighQualityImage = !isMobileConnected

                val currentMobileBytes = TrafficStats.getMobileRxBytes() + TrafficStats.getMobileTxBytes()
                val currentWifiBytes = TrafficStats.getTotalRxBytes() - currentMobileBytes

                val mobileDataUsed = currentMobileBytes - lastMobileBytes
                val wifiDataUsed = currentWifiBytes - lastWifiBytes

                if (isMobileConnected && mobileDataUsed > 0) {
                    networkSpeed = ((mobileDataUsed * 8) / 1024).toInt()
                    mobileDataUsage += mobileDataUsed
                    lastMobileBytes = currentMobileBytes
                } else if (!isMobileConnected && wifiDataUsed > 0) {
                    networkSpeed = ((wifiDataUsed * 8) / 1024).toInt()
                    wifiDataUsage += wifiDataUsed
                    lastWifiBytes = currentWifiBytes
                } else {
                    networkSpeed = 0
                }

                delay(500L)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            if (connectionStatus != "Sin conexión a Internet") {
                NetworkImage(isHighQualityImage)
            } else {
                Text(
                    "Sin conexión para cargar la imagen",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.error
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            ConnectionCard("Estado de la Conexión", connectionStatus, networkSpeed)
            Spacer(modifier = Modifier.height(16.dp))
            ConnectionCard("Consumo de Datos Móviles", "${mobileDataUsage / (1024 * 1024)} MB")
            Spacer(modifier = Modifier.height(16.dp))
            ConnectionCard("Consumo de Datos WiFi", "${wifiDataUsage / (1024 * 1024)} MB")
        }
    }
}