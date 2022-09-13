package com.atw.jetpackcompose.presentation

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atw.jetpackcompose.R
import com.atw.jetpackcompose.domain.model.Movies

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                //List Movies in Row Layout(Recycler Layout)
                setDataInList()
                //List Movies in Vertical Layout(Grid Layout)
                Spacer(modifier = Modifier.height(10.dp))
                setDataInGrid()
            }
        }

    }


}

@Composable
private fun setDataInList() {
    val listMovies = ArrayList<Movies>()
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 9"))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 8"))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 7"))
    listMovies.add(Movies(0, R.drawable.office, "The Office", "The Office Season 6"))

    MoviesListLayout(listMovies = listMovies)
}

@Composable
private fun setDataInGrid() {
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
