package com.example.madworkshop5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreenShow(
    modifier: Modifier = Modifier,
    onOpenFirstScreen: () -> Unit,
    onOpenSecondScreen: () -> Unit,
    onOpenThirdScreen: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Welcome to Nav3",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.size(30.dp))
        Button(
            onClick = onOpenFirstScreen,
            shape = ButtonDefaults.elevatedShape
        ) {
            Text(
                " ==> FIRST ",
                fontSize = 20.sp,
            )
        }

        Spacer(modifier = Modifier.size(30.dp))
        Button(
            onClick = onOpenSecondScreen,
            shape = ButtonDefaults.elevatedShape
        ) {
            Text(
                " ==> SECOND",
                fontSize = 20.sp,
            )
        }

        Spacer(modifier = Modifier.size(30.dp))
        Button(
            onClick = onOpenThirdScreen,
            shape = ButtonDefaults.elevatedShape
        ) {
            Text(
                " ==> THIRD",
                fontSize = 20.sp,
            )
        }
    }
}
