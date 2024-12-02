package com.example.myapplication1.ui.theme.components

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.myapplication1.R

@Composable
fun ServiceCard(
    id:Int,
    name: String,
    username:String,
    imageURL:String?,
    onButtonClick:()->Unit
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )
    ) {
        Row(
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(80.dp)
                    .padding(10.dp),
                model = imageURL,
                //Cambiar despues
                error = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "Service Logo",
                contentScale = ContentScale.FillBounds
            )
            Column(){
                Text(
                    text = name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(2.dp, 8.dp, 0.dp, 0.dp),
                    color = Color.White
                )
                Text(
                    text = username,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(4.dp, 0.dp),
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(
                    modifier = Modifier.padding(20.dp, 0.dp, 0.dp,0.dp),
                    onClick = { onButtonClick() }){
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "Service details"
                    )

                }

            }
        }
    }

}