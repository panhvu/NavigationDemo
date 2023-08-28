package com.example.navigationdemo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun WelcomeScreen(
    name: String?,
    onChangeName: (String?) -> Unit,
    onEnter: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        Text(
            text = "Hello $name",
            modifier = Modifier.padding(16.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { onChangeName(name) },
            ) {
                Text(text = "change name")
            }
            Button(
                onClick = { onEnter() },
            ) {
                Text(text = "enter")
            }
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Composable
fun WelcomePreview() {
    WelcomeScreen("Anna", {}, {})
}
