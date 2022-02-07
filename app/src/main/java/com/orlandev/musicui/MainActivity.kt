package com.orlandev.musicui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orlandev.musicui.ui.theme.MusicUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MusicPlayerHome()
                }
            }
        }
    }
}


@Composable
fun MusicPlayerHome() {
    val favorite = rememberSaveable { mutableStateOf(false) }
    Scaffold(backgroundColor = Color.Transparent,modifier = Modifier.fillMaxSize().padding(bottom = 10.dp), bottomBar = {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    tint = Color.White,
                    painter = painterResource(id = R.drawable.ic_baseline_bookmark_border_24),
                    contentDescription = null
                )
            }
            IconButton(
                onClick = {}
            ) {
                Icon(
                    tint = Color.White,
                    painter = painterResource(id = R.drawable.ic_baseline_save_alt_24),
                    contentDescription = null
                )
            }
            IconButton(
                onClick = { favorite.value = !favorite.value }
            ) {
                Icon(
                    tint = Color.White,
                    painter = painterResource(id = if (!favorite.value) R.drawable.ic_baseline_favorite_border_24 else R.drawable.ic_baseline_favorite_24),
                    contentDescription = null
                )
            }
            IconButton(
                onClick = {}
            ) {

                Icon(
                    tint = Color.White,
                    painter = painterResource(id = R.drawable.ic_baseline_search_24),
                    contentDescription = null
                )
            }
        }
    }) {

    }
}

@Composable
fun MusicPlayerContainer(content: @Composable () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize().blur(10.dp),
            painter = painterResource(id = R.drawable.music_background),
            contentDescription = "Music Player",
            contentScale = ContentScale.Crop
        )
        content()
    }
}


@Preview(showBackground = true)
@Composable
fun MusicPlayerHomePreview() {
    MusicUITheme {
        MusicPlayerContainer {
            MusicPlayerHome()
        }
    }
}