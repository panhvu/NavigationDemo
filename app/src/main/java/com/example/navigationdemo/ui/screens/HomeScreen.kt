package com.example.navigationdemo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Home() {
    Text(
        text = "Home",
        modifier = Modifier.fillMaxSize(),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun Chat() {
    Text(
        text = "Chat",
        modifier = Modifier.fillMaxSize(),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun Settings(state: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        Text(
            text = "Settings",
            modifier = Modifier.wrapContentSize(),
            textAlign = TextAlign.Center,
        )
    }
}