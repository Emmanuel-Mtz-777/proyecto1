package com.example.myapplication1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
// com.example.myapplication1.ui.theme.screens.HomeScreen
//import com.example.myapplication1.ui.theme.screens.MenuScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable





class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            Scaffold(
                bottomBar = { BottomAppBarWithIcons() }
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues) // Aplica el padding para Scaffold
                        .verticalScroll(rememberScrollState())
                ) {
                    // Contenido desplazable
                    navbar()
                    bannerPromo()
                    recomendedCarousel()
                    promoCarousel()
                    categoryCarrusel()
                    basedOnThePlayCarousel()
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun navbar() {
    var searchText by remember { mutableStateOf(TextFieldValue()) }
    var showModal by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .background(color = colorResource(id = R.color.darkSteam))
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Column {
            Row(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.darkSteam))
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)

            ) {
                TextField(
                    value = searchText,
                    onValueChange = { newText -> searchText = newText },
                    placeholder = { Text("STEAM") },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorResource(id = R.color.navBar),
                        cursorColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                        .background(color = colorResource(id = R.color.navBar))
                )
                IconButton(onClick = {  showModal = true }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Buscar",
                        tint = Color.White  // Cambiado a blanco para contrastar con el fondo oscuro
                    )
                }
                IconButton(onClick = {  showModal = true }) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "Menú vertical",
                        tint = Color.White
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Icon User",
                    modifier = Modifier
                        .size(60.dp)
                        .clickable{showModal=true}
                )
            }

            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .background(color = colorResource(id = R.color.darkSteam))
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "MENU", color = Color.White, modifier = Modifier
                    .padding(horizontal = 16.dp,)
                    .clickable{
                        showModal=true
                    })
                Text(text = "WISHLIST", color = Color.White, modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clickable{
                        showModal=true
                    })
                Text(text = "WALLET", color = Color.White, modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clickable{
                        showModal=true
                    })
            }
        }
        if (showModal) {
            mensajeModal(
                onDismiss = { showModal = false },
                onConfirm = { showModal = false },

                )
        }
    }
}

@Composable
fun bannerPromo() {
    Box(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner de promo",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(290.dp)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun recomendedCarousel() {
    var showModal by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.darkSteam3))
    ) {
        Text(
            text = "FEATURE & RECOMMENDED",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 30.dp, top = 20.dp),
            color = Color.White
        )
    }

    val imageList = listOf(
        painterResource(id = R.drawable.finalfantasy7),
        painterResource(id = R.drawable.dota2),
        painterResource(id = R.drawable.conter),
        painterResource(id = R.drawable.forza),
        painterResource(id = R.drawable.apex),
        painterResource(id = R.drawable.fc25),
        painterResource(id = R.drawable.wukon),
        painterResource(id = R.drawable.pubg),
        painterResource(id = R.drawable.kratos),
    )

    val titles = listOf(
        "FINAL FANTASY VII REMAKE ",
        "Dota 2",
        "Counter-Strike 2",
        "Forza Horizon 4",
        "Apex Legends™",
        "EA SPORTS FC™ 25",
        "Black Myth: Wukong",
        "PUBG: BATTLEGROUNDS",
        "God of War Ragnarök"
    )

    val prices = listOf(
        "Mex$ 1,450.00",
        "Free to play",
        "Free to play",
        "Mex$ 1,499.00",
        "Free to play",
        "Mex$ 1,299.00",
        "Mex$ 999.00",
        "Free to play",
        "Mex$ 999.00",
    )

    val pagerState = rememberPagerState { imageList.size }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                //se usa para crear fondos gradiantes es decir en degradados
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.darkSteam3),
                        colorResource(id = R.color.steamFondo),
                        colorResource(id = R.color.steam)
                    )
                )
            )
            .padding(bottom = 55.dp)
    ) {
        HorizontalPager(
            state = pagerState,
            pageSpacing = 16.dp,
            contentPadding = PaddingValues(start = 32.dp, end = 32.dp)
        ) { page ->
            Card(
                modifier = Modifier
                    .width(400.dp)
                    .height(303.dp)  // Aumenta la altura para más espacio
                    .padding(vertical = 8.dp)
                    .shadow(elevation = 15.dp)
                    .background(colorResource(id = R.color.darkSteam)),
                shape = RectangleShape,
                onClick = {
                    showModal = true
                }
            ) {
                Column {
                    Image(
                        painter = imageList[page % imageList.size],
                        contentDescription = "Carrusel Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        colorResource(id = R.color.darkSteam),
                                        colorResource(id = R.color.darkSteam2),  // Primer color del gradiente
                                        colorResource(id = R.color.darkSteam3)     // Segundo color del gradiente
                                    )
                                )
                            )
                            .padding(8.dp)
                            .weight(1f),

                        ) {
                        Text(
                            text = titles[page % titles.size],
                            color = Color.White,
                            fontSize = 22.sp
                        )
                        Spacer(modifier = Modifier.height(7.dp))
                        Text(
                            text = prices[page % prices.size],
                            color = Color.DarkGray,
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(bottom = 20.dp)
                                .padding(start = 15.dp)

                        )
                    }
                }
            }
        }

        // Auto-scroll to the beginning after reaching the end
        LaunchedEffect(pagerState.currentPage) {
            if (pagerState.currentPage == imageList.size - 1) {
                pagerState.animateScrollToPage(0)
            }
        }
        if (showModal) {
            mensajeModal(
                onDismiss = { showModal = false },
                onConfirm = { showModal = false },

                )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun promoCarousel() {
    var showModal by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.darkSteam))
    ) {
        Text(
            text = "SPECIAL OFFERS",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 30.dp, top = 20.dp),
            color = Color.White
        )
    }

    val imageList1 = listOf(
        painterResource(id = R.drawable.totaltank),
        painterResource(id = R.drawable.godowar),
        painterResource(id = R.drawable.dragondogma),
        painterResource(id = R.drawable.forza5),
        painterResource(id = R.drawable.finalfantasy7),
        painterResource(id = R.drawable.spiderman),
        painterResource(id = R.drawable.naruto),


        )

    val titles1 = listOf(
        "Total Tank Simulator ",
        "God of War ",
        "Dragon's Dogma 2",
        "Forza Horizon 5 ",
        "FINAL FANTASY VII REMAKE ",
        "Marvel’s Spider-Man",
        "NARUTO SHIPPUDEN"
    )

    val prices1 = listOf(
        "Mex$ 74.39",
        "Mex$ 331.60",
        "Mex$ 683.43",
        "Mex$ 699.50",
        "Mex$ 715.00",
        "Mex$ 599.40",
        "Mex$ 170.60",
    )
    val imageList2 = listOf(
        painterResource(id = R.drawable.unheard),
        painterResource(id = R.drawable.ghost),
        painterResource(id = R.drawable.helldivers),
        painterResource(id = R.drawable.crew),
        painterResource(id = R.drawable.caloduty),
        painterResource(id = R.drawable.beam),
        painterResource(id = R.drawable.milesmorales)
    )

    val titles2 = listOf(
        "Unheard",
        "Ghost of Tsushima ",
        "HELLDIVERS™ 2",
        "The Crew™ 2",
        "Call of Duty®",
        "BeamNG.drive",
        "Spider-Man: Miles Morales"
    )

    val prices2 = listOf(
        "Mex$ 45.60",
        "Mex$ 799.20",
        "Mex$ 599.20",
        "Mex$ 19.98",
        "Mex$ 149.99",
        "Mex$ 226.39",
        "Mex$ 497.40"
    )

    val pagerState = rememberPagerState { imageList1.size }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                //se usa para crear fondos gradiantes es decir en degradados
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.darkSteam),
                        colorResource(id = R.color.darkSteam2)
                    )
                )
            )
            .padding(bottom = 55.dp)
    ) {
        HorizontalPager(
            state = pagerState,
            pageSpacing = 16.dp,
            contentPadding = PaddingValues(start = 32.dp, end = 32.dp)
        ) { page ->
            Column {
                Card(
                    modifier = Modifier
                        .width(400.dp)
                        .height(285.dp)
                        .padding(vertical = 8.dp)
                        .background(colorResource(id = R.color.darkSteam)),
                    shape = RectangleShape,
                    onClick = {
                        showModal = true
                    }
                ) {
                    Column {
                        Image(
                            painter = imageList1[page % imageList1.size],
                            contentDescription = "Carrusel Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            contentScale = ContentScale.Crop
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    //se usa para crear fondos gradiantes es decir en degradados
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            colorResource(id = R.color.steamPromo),
                                            colorResource(id = R.color.steamPromo2),
                                            colorResource(id = R.color.steamPromo3)
                                        )
                                    )
                                )
                                .padding(8.dp)
                                .padding(bottom = 30.dp)
                        ) {
                            Text(
                                text = titles1[page % titles1.size],
                                color = Color.White,
                                fontSize = 17.sp,
                                modifier =Modifier
                                    .background(color = colorResource(id = R.color.darkSteam2))

                            )
                            Text(
                                text = prices1[page % prices1.size],
                                modifier = Modifier
                                    .padding(bottom = 4.dp)
                                    .background(color = colorResource(id = R.color.promoBackground)),
                                fontSize = 19.sp,
                                color = colorResource(id = R.color.promoPrice)

                            )
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .width(400.dp)
                        .height(285.dp)
                        .padding(vertical = 8.dp)
                        .background(colorResource(id = R.color.darkSteam)),
                    shape = RectangleShape,
                    onClick = {
                        showModal = true
                    }
                ) {
                    Column {
                        Image(
                            painter = imageList2[page % imageList2.size],
                            contentDescription = "Carrusel Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            contentScale = ContentScale.Crop
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    //se usa para crear fondos gradiantes es decir en degradados
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            colorResource(id = R.color.steamPromo),
                                            colorResource(id = R.color.steamPromo2),
                                            colorResource(id = R.color.steamPromo3)
                                        )
                                    )
                                )
                                .padding(8.dp)
                                .padding(bottom = 30.dp)
                        ) {
                            Text(
                                text = titles2[page % titles2.size],
                                color = Color.White,
                                fontSize = 17.sp,
                                modifier =Modifier
                                    .background(color = colorResource(id = R.color.darkSteam2))

                            )
                            Text(
                                text = prices2[page % prices2.size],
                                modifier = Modifier
                                    .padding(bottom = 4.dp)
                                    .background(color = colorResource(id = R.color.promoBackground)),
                                fontSize = 19.sp,
                                color = colorResource(id = R.color.promoPrice)

                            )
                        }
                    }
                }
            }

        }


        LaunchedEffect(pagerState.currentPage) {
            if (pagerState.currentPage == imageList1.size - 1) {
                pagerState.animateScrollToPage(0)
            }
        }
        if (showModal) {
            mensajeModal(
                onDismiss = { showModal = false },
                onConfirm = { showModal = false },

                )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun categoryCarrusel() {
    var showModal by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.darkSteam3))
    ) {
        Text(
            text = "BROWSE BY CATEGORY",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 30.dp, top = 20.dp),
            color = Color.White
        )
    }

    val imageList = listOf(
        painterResource(id = R.drawable.anime),
        painterResource(id = R.drawable.estrategia),
        painterResource(id = R.drawable.deportes),
        painterResource(id = R.drawable.coperativo),
        painterResource(id = R.drawable.simulador),
        painterResource(id = R.drawable.carreras),
        painterResource(id = R.drawable.casual)
    )

    val textList = listOf(
        "Anime",
        "Estrategia",
        "Todos los deportes",
        "Coperativo",
        "Simulador",
        "Carreras",
        "Casual"
    )

    val colorList = listOf(
        Color.Red.copy(alpha = 0.3f),
        Color.Blue.copy(alpha = 0.3f),
        Color.Green.copy(alpha = 0.3f),
        Color.Yellow.copy(alpha = 0.3f),
        Color.Magenta.copy(alpha = 0.3f),
        Color.Cyan.copy(alpha = 0.3f),
        Color.DarkGray.copy(alpha = 0.3f)
    )

    val pagerState = rememberPagerState { imageList.size }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.darkSteam3),
                        colorResource(id = R.color.steamFondo),
                        colorResource(id = R.color.steam)
                    )
                )
            )
            .padding(bottom = 55.dp)
    ) {
        HorizontalPager(
            state = pagerState,
            pageSpacing = 0.dp,
            contentPadding = PaddingValues(start = 50.dp, end = 50.dp)
        ) { page ->
            Card(
                modifier = Modifier
                    .width(250.dp)
                    .height(250.dp)
                    .padding(vertical = 8.dp)
                    .shadow(elevation = 15.dp)
                    .background(colorResource(id = R.color.darkSteam)),
                shape = RectangleShape,
                onClick = {
                    showModal = true
                }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Image(
                        painter = imageList[page % imageList.size],
                        contentDescription = "Carrusel Image",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )


                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        colorList[page % colorList.size]
                                    ),
                                    startY = 0f,
                                    endY = 250f
                                )
                            )
                            .padding(16.dp),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Text(
                            text = textList[page % textList.size],
                            color = Color.White,
                            fontSize = 30.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        // Auto-scroll to the beginning after reaching the end
        LaunchedEffect(pagerState.currentPage) {
            if (pagerState.currentPage == imageList.size - 1) {
                pagerState.animateScrollToPage(0)
            }
        }

        if (showModal) {
            mensajeModal(
                onDismiss = { showModal = false },
                onConfirm = { showModal = false },

                )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun basedOnThePlayCarousel() {
    // Estado para controlar la visibilidad del modal
    var showModal by remember { mutableStateOf(false) }

    // Definición de las imágenes y precios
    val imageList = listOf(
        painterResource(id = R.drawable.hollowalppaper),
        painterResource(id = R.drawable.deadcellswallpaper),
        painterResource(id = R.drawable.hadeswallpaper),
        painterResource(id = R.drawable.albionwallpaper),
        painterResource(id = R.drawable.sonicwallpaper),
        painterResource(id = R.drawable.finalfantasy7),
        painterResource(id = R.drawable.crew),
        painterResource(id = R.drawable.caloduty)
    )

    val prices = listOf(
        "Mex$ 178.99",
        "Mex$ 239.99",
        "Mex$ 282.99",
        "Gratuito",
        "Mex$ 125.00",
        "Mex$ 715.00",
        "Mex$ 19.98",
        "Mex$ 1,399.00"
    )

    val pagerState = rememberPagerState { imageList.size }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.steam))
            .padding(bottom = 30.dp) // Padding para que el carrusel no cubra la parte superior
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Texto "RECOMMENDED BASES ON THE GAMES YOU PLAY"
            Text(
                text = "RECOMMENDED BASED ON THE GAMES YOU PLAY",
                modifier = Modifier
                    .padding(start = 30.dp, top = 20.dp)
                    .fillMaxWidth(),
                color = Color.White,
                fontSize = 15.sp,
                maxLines = 1,
                overflow = TextOverflow.Clip
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 30.dp)
            ) {
                Spacer(modifier = Modifier.weight(1f)) // Espacio entre el texto y el ícono
                Text(
                    text = "More ",
                    fontSize = 10.sp,
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                IconButton(
                    onClick = { showModal = true },
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = "More",
                        tint = Color.Gray
                    )
                }
            }
        }

        // Carrusel
        HorizontalPager(
            state = pagerState,
            pageSpacing = 16.dp,
            contentPadding = PaddingValues(start = 32.dp, end = 32.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp) // Deja espacio para el texto y el ícono en la parte superior
        ) { page ->

            Card(
                modifier = Modifier
                    .width(400.dp)
                    .height(250.dp)
                    .padding(vertical = 8.dp)
                    .background(colorResource(id = R.color.darkSteam)),
                shape = RectangleShape,
                onClick = {
                    showModal = true
                }
            ) {
                Column {
                    Image(
                        painter = imageList[page % imageList.size],
                        contentDescription = "Carrusel Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        colorResource(id = R.color.darkSteam3),
                                        colorResource(id = R.color.darkSteam4)
                                    )
                                )
                            )
                            .padding(8.dp)
                    ) {
                        Text(
                            text = prices[page % prices.size],
                            fontSize = 15.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }

        // Mostrar el modal si showModal es verdadero
        if (showModal) {
            mensajeModal(
                onDismiss = { showModal = false },
                onConfirm = { showModal = false }
            )
        }
    }
}


