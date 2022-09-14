package com.atw.jetpackcompose.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atw.jetpackcompose.R
import com.atw.jetpackcompose.presentation.MainViewModel
import com.atw.jetpackcompose.presentation.onClick

@Composable
fun GreetUserTextField(mainViewModel: MainViewModel) {
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
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black, fontSize = 20.sp,
                            fontFamily = FontFamily(
                                Font(R.font.font_bold, FontWeight.Bold)
                            )
                        )
                    ) {
                        append("W")
                    }
                    append("elcome New User")
                },
                style = TextStyle(
                    color = Color.DarkGray, fontSize = 15.sp, fontFamily = FontFamily(
                        Font(R.font.font_regular, FontWeight.Medium)
                    )
                )
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
