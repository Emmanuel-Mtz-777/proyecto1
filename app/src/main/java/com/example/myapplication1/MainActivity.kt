package com.example.myapplication1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication1.ui.theme.MyApplication1Theme
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication1.ui.theme.screens.HomeScreen
import com.example.myapplication1.ui.theme.screens.MenuScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable





class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            ComposeMultisCreenApp()


         /*   Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())  // Habilita el scroll
                    .fillMaxWidth()  // Llena el ancho pero deja que la altura se ajuste al contenido
                    .padding(16.dp),  // Un padding opcional
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                customText()
                Picture()
                Text(text = "Texto simple")
                //ModifierExample()
                //ModifierExample2()
                //ModifierExample3()
                Content1()
                horizontalCard()
                boxExample()
                boxExample2()
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
            }*/*/

        }
    }
}

//Cada compouse es un componente visual
/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}*/

/*@Preview(showBackground = true)
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
}*/

/*@Preview(showBackground = true)
@Composable
fun customText() {

    Column {
        Text(
            stringResource(R.string.hello_world_text),
            color = colorResource(R.color.teal_700),
            fontSize = 28.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
        )
        val gradientColors = listOf(Cyan, Blue)
        Text(
            stringResource(R.string.hello_world_text),
            style = TextStyle(brush = Brush.linearGradient(colors = gradientColors))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Picture() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
    ) {
        Image(
            painter = painterResource(R.drawable.covenant),
            contentDescription = "Una imagen del covenant",
            contentScale = ContentScale.Fit
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Content1() {
    Card(
        modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Row {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                painter = painterResource(id = R.drawable.covenant), contentDescription = "Card Logo",
                contentScale = ContentScale.Fit
            )


        }
        Text(
            text = "Este es el titulo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(15.dp)
        )
        Text(
            stringResource(id = R.string.lorem),
            textAlign = TextAlign.Justify,
            lineHeight = 10.sp,
            modifier = Modifier
                .padding(10.dp)
        )




    }
}

@Preview(showBackground = true)
@Composable
fun horizontalCard() {
    Card(
        modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .background(Color.Black)
        ) {
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = R.drawable.covenant),
                contentDescription = "Card Logo",
                contentScale = ContentScale.Fit
            )

            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth()
                    .background(Color.White)

            ) {
                Text(
                    text = "Este es el título",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = stringResource(id = R.string.lorem),
                    textAlign = TextAlign.Justify,
                    lineHeight = 18.sp,
                    maxLines = 7,
                    modifier = Modifier
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun boxExample() {
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.teal_700))
            .fillMaxWidth()
            .padding(5.dp)



    ) {
        Image(
            painter = painterResource(id =R.drawable.cipher),
            contentDescription = "Foto del covenant",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.Center)
        )

        Row(
            modifier = Modifier
                .align(Alignment.TopStart) // Alinea el Row en la parte inferior central del Box
                .fillMaxWidth()
                .padding(0.dp, 10.dp),
            horizontalArrangement = Arrangement.Center // Alinea el contenido del Row en el centro
        ) {
            Icon(
                imageVector = Icons.Filled.AddCircle,
                contentDescription = "Probando Iconos",
                modifier = Modifier

                    .padding(5.dp, 0.dp),
                tint = Color.White
            )
            Text(
                text = "Icono",
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp),
                color = Color.White
            )
        }

    }
}
@Preview(showBackground = true)
@Composable
fun boxExample2() {
    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(5.dp)
            .size(250.dp)
    ) {
        Text(text = "Top Start", Modifier.align(Alignment.TopStart))
        Text(text = "Top End", Modifier.align(Alignment.TopEnd))
        Text(text = "Top Center", Modifier.align(Alignment.TopCenter))
        Text(text = "Center Start", Modifier.align(Alignment.CenterStart))
        Text(text = "Center", Modifier.align(Alignment.Center))
        Text(text = "Center End", Modifier.align(Alignment.CenterEnd))
        Text(text = "Bottom Start", Modifier.align(Alignment.BottomStart))
        Text(text = "Bottom End", Modifier.align(Alignment.BottomEnd))
        Text(text = "Bottom Center", Modifier.align(Alignment.BottomCenter))
    }
}*/

@Composable
fun ComposeMultisCreenApp(){
    val navController = rememberNavController()
    Surface(color = Color.White) {
    SetupNavGraph(navController =navController)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "menu"
    ) {
        composable("menu") {
            MenuScreen(navController)
        }
        composable("home") {
            HomeScreen(navController)
        }
    }
}