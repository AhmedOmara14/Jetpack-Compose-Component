package com.atw.jetpackcompose.presentation.layout

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atw.jetpackcompose.domain.model.Movies
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.flowlayout.SizeMode

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesGridLayout(listMovies: List<Movies>) {
    Box(modifier = Modifier
        .fillMaxWidth()) {
        FlowRow(
            mainAxisAlignment = MainAxisAlignment.Center,
            mainAxisSize = SizeMode.Wrap,
            crossAxisSpacing = 3.dp,
            mainAxisSpacing = 3.dp
        ) {
            listMovies.forEachIndexed { _, movie ->
                Card(
                    shape = RoundedCornerShape(10.dp),
                    elevation = 5.dp,
                    modifier = Modifier
                        .size( ((LocalConfiguration.current.smallestScreenWidthDp.dp)-10.dp) / 2)
                ) {
                    Box {
                        Image(
                            painter = painterResource(id = movie.movieImage),
                            contentDescription = movie.movieName,
                            contentScale = ContentScale.FillBounds, modifier = Modifier
                                .size(LocalConfiguration.current.screenWidthDp.dp / 2)
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
                                text = movie.movieName,
                                style = TextStyle(
                                    color = Color.White, fontSize = 18.sp
                                )
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = movie.movieDes,
                                style = TextStyle(color = Color.White, fontSize = 15.sp)
                            )
                        }

                    }

                }
            }
        }
    }
}