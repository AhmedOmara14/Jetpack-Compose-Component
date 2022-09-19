package com.atw.jetpackcompose.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atw.jetpackcompose.R

@Composable
fun Button() {
    Row {
        androidx.compose.material.Button(onClick = { /*TODO*/ }) {
            Text(text = "Button", modifier = Modifier.padding(3.dp))
        }
        Spacer(modifier = Modifier.width(10.dp))
        androidx.compose.material.Button(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Check",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Submit")
        }
        Spacer(modifier = Modifier.width(10.dp))
        androidx.compose.material.Button(
            onClick = {/*TODO*/ },
            shape = CutCornerShape(10)
        ) {
            Text(text = "Cut Button", modifier = Modifier.padding(3.dp))
        }
    }
    Spacer(
        modifier = Modifier
            .height(10.dp)
            .fillMaxWidth()
    )
    androidx.compose.material.Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth(),
        border = BorderStroke(1.dp, Color.Red),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = colorResource(id = R.color.purple_700))
    ) {
        Text(
            text = "Button",
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(5.dp)
        )
    }
}