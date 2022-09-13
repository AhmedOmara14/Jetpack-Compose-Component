package com.atw.jetpackcompose.presentation

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.atw.jetpackcompose.R

class MainActivity : ComponentActivity() {
    private var mainViewModel: MainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.office)
            Box(modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(0.5f)) {
                ImageCard(
                    painter = painter,
                    contentDes = "The Office ( Tv Series )",
                    title = "The Office"
                )
            }
        }
    }
}

@Composable
fun SetComposableState(mainViewModel: MainViewModel) {
    GreetUserTextField(mainViewModel)
}

fun onClick(context: Context, mainViewModel: MainViewModel) {
    Toast.makeText(context, "Hello ${mainViewModel.textFieldState.value}", Toast.LENGTH_LONG).show()
}
