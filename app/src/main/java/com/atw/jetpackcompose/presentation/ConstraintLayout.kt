package com.atw.jetpackcompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId

@Composable
fun ConstraintLayout() {
    val constraints= ConstraintSet{
       val greenBox = createRefFor("GREENBOX")
       val redBox = createRefFor("REDBOX")

        constrain(greenBox){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            height = Dimension.value(100.dp)
            width = Dimension.value(100.dp)
        }

        constrain(redBox){
            top.linkTo(greenBox.top)
            start.linkTo(greenBox.end)
            height = Dimension.value(100.dp)
            width = Dimension.value(100.dp)
        }

    }
    androidx.constraintlayout.compose.ConstraintLayout(constraints, modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.background(Color.Green).layoutId("GREENBOX"))
        Box(modifier = Modifier.background(Color.Red).layoutId("REDBOX"))
    }
}