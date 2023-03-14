package com.sumin.composeanimations.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimateContent() {

    var isFirstScreenLaunched by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { isFirstScreenLaunched = !isFirstScreenLaunched }
        ) {
            Text(text = "Switch screens")
        }
        if (isFirstScreenLaunched) {
            Screen1()
        } else {
            Screen2()
        }
    }
}

@Composable
private fun Screen1() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    )
}

@Composable
private fun Screen2() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    )
}
