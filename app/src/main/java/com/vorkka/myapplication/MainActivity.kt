package com.vorkka.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.vorkka.myapplication.navigation.AppNavegacion
import com.vorkka.myapplication.ui.theme.NavigationAndArchitectureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationAndArchitectureTheme {
                AppNavegacion()
            }
        }
    }
}