package com.vorkka.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.vorkka.myapplication.model.Receta
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecetasViewModel : ViewModel() {

    private val _recetas = MutableStateFlow(
        listOf(
            Receta(
                id = 1,
                nombre = "Hamburguesa",
                descripcion = "Deliciosa hamburguesa clásica con carne de res, queso cheddar, lechuga y tomate.",
                emoji = "🍔",
                imagenUrl = "https://imgs.search.brave.com/xX5nDYNMp2ABgy0ULd5KsS4DM4QRnaT-56gvjgvbuFA/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5pc3RvY2twaG90/by5jb20vaWQvMjA2/MTcxNjcwOS9lcy9m/b3RvL2hhbWJ1cmd1/ZXNhLWRlLWNvc3Rp/bGxhLWEtbGEtcGxh/bmNoYS5qcGc_cz02/MTJ4NjEyJnc9MCZr/PTIwJmM9bEQ2V3VM/eElKMjZ4bTJjbVNT/UVh3R19wSzRXSEN2/OEhaM1lqLXFDREVX/RT0",
                ingredientes = listOf(
                    "200g de carne de res molida",
                    "1 pan de hamburguesa con ajonjolí",
                    "1 rebanada de queso cheddar",
                    "Hojas de lechuga fresca y rodajas de tomate",
                    "Salsas (Ketchup y mayonesa) al gusto"
                ),
                preparacion = listOf(
                    "Moldea la carne y cocínala a la plancha al término deseado.",
                    "Coloca el queso cheddar sobre la carne un minuto antes de sacarla para que se derrita.",
                    "Tuesta ligeramente las caras internas del pan en la misma plancha.",
                    "Arma la hamburguesa colocando una base de salsas, la carne con queso, el tomate y la lechuga.",
                    "¡Cierra con la tapa superior del pan y sirve caliente!"
                )
            ),
            Receta(
                id = 2,
                nombre = "Hotdogs",
                descripcion = "Hotdog tradicional con salchicha, mostaza, ketchup y cebolla picada.",
                emoji = "🌭",
                imagenUrl = "https://imgs.search.brave.com/hMNNwXxLeokYN5Dw_8YAwLZTTt3gTgCryq7kDFJFy24/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5pc3RvY2twaG90/by5jb20vaWQvMTI2/NjIwMzkzNC9waG90/by9mYW5jeS1ncmls/bGVkLWhvdGRvZy5q/cGc_cz02MTJ4NjEy/Jnc9MCZrPTIwJmM9/eUdKTGJjX0R6ZUFv/bjViSW90Q0ZqcjVQ/YVJOVTRJTDdFSXZr/bmpxazNmND0",
                ingredientes = listOf(
                    "Salchichas para hotdog de pavo o res",
                    "Panes alargados para hotdog (medias noches)",
                    "Media cebolla picada en cubos finos",
                    "Mostaza y ketchup"
                ),
                preparacion = listOf(
                    "Calienta las salchichas en agua hirviendo durante 5 minutos o dóralas a la plancha.",
                    "Calienta los panes al vapor para que queden muy suaves.",
                    "Abre el pan e introduce la salchicha caliente.",
                    "Agrega la cebolla picada uniformemente sobre la salchicha.",
                    "Corona con líneas de ketchup y mostaza al gusto."
                )
            ),
            Receta(
                id = 3,
                nombre = "Tacos",
                descripcion = "Deliciosos tacos al pastor con piña, cilantro, cebolla y su salsita.",
                emoji = "🌮",
                imagenUrl = "https://imgs.search.brave.com/lhNzKVhTwR01Ktoj8IPIlw-pvrsLeax6WVc5zMABll8/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9zdGF0/aWMudmVjdGVlenku/Y29tL3N5c3RlbS9y/ZXNvdXJjZXMvdGh1/bWJuYWlscy8wNzEv/NDU5LzEwNS9zbWFs/bC9hdXRoZW50aWMt/bWV4aWNhbi1zdHJl/ZXQtdGFjb3Mtd2l0/aC1waW5lYXBwbGUt/YW5kLWxpbWUtY2xv/c2UtdXAtZnJlZS1w/aG90by5qcGc",
                ingredientes = listOf(
                    "Tortillas de maíz pequeñas (taqueras)",
                    "300g de carne de cerdo marinada al pastor",
                    "Cilantro y cebolla finamente picados",
                    "Trozos de piña fresca",
                    "Salsa verde o roja picante y limones"
                ),
                preparacion = listOf(
                    "Cocina la carne al pastor en una sartén muy caliente hasta que quede doradita.",
                    "En la misma grasa de la carne, dale una pasada rápida a los trozos de piña.",
                    "Calienta las tortillas de maíz en un comal.",
                    "Sirve una buena porción de carne sobre un par de tortillas.",
                    "Decora con la piña, el cilantro, la cebolla y acompaña con limones y salsa al gusto."
                )
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