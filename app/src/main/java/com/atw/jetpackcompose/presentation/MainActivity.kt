package com.atw.jetpackcompose.presentation

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atw.jetpackcompose.R
import com.atw.jetpackcompose.domain.model.Movies
import com.atw.jetpackcompose.presentation.component.GreetUserTextField
import com.atw.jetpackcompose.presentation.layout.MoviesGridLayout
import com.atw.jetpackcompose.presentation.layout.MoviesListColumnLayout
import com.atw.jetpackcompose.presentation.layout.MoviesListRowLayout

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
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    item { Spacer(modifier = Modifier.height(10.dp)) }
                    item {
                        Text(
                            text = "Grid Layout",
                            color = Color.Black,
                            modifier = Modifier.padding(10.dp,0.dp,0.dp,0.dp),
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
                            modifier = Modifier.padding(10.dp,0.dp,0.dp,0.dp),
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
                            modifier = Modifier.padding(10.dp,0.dp,0.dp,0.dp),
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontFamily = FontFamily(Font(R.font.font_bold))
                            )
                        )
                    }
                    item { SetDataInListColumn() }
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

}

@Composable
private fun SetDataInList() {
    val listMovies = ArrayList<Movies>()
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 9"))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 8"))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 7"))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 6"))

    MoviesListRowLayout(listMovies = listMovies)
}

@Composable
private fun SetDataInGrid() {
    val listMovies = ArrayList<Movies>()
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 9"))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 8"))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 7"))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 6"))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 5"))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 4"))

    MoviesGridLayout(listMovies = listMovies)
}

@Composable
private fun SetDataInListColumn() {
    val listMovies = ArrayList<Movies>()
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 9"))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 8"))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 7"))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 6"))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 5"))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 4"))

    MoviesListColumnLayout(listMovies = listMovies)
}

@Composable
fun SetComposableState(mainViewModel: MainViewModel) {
    GreetUserTextField(mainViewModel)
}

fun onClick(context: Context, mainViewModel: MainViewModel) {
    Toast.makeText(context, "Hello ${mainViewModel.textFieldState.value}", Toast.LENGTH_LONG).show()
}
