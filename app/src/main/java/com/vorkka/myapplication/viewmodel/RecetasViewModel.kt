package com.vorkka.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.vorkka.myapplication.model.Receta
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecetasViewModel : ViewModel() {
    // Lista de las recetas
    private val _recetas = MutableStateFlow(
        listOf(
            Receta(
                1,
                "Hamburguesa",
                "Deliciosa hamburguesa clásica con carne de res, queso cheddar, lechuga y tomate."
            ),
            Receta(
                2,
                "Hotdogs",
                "Hotdog tradicional con salchicha, mostaza, ketchup y cebolla picada."
            ),
            Receta(
                3,
                "Papas a la francesa",
                "Papas fritas crujientes con un toque de sal, ideales para acompañar."
            )
        )
    )
    val recetas: StateFlow<List<Receta>> = _recetas.asStateFlow()

    private val _recetaSeleccionada = MutableStateFlow<Receta?>(null)
    val recetaSeleccionada: StateFlow<Receta?> = _recetaSeleccionada.asStateFlow()

    fun seleccionarReceta(id: Int) {
        _recetaSeleccionada.value = _recetas.value.find { it.id == id }
    }
}