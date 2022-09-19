package com.atw.jetpackcompose.presentation.widget.navigation.screens

import android.widget.Button
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atw.jetpackcompose.R
import com.atw.jetpackcompose.presentation.animation.Loading
import com.atw.jetpackcompose.presentation.animation.ProgressLoading
import com.atw.jetpackcompose.presentation.component.Button

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(10.dp, 10.dp, 10.dp, 0.dp)
    ) {
        Text(
            text = "Widgets", fontSize = 23.sp, style = TextStyle(
                color = Color.Black, fontFamily = FontFamily(
                    Font(R.font.font_bold)
                )
            )
        )
        Text(
            text = "Buttons", fontSize = 23.sp, style = TextStyle(
                color = Color.Black, fontFamily = FontFamily(
                    Font(R.font.font_bold)
                )
            )
        )
        Button()
        Spacer(
            modifier = Modifier
                .height(10.dp)
                .fillMaxWidth()
        )
        com.atw.jetpackcompose.presentation.component.TextField()
        Spacer(
            modifier = Modifier
                .height(10.dp)
                .fillMaxWidth()
        )
        Text(
            text = "UI Cards", fontSize = 23.sp, style = TextStyle(
                color = Color.Black, fontFamily = FontFamily(
                    Font(R.font.font_bold)
                )
            )
        )

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            elevation = 5.dp
        ) {
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.office),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ), startY = 300f
                            )
                        )
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = "The Office",
                        style = TextStyle(
                            color = Color.White, fontSize = 18.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "The Office 9",
                        style = TextStyle(color = Color.White, fontSize = 15.sp)
                    )
                }

            }

        }
        Spacer(
            modifier = Modifier
                .height(10.dp)
                .fillMaxWidth()
        )
        Card(
            shape = RoundedCornerShape(10.dp),
            elevation = 5.dp,
            modifier = Modifier
                .width(LocalConfiguration.current.screenWidthDp.dp / 1)
        ) {
            Box {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Gray)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = "The Office",
                        style = TextStyle(
                            color = Color.White, fontSize = 18.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "movieDes",
                        style = TextStyle(color = Color.White, fontSize = 15.sp)
                    )
                }

            }

        }
        Spacer(
            modifier = Modifier
                .height(10.dp)
                .fillMaxWidth()
        )
        Text(
            text = "ProgressBar", fontSize = 23.sp, style = TextStyle(
                color = Color.Black, fontFamily = FontFamily(
                    Font(R.font.font_bold)
                )
            )
        )
        Loading()
        ProgressLoading()

        Spacer(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
        )

    }
}
