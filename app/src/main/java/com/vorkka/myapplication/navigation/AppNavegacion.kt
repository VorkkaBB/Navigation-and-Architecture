package com.vorkka.myapplication.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vorkka.myapplication.ui.screens.DetalleRecetaScreen
import com.vorkka.myapplication.ui.screens.ListaRecetasScreen
import com.vorkka.myapplication.viewmodel.RecetasViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavegacion() {
    val navController = rememberNavController()
    val viewModel: RecetasViewModel = viewModel()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val rutaActual = navBackStackEntry?.destination?.route

    val tituloPantalla = if (rutaActual?.startsWith("Detail") == true) {
        "Detalle de Receta"
    } else {
        "Lista de Recetas"
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = tituloPantalla) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->

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