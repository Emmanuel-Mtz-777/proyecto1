package com.example.myapplication1.ui.theme.components



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication1.R
import com.example.myapplication1.data.model.PostModel

@Composable
fun PostCard(id: Int, title: String, text: String, image: Painter){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )

    ){
        Text(
            text = "Card Title",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            painter = image,
            contentDescription = "Android Logo",
            contentScale = ContentScale.Crop
        )
        Text(
            text = text,
            fontSize = 10.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}

@Composable
fun PostCardCompact(id: Int, title: String, text: String, image: Painter) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )
    ) {
        Row {
            Image(
                modifier = Modifier
                    .width(60.dp)
                    .height(100.dp)
                    .padding(5.dp),
                painter = image,
                contentDescription = "Cipher logo",
                contentScale = ContentScale.FillBounds
            )
            Column {
                Text(
                    text = title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp)
                )
                Text(
                    text = text,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
        }
    }
}
