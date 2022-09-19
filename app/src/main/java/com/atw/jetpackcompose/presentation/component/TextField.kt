package com.atw.jetpackcompose.presentation.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atw.jetpackcompose.R

@Composable
fun TextField() {
    var text by remember {
        mutableStateOf("")
    }
    Text(
        text = "TextField", fontSize = 23.sp, style = TextStyle(
            color = Color.Black, fontFamily = FontFamily(
                Font(R.font.font_bold)
            )
        )
    )
    Spacer(
        modifier = Modifier
            .height(10.dp)
            .fillMaxWidth()
    )
    OutlinedTextField(
        value = text,
        label = { Text(text = "User Name") },
        onValueChange = { text = it },
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(
        modifier = Modifier
            .height(10.dp)
            .fillMaxWidth()
    )
    androidx.compose.material.TextField(
        value = text,
        label = { Text(text = "User Name") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person",
                tint = colorResource(id = R.color.purple_700)
            )
        },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = {
            text = it
        })

    Spacer(
        modifier = Modifier
            .height(10.dp)
            .fillMaxWidth()
    )
    androidx.compose.material.TextField(
        value = text,
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = {
            text = it
        })
}