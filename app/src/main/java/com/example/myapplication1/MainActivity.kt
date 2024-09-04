package com.example.myapplication1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication1.ui.theme.MyApplication1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            Column(
                modifier =Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
            ){
              Text(text="Texto simple")
                ModifierExample()
                ModifierExample2()
                ModifierExample3()
            }
                //Layouts
                /*Column(modifier = Modifier.fillMaxSize()) {
                    Text(text = "First Row")
                    Text(text = "Second Row")
                    Text(text = "Third Row")
                    Text(text = "Fourth Row")
                    Row {
                        Text(text = "HOLA 1")
                        Text(text = "HOLA 2")
                        Text(text = "HOLA 3")
                        Text(text = "HOLA 4")
                    }
                    Box {
                        Text(text = "Label 1")
                        Text(text = "Label 2")
                        Text(text = "Label 3")
                    }
                    Greeting(name = "Hello World")
                }*/

        }
    }
}
//Cada compouse es un componente visual
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplication1Theme {
        Greeting("Emmanuel")
    }
}
@Preview(showBackground = true)
@Composable
fun ModifierExample(){
    Column (modifier = Modifier
        .padding(24.dp)){
    Text(text = "Un texto con padding")
    }
}

@Preview(showBackground = true)
@Composable
fun ModifierExample2(){
    Column (modifier = Modifier
        .padding(24.dp)
        .fillMaxWidth()
        .clickable(onClick = { clickAction() })){
        Text(text = "Un texto con padding")
    }
}

fun clickAction(){
    println("Columna clickeada")
}

@Preview(showBackground = true)
@Composable
fun ModifierExample3(){
    Column (modifier = Modifier
        .fillMaxHeight()
        .padding(24.dp)
        .background(Color.LightGray)
        .border(width = 2.dp, color = Color.Cyan)
        .width(200.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly){
        Text(text = "Texto con algo similar a css")
        Text(text = "Texto 2")
        Text(text = "Texto 3")
        Text(text = "Texto 4")
        Text(text = "Texto 5")
    }
}