package com.vorkka.myapplication.model

data class Receta(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val emoji: String,
    val imagenUrl: String,
    val ingredientes: List<String>,
    val preparacion: List<String>
)