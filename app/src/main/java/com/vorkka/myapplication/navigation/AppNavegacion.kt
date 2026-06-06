package com.vorkka.myapplication.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vorkka.myapplication.ui.screens.DetalleRecetaScreen
import com.vorkka.myapplication.ui.screens.ListaRecetasScreen
import com.vorkka.myapplication.viewmodel.RecetasViewModel

@Composable
fun AppNavegacion() {
    val navController = rememberNavController()
    val viewModel: RecetasViewModel = viewModel()

    Scaffold { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = "Home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("Home") {
                ListaRecetasScreen(
                    viewModel = viewModel,
                    onRecetaClick = { id ->
                        viewModel.seleccionarReceta(id)
                        navController.navigate("Detail/$id")
                    }
                )
            }
            composable(
                route = "Detail/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) {
                DetalleRecetaScreen(viewModel = viewModel)
            }
        }
    }
}