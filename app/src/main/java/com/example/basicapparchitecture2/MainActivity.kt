package com.example.basicapparchitecture2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.basicapparchitecture2.composables.MovieListComposable
import com.example.basicapparchitecture2.ui.theme.BackgroundColor
import com.example.basicapparchitecture2.viewmodels.MovieViewModel

class MainActivity : ComponentActivity() {
    lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        setContent {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackgroundColor
                ) {
                    MovieListComposable(viewModel = viewModel)

                }
            }

    }
}

