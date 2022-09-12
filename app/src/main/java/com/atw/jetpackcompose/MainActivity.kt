package com.atw.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atw.jetpackcompose.ui.theme.JetpackComposeComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetComposableState()
        }
    }
}

@Composable
fun SetComposableState() {
    val textFieldState = remember {
        mutableStateOf("")
    }
    GreetUser(textFieldState)
}

@Composable
fun GreetUser(currentValue: MutableState<String>) {
    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.welcome_user),
                color = Color.Black,
                style = TextStyle(fontSize = 15.sp)
            )
            OutlinedTextField(
                value = currentValue.value,
                modifier = Modifier.padding(0.dp, 5.dp, 0.dp, 0.dp),
                onValueChange = { currentValue.value = it },
                label = { Text(stringResource(R.string.enter_your_name)) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeComponentTheme {
        SetComposableState()
    }
}