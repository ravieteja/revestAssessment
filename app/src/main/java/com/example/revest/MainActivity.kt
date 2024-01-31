package com.example.revest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import com.example.revest.ui.theme.RevestSampleTheme
import com.example.revest.utils.SetupNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            RevestSampleTheme {
                Surface(modifier = Modifier.fillMaxSize(),color = colorResource(id = R.color.white)) {
                    SetupNavigation(navController)
                }
            }
        }
    }
}
