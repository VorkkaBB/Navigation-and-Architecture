package com.vorkka.myapplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vorkka.myapplication.viewmodel.RecetasViewModel

@Composable
fun ListaRecetasScreen(
    viewModel: RecetasViewModel,
    onRecetaClick: (Int) -> Unit
) {
    val recetas by viewModel.recetas.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(recetas) { receta ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onRecetaClick(receta.id) }
            ) {
                Text(
                    text = receta.nombre,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}

@Composable
fun DetalleRecetaScreen(viewModel: RecetasViewModel) {
    val receta by viewModel.recetaSeleccionada.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        receta?.let {
            Text(text = it.nombre, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = it.descripcion, style = MaterialTheme.typography.bodyLarge)
        } ?: run {
            Text(text = "Receta no encontrada", style = MaterialTheme.typography.bodyLarge)
        }
    }
}