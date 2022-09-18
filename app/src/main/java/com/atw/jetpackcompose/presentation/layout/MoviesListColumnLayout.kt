package com.atw.jetpackcompose.presentation.layout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atw.jetpackcompose.domain.model.Movies
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.SizeMode

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun MoviesListColumnLayout( listMovies: List<Movies>) {

    Box(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        FlowColumn(
            mainAxisSize = SizeMode.Wrap,
            mainAxisAlignment = FlowMainAxisAlignment.SpaceEvenly,
        ) {
            listMovies.forEachIndexed { i, movie ->
                Card(
                    shape = RoundedCornerShape(10.dp),
                    elevation = 5.dp,
                    modifier = Modifier
                        .width(LocalConfiguration.current.screenWidthDp.dp / 1)
                        .padding(10.dp)

                ) {
                    Box {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = if (movie.isSelected == true) Color.Black else Color.Gray)
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