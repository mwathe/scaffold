package com.alan.myapplication2.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

@Composable
fun  ProfileScreen(){
    Box(
        modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "Profile Screen",
            fontFamily = FontFamily.Serif,
            fontSize = 22.sp
        )
    }
}