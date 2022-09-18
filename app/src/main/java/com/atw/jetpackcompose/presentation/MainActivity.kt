package com.atw.jetpackcompose.presentation

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atw.jetpackcompose.R
import com.atw.jetpackcompose.domain.model.Movies
import com.atw.jetpackcompose.presentation.component.GreetUserTextField
import com.atw.jetpackcompose.presentation.layout.MoviesGridLayout
import com.atw.jetpackcompose.presentation.layout.MoviesListColumnLayout
import com.atw.jetpackcompose.presentation.layout.MoviesListRowLayout
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.SizeMode

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ListView
            Scaffold(topBar = {
                TopAppBar(
                    title = {
                        Text(text = "ListView", color = Color.White)
                    },
                    modifier = Modifier.background(Color(R.color.purple_700))
                )
            }) {
                var items by remember {
                    mutableStateOf(
                        (1..20).map {
                            Movies(
                                0,
                                R.drawable.office,
                                "The Office",
                                "The Office Season 9",
                                false
                            )
                        })
                }

                LazyColumn() {

                    item { Spacer(modifier = Modifier.height(10.dp)) }
                    item {
                        Text(
                            text = "Grid Layout",
                            color = Color.Black,
                            modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp),
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontFamily = FontFamily(Font(R.font.font_bold))
                            )
                        )
                    }
                    item { SetDataInGrid() }
                    item { Spacer(modifier = Modifier.height(10.dp)) }
                    item {
                        Text(
                            text = "Recycler Layout - Horizontal",
                            color = Color.Black,
                            modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp),
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontFamily = FontFamily(Font(R.font.font_bold))
                            )
                        )
                    }
                    item { SetDataInList() }
                    item { Spacer(modifier = Modifier.height(10.dp)) }
                    item {
                        Text(
                            text = "Recycler Layout - Vertical",
                            color = Color.Black,
                            modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp),
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontFamily = FontFamily(Font(R.font.font_bold))
                            )
                        )
                    }
                    item {
                        Box(
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxWidth()
                        ) {
                            FlowColumn(
                                mainAxisSize = SizeMode.Wrap,
                                mainAxisAlignment = FlowMainAxisAlignment.SpaceEvenly,
                            ) {
                                items.forEachIndexed { i, movie ->
                                    Card(
                                        shape = RoundedCornerShape(10.dp),
                                        elevation = 5.dp,
                                        modifier = Modifier
                                            .width(LocalConfiguration.current.screenWidthDp.dp / 1)
                                            .padding(10.dp)
                                            .clickable {
                                                items = items.mapIndexed { j, movie ->
                                                    if (i == j) {
                                                        movie.copy(isSelected = !movie.isSelected)
                                                    } else movie
                                                }
                                            }

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
                                                    style = TextStyle(
                                                        color = Color.White,
                                                        fontSize = 15.sp
                                                    )
                                                )
                                            }

                                        }

                                    }
                                }
                            }
                        }
                    }

                }

            }

            /*  Column(
                  Modifier
                      .padding(10.dp, 0.dp, 5.dp, 0.dp)
                      .fillMaxSize()
                      .verticalScroll(rememberScrollState())
              ) {
                  //List Movies in Row Layout(Recycler Layout)
                  Spacer(modifier = Modifier.height(10.dp))
                  Text(
                      text = "RecyclerLayout - Vertical",
                      color = Color.Black,
                      style = TextStyle(
                          fontSize = 22.sp,
                          fontFamily = FontFamily(Font(R.font.font_bold))
                      )
                  )


                  SetDataInList()

                  SetDataInList()

                  SetDataInList()

                  SetDataInList()

                  SetDataInList()

                  SetDataInList()

                  SetDataInList()

                  SetDataInList()

                  SetDataInList()

                  SetDataInList()

                  SetDataInList()

                  SetDataInList()

                  //  SetDataInGrid()

                  Spacer(modifier = Modifier.height(10.dp))
                  Text(
                      text = "RecyclerLayout - Vertical",
                      color = Color.Black,
                      style = TextStyle(
                          fontSize = 22.sp,
                          fontFamily = FontFamily(Font(R.font.font_bold))
                      )
                  )
                  Spacer(modifier = Modifier.height(10.dp))
                  Text(
                      text = "RecyclerLayout - Vertical",
                      color = Color.Black,
                      style = TextStyle(
                          fontSize = 22.sp,
                          fontFamily = FontFamily(Font(R.font.font_bold))
                      )
                  )
                  Spacer(modifier = Modifier.height(10.dp))
                  Text(
                      text = "RecyclerLayout - Vertical",
                      color = Color.Black,
                      style = TextStyle(
                          fontSize = 22.sp,
                          fontFamily = FontFamily(Font(R.font.font_bold))
                      )
                  )
                  Spacer(modifier = Modifier.height(10.dp))
                  Text(
                      text = "RecyclerLayout - Vertical",
                      color = Color.Black,
                      style = TextStyle(
                          fontSize = 22.sp,
                          fontFamily = FontFamily(Font(R.font.font_bold))
                      )
                  )
                  Spacer(modifier = Modifier.height(10.dp))
                  Text(
                      text = "RecyclerLayout - Vertical",
                      color = Color.Black,
                      style = TextStyle(
                          fontSize = 22.sp,
                          fontFamily = FontFamily(Font(R.font.font_bold))
                      )
                  )
                  Spacer(modifier = Modifier.height(10.dp))
                  Text(
                      text = "RecyclerLayout - Vertical",
                      color = Color.Black,
                      style = TextStyle(
                          fontSize = 22.sp,
                          fontFamily = FontFamily(Font(R.font.font_bold))
                      )
                  )
                  Spacer(modifier = Modifier.height(10.dp))
                  Text(
                      text = "RecyclerLayout - Vertical",
                      color = Color.Black,
                      style = TextStyle(
                          fontSize = 22.sp,
                          fontFamily = FontFamily(Font(R.font.font_bold))
                      )
                  )
                  Spacer(modifier = Modifier.height(10.dp))
                  Text(
                      text = "RecyclerLayout - Vertical",
                      color = Color.Black,
                      style = TextStyle(
                          fontSize = 22.sp,
                          fontFamily = FontFamily(Font(R.font.font_bold))
                      )
                  )
                  Spacer(modifier = Modifier.height(10.dp))
                  Text(
                      text = "RecyclerLayout - Vertical",
                      color = Color.Black,
                      style = TextStyle(
                          fontSize = 22.sp,
                          fontFamily = FontFamily(Font(R.font.font_bold))
                      )
                  )
              }*/
        }

        //Constrain Layout
        /** ConstraintLayout()**/

        //Animation
        /**Scaffold(topBar = {
        TopAppBar(
        title = {
        Text(text = "Animation", color = Color.White)
        },
        modifier = Modifier.background(Color(R.color.purple_700))
        )
        }) {
        Column(
        modifier = Modifier
        .verticalScroll(rememberScrollState())
        ) {
        Text(
        text = "Shimmer Loading",
        textAlign = TextAlign.Center,
        modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .wrapContentSize(),
        style = TextStyle(fontSize = 18.sp)
        )
        ShimmerLoading()
        Text(
        text = "Progress Bar",
        textAlign = TextAlign.Center,
        modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .wrapContentSize(),
        style = TextStyle(fontSize = 18.sp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        ProgressLoading()
        Spacer(modifier = Modifier.height(15.dp))
        Text(
        text = "ReSizeImage",
        textAlign = TextAlign.Center,
        modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .wrapContentSize(),
        style = TextStyle(fontSize = 18.sp)
        )
        ReSizeImage()
        Spacer(modifier = Modifier.height(15.dp))
        Text(
        text = "Loading",
        textAlign = TextAlign.Center,
        modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .wrapContentSize(),
        style = TextStyle(fontSize = 18.sp)
        )
        Loading()
        Text(
        text = "Drop Down",
        textAlign = TextAlign.Center,
        modifier = Modifier
        .padding(20.dp)
        .fillMaxWidth()
        .wrapContentSize(),
        style = TextStyle(fontSize = 18.sp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        DropDown(
        title = "Drop Down",
        modifier = Modifier.padding(15.dp)
        ) {
        Text(
        text = "Drop Down Animation",
        style = TextStyle(color = Color.White, fontSize = 18.sp),
        textAlign = TextAlign.Center,
        modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .background(
        MaterialTheme.colors.primary
        )
        .wrapContentHeight()
        )
        }
        }
        }**/

        //Navigation
        /** Navigation()**/

        //BottomNavigation
        /*val navController = rememberNavController()
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Widget", color = Color.White)
                    },
                    modifier = Modifier.background(Color(R.color.purple_700))
                )
            },
            bottomBar = {
                BottomNavigationBar(
                    items = listOf(
                        BottomNavigationItem("Home", "home", Icons.Default.Home),
                        BottomNavigationItem("Chat", "chat", Icons.Default.Notifications, 25),
                        BottomNavigationItem("Setting", "settings", Icons.Default.Settings)
                    ),
                    modifier = Modifier,
                    navController = navController,
                    onItemClick = {
                        navController.navigate(route = it.route)
                    }
                )
            }
        ) {
            com.atw.jetpackcompose.presentation.widget.navigation.Navigation(navHostController = navController)
        }*/
    }

}

@Composable
private fun SetDataInList() {
    val listMovies = ArrayList<Movies>()
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 9", false))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 8", false))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 7", false))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 6", false))

    MoviesListRowLayout(listMovies = listMovies)
}

@Composable
private fun SetDataInGrid() {
    val listMovies = ArrayList<Movies>()
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 9", false))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 8", false))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 7", false))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 6", false))

    MoviesGridLayout(listMovies = listMovies)
}

@Composable
private fun SetDataInListColumn() {
    val listMovies = ArrayList<Movies>()
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 9", false))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 8", true))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 7", false))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 6", false))

    MoviesListColumnLayout(listMovies = listMovies)
}

@Composable
fun SetComposableState(mainViewModel: MainViewModel) {
    GreetUserTextField(mainViewModel)
}

fun onClick(context: Context, mainViewModel: MainViewModel) {
    Toast.makeText(context, "Hello ${mainViewModel.textFieldState.value}", Toast.LENGTH_LONG).show()
}
