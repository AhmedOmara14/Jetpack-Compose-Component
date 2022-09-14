package com.atw.jetpackcompose.presentation.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atw.jetpackcompose.domain.model.Movies

@Composable
fun MoviesListLayout(listMovies: List<Movies>) {
    LazyRow(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)) {
        itemsIndexed(listMovies) { i, movie ->
            Card(
                shape = RoundedCornerShape(10.dp),
                elevation = 5.dp,
                modifier = Modifier
                    .padding(0.dp, 0.dp, 5.dp, 0.dp)
                    .height(200.dp)
                    .width(200.dp)
            ) {
                Box {
                    Image(
                        painter = painterResource(id = movie.movieImage),
                        contentDescription = movie.movieName,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.height(200.dp)
                            .width(200.dp)
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