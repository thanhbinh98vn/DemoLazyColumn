package com.example.columndemo


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.columndemo.ui.theme.ColumnDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnDemoTheme {
                DemoColumn()
            }
        }
    }
}

@Preview
@Composable
fun DemoColumn() {
    var items by remember {
        mutableStateOf(listOf("Kotlin", "Java", "Python", "Go", "C++"))
    }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        items(items = items, key = { it }) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(24.dp)
                ,text = "I like $it")
        }
        item {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            onClick = { items = items.shuffled() }) {
                Text(text = "Rolling")
            }
        }
    }
}



