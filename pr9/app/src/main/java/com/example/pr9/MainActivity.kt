package com.example.pr9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComponent()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyComponent() {
    Column {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .padding(16.dp)
                .border(2.dp, Color.Red)
                .fillMaxWidth()
        ) {
            Text(
                text = "Смольников Н.С.",
                color = Color.White,
                fontSize = 40.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Box(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Blue)
                .border(2.dp, Color.Red)
                .fillMaxWidth()
        ) {
            Text(
                text = "ИКБО-35-22",
                color = Color.White,
                fontSize = 40.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