@Composable
fun BottomAppBarWithIcons() {
    var showDialog by remember { mutableStateOf(false) }  // Estado para mostrar el modal

    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        containerColor = colorResource(id = R.color.darkSteam)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {
                showDialog = true
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.label),
                    contentDescription = "Home",
                    tint = Color.White
                )
            }
            IconButton(onClick = {  showDialog = true  }) {
                Icon(
                    painter = painterResource(id = R.drawable.news),
                    contentDescription = "News",
                    tint = Color.White
                )
            }
            IconButton(onClick = {  showDialog = true  }) {
                Icon(
                    painter = painterResource(id = R.drawable.shield),
                    contentDescription = "Shield",
                    tint = Color.White
                )
            }
            IconButton(onClick = {  showDialog = true  }) {
                Icon(
                    painter = painterResource(id = R.drawable.noti),
                    contentDescription = "Notifications",
                    tint = Color.White
                )
            }
            IconButton(onClick = {  showDialog = true  }) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }
        }
    }

    // Mostrar modal si showDialog es true
    if (showDialog) {
        mensajeModal(
            onDismiss = { showDialog = false },  // Cerrar modal
            onConfirm = { showDialog = false }   // Confirmar y cerrar modal
        )
    }
}

@Composable
fun mensajeModal(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,

        title = {
            Text(text = "LO SENTIMOS!!!")  // Título
        },
        text = {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.error),  // Imagen
                    contentDescription = "Imagen para mostrar en caso de error",
                    modifier = Modifier.fillMaxWidth() )

                Spacer(modifier = Modifier.height(16.dp))
                Text("Este servicio no esta disponible de momento intenta mas tarde",
                    fontSize = 17.sp)  // Texto
            }
        },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text("Aceptar",
                    fontSize = 20.sp)
            }
        }
    )
}





