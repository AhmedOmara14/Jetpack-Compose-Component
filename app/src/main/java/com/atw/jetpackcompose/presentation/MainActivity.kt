package com.atw.jetpackcompose.presentation

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atw.jetpackcompose.R
import com.atw.jetpackcompose.domain.model.Movies
import com.atw.jetpackcompose.presentation.animation.DropDown
import com.atw.jetpackcompose.presentation.animation.ProgressLoading
import com.atw.jetpackcompose.presentation.animation.ShimmerLoading
import com.atw.jetpackcompose.presentation.component.GreetUserTextField
import com.atw.jetpackcompose.presentation.layout.MoviesGridLayout
import com.atw.jetpackcompose.presentation.layout.MoviesListLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ListView
            /**Scaffold(topBar = {
            TopAppBar(
            title = {
            Text(text = "ListView",color= Color.White)
            },
            modifier = Modifier.background(Color(R.color.purple_700))
            )
            }) {
            Column {
            //List Movies in Row Layout(Recycler Layout)
            SetDataInList()
            //List Movies in Vertical Layout(Grid Layout)
            Spacer(modifier = Modifier.height(10.dp))
            SetDataInGrid()
            }
            }**/

            //Constrain Layout
            /** ConstraintLayout()**/

            //Animation
            Scaffold(topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Animation", color = Color.White)
                    },
                    modifier = Modifier.background(Color(R.color.purple_700))
                )
            }) {
                Column {
                    ShimmerLoading()
                    Spacer(modifier = Modifier.height(10.dp))
                    DropDown(
                        title = "Drop Down",
                        modifier = Modifier.padding(15.dp)
                    ) {
                        Text(
                            text = "Drop Down Animation", style = TextStyle(color = Color.White, fontSize = 18.sp),
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
                    Spacer(modifier = Modifier.height(10.dp))

                    ProgressLoading()

                }
            }

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

    MoviesListLayout(listMovies = listMovies)
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
fun SetComposableState(mainViewModel: MainViewModel) {
    GreetUserTextField(mainViewModel)
}

fun onClick(context: Context, mainViewModel: MainViewModel) {
    Toast.makeText(context, "Hello ${mainViewModel.textFieldState.value}", Toast.LENGTH_LONG).show()
}
