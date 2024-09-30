package com.example.myapplication1.ui.theme.screens


import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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
                NavigationDrawerItem(label = { Text(text = "Buttons")},
                    selected = false,
                    onClick = {
                        component="Buttons"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    })
                NavigationDrawerItem(label = { Text(text = "Floating Buttons")},
                    selected = false,
                    onClick = {
                        component="FloatingButtons"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    })
                NavigationDrawerItem(label = { Text(text = "Chips")},
                    selected = false,
                    onClick = {
                        component="Chips"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    })
                NavigationDrawerItem(label = { Text(text = "Sliders")},
                    selected = false,
                    onClick = {
                        component="Sliders"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    })
                NavigationDrawerItem(label = { Text(text = "Switches")},
                    selected = false,
                    onClick = {
                        component="Switches"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    })
                NavigationDrawerItem(label = { Text(text = "Progress")},
                    selected = false,
                    onClick = {
                        component="Progress"
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
                "Content 1"->{
                    Content1()
                }
                "Content 2"->{
                    Content2()
                }
                "Buttons"->{
                    Buttons()
                }
                "FloatingButtons"->{
                    FloatingButtons()
                }
                "Chips"->{
                    Chips()
                }
                "Sliders"->{
                    Sliders()
                }
                "Switches"->{
                    Switches()
                }
                "Progress"->{
                    Progress()
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

@Composable
fun Buttons(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier=Modifier
            .fillMaxSize()

    ){
        Button(onClick={}){
            Text(text = "Filled")
        }

        FilledTonalButton(onClick={}){
            Text(text = "Tonal")
        }

        OutlinedButton(onClick={}){
            Text(text = "OutLined")
        }

        ElevatedButton(onClick={}){
            Text(text = "Elevated")
        }

        TextButton(onClick = {}) {
            Text(text = "TextButon")
        }

    }
}

@Composable
fun FloatingButtons() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        FloatingActionButton(onClick = { }) {
            Icon(Icons.Filled.Person, contentDescription = "")
        }

        SmallFloatingActionButton(onClick = { }) {
            Icon(Icons.Filled.AccountBox, contentDescription = "")
        }

        LargeFloatingActionButton(onClick = { }) {
            Icon(Icons.Filled.AccountBox, contentDescription = "")
        }

        ExtendedFloatingActionButton(
            onClick = { },
            icon = { Icon(Icons.Filled.Home, contentDescription = "") },
            text = { Text("Extended FAB") }
        )
    }
}

@Composable
fun Chips() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        AssistChip(
            onClick = { },
            label = { Text("AssistChip") },
            leadingIcon = {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "",
                    modifier = Modifier.size(AssistChipDefaults.IconSize)
                )
            }
        )

        var selected by remember { mutableStateOf(false) }

        FilterChip(
            selected = selected,
            onClick = { selected = !selected },
            label = { Text("FilterChip") },
            leadingIcon = {
                if (selected) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "",
                        modifier = Modifier.size(AssistChipDefaults.IconSize)
                    )
                } else {
                    null
                }
            }
        )
        InputChipExample(text = "Dimiss",{})

        }
    }

@Composable
fun InputChipExample(
    text: String,
    onDimiss: () -> Unit
) {
    var enable by remember { mutableStateOf(true) }
    if (!enable) return

    InputChip(
        label = { Text(text) },
        selected = enable,
        onClick = {
            onDimiss()
            enable = !enable
        },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "",
                modifier = Modifier
                    .size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Filled.Close,
                contentDescription = "",
                modifier = Modifier
                    .size(InputChipDefaults.AvatarSize)
            )
        }
    )
}

@Composable
fun Progress(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ){
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
        )
        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
        )


    }
}

@Composable
fun Sliders (){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ){
        var sliderPosition by remember { mutableStateOf(50f) }
        Column {
            Slider(
                value = sliderPosition,
                onValueChange ={sliderPosition=it },
                steps = 10,
                valueRange = 0f..100f
            )
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(),
                text = sliderPosition.toString()
            )
        }
    }
}

@Composable
fun Switches() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )

        var checked2 by remember { mutableStateOf(true) }
        Switch(
            checked = checked2,
            onCheckedChange = {
                checked2 = it
            },
            thumbContent = {
                if (checked2) {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = "",
                        modifier = Modifier
                            .size(InputChipDefaults.AvatarSize)
                    )
                } else {
                    null
                }
            }

        )
        var checked3 by remember { mutableStateOf(true) }
        Checkbox(checked = checked3, onCheckedChange ={checked3=it})

    }
}
