package com.example.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import com.example.counter.ui.theme.CounterTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Button

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CounterTheme {
                CounterApp(
                    name = "World"
                )
            }
        }
    }
}

@Composable
fun CounterApp(name: String) {
    /* remember = keep value during recomposition,
    mutableState = redraw when value changes */

    var count by remember { mutableIntStateOf(0) }

    Column {

        Text(
            text = "Count: $count"
        )

        Button(
            onClick = {
                count++
            }
        ) {
            Text("Hello $name, click me!")
        }
    }
}
