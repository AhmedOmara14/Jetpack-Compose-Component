package com.atw.jetpackcompose.presentation

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atw.jetpackcompose.ui.theme.JetpackComposeComponentTheme
import com.atw.jetpackcompose.R

class MainActivity : ComponentActivity() {
    private var mainViewModel: MainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetComposableState(mainViewModel)
        }
    }
}

@Composable
fun SetComposableState(mainViewModel: MainViewModel) {
    GreetUser(mainViewModel)
}

@Composable
fun GreetUser(mainViewModel: MainViewModel) {
    val mContext = LocalContext.current
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
            Spacer(modifier = Modifier.height(10.dp))
            mainViewModel.textFieldState.observeAsState().value?.let {
                TextField(
                    value = it,
                    onValueChange = { mainViewModel.textFieldValueUpdated(it) },
                    label = { Text(stringResource(R.string.enter_your_name)) }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { onClick(mContext, mainViewModel) }) {
                Text(text = "Submit")
            }
        }
    }
}

fun onClick(context: Context, mainViewModel: MainViewModel) {
    Toast.makeText(context, "Hello ${mainViewModel.textFieldState.value}", Toast.LENGTH_LONG).show()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeComponentTheme {
    }
}