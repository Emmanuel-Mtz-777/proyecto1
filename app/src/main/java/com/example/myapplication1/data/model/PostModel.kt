package com.example.myapplication1.data.model

import androidx.compose.ui.graphics.painter.Painter

data class PostModel(
    val id:Int,
    var title:String,
    val text:String,
    val image:Painter
)