package com.example.myapplication1.ui.theme.components

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ServiceCard(
    id:Int,
    name:String,
    username: String,
    imageUrl: String?,
    onButtonClick: ()->Unit


){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp)
            .background(Color.Black)// Aplica el color de fondo aq
    ) {
      Row(){

          AsyncImage(modifier= Modifier
              .width(80.dp)
              .height(80.dp)
              .padding(10.dp),
              model = imageUrl,
              contentDescription = "ServiceLogo",
              contentScale = ContentScale.FillBounds)
          Column {
              Text(text = name,
                  fontSize = 18.sp,
                  fontWeight = FontWeight.Bold,
                  modifier = Modifier
                      .padding(2.dp, 8.dp, 0.dp,0.dp)
              )
              Text(text = username,
                  fontSize = 15.sp,
                  modifier = Modifier.padding(4.dp,0.dp))

          }
          Row(
              modifier = Modifier
                  .fillMaxWidth()
                  .height(80.dp),
              horizontalArrangement = Arrangement.End,
              verticalAlignment = Alignment.CenterVertically
          ){
              IconButton(
                  modifier = Modifier.padding(20.dp,0.dp,0.dp,0.dp),
                  onClick = { onButtonClick()}) {
                  Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Services details")

              }
          }
      }
    }

}