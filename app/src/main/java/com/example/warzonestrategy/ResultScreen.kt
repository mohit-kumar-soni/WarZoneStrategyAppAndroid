package com.example.warzonestrategy


import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ResultScreen(win: Boolean) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            if (win) "🎉 You Won the Battle!"
            else "💀 You Lost!",fontSize = 20.sp
        )
    }
}
