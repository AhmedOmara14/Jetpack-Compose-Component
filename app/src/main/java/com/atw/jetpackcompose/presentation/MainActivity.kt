package com.atw.jetpackcompose.presentation

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.atw.jetpackcompose.R
import com.atw.jetpackcompose.domain.model.Movies

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(topBar = {
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
