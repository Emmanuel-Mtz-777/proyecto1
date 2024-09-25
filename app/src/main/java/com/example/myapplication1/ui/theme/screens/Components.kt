package com.example.myapplication1.ui.theme.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

//Menu lateral como ventana modal modales
@Composable
fun ComponentsScreen(navController: NavController){
    //Actualiza el valor de la variable en la interfaz
    var component by remember { mutableStateOf("") }
    val drawerState= rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope= rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState= drawerState,
        drawerContent = {
            //Hoja del contenido del menu
            ModalDrawerSheet {
                Text(text = "Menu",
                    modifier = Modifier
                    .padding(16.dp)
                    )
                HorizontalDivider()
                NavigationDrawerItem(label = { Text(text = "Componente 1")},
                    selected = false,
                    onClick = {
                        component="Content 1"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    })
                NavigationDrawerItem(label = { Text(text = "Componente 2")},
                    selected = false,
                    onClick = {
                        component="Content 2"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    })
            }
        }) {
        Column {
           when(component){
               "Content1"->{
                   Content1()
               }
               "Content2"->{
                   Content2()
               }
           }

        }
    }


    }


@Composable
fun Content1(){
    Text(text = "Content 1")
}

@Composable
fun Content2(){
    Text(text = "Content 2")
}