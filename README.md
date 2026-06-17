# 🍔 App de Recetas

Esta aplicación es el resultado práctico de la **Unidad 4: Navegación y Arquitectura**.
---

## 📱 Funcionamiento de la App

<p align="center">
  <img width="250" alt="vid_unidad4_borja" src="https://github.com/user-attachments/assets/19773cfb-77b1-4367-9b7f-ae9da5ce4124" />
</p>

---

## 🚀 Características Principales

* **Listado Dinámico Visual:** Muestra una colección de platillos.
* **Navegación Moderna:** Implementación de rutas y paso de argumentos utilizando el componente de navegación de Jetpack Compose.
* **Barra Superior Dinámica (TopAppBar):** El título de la aplicación cambia automáticamente dependiendo de la ruta actual ("Lista de Recetas" o "Detalle de Receta").
* **Gestión de Estado Robusta:** Uso de la arquitectura recomendada para Android mediante `ViewModel` y `StateFlow`, garantizando que el estado sobreviva a la rotación del dispositivo.
* **Carga Asíncrona de Imágenes:** Integración de la librería Coil para descargar y mostrar fotografías de alta calidad desde internet.
* **Diseño Adaptable (Edge-to-Edge):** Interfaz limpia que respeta los márgenes del sistema (notch, barra de estado y navegación) mediante la implementación del componente `Scaffold`.

---

## 🛠️ Tecnologías y Arquitectura

El proyecto está estructurado separando las responsabilidades de la vista, la navegación y la lógica de estado.

| Tecnología / Concepto | Propósito en la App |
| :--- | :--- |
| **Jetpack Compose** | Construcción de la interfaz gráfica 100% declarativa. |
| **Navigation Compose** | Gestión del `NavHost` y rutas para la transición entre la pantalla de inicio y el detalle. |
| **ViewModel & StateFlow** | Aislamiento de la lógica de negocio y mantenimiento del estado independiente del ciclo de vida de la UI. |
| **Coil (AsyncImage)** | Carga eficiente de imágenes en red directamente en componentes Compose. |
| **Scaffold & TopAppBar** | Componentes de Material Design 3 que proveen estructura, márgenes seguros (`paddingValues`) y barras de navegación. |
| **LazyColumn & VerticalScroll** | Renderizado eficiente de la lista y habilitación de desplazamiento para pantallas de detalle extensas. |

---

## 📂 Estructura del Proyecto

El código está organizado modularmente para facilitar su mantenimiento y escalabilidad.

* [`model/`](app/src/main/java/com/vorkka/myapplication/model/): Contiene la estructura de datos extendida ([`Receta.kt`](app/src/main/java/com/vorkka/myapplication/model/Receta.kt) con ingredientes, pasos e imágenes).

* [`viewmodel/`](app/src/main/java/com/vorkka/myapplication/viewmodel/): Contiene la lógica de estado y la fuente de datos local ([`RecetasViewModel.kt`](app/src/main/java/com/vorkka/myapplication/viewmodel/RecetasViewModel.kt)).

* [`ui.screens/`](app/src/main/java/com/vorkka/myapplication/ui/screens/): Contiene los Composables de las vistas principales ([`Pantallas.kt`](app/src/main/java/com/vorkka/myapplication/ui/screens/Pantallas.kt)).

* [`navigation/`](app/src/main/java/com/vorkka/myapplication/navigation/): Define las rutas, la barra superior dinámica y el controlador ([`AppNavegacion.kt`](app/src/main/java/com/vorkka/myapplication/navigation/AppNavegacion.kt)).

* [`ui.theme/`](app/src/main/java/com/vorkka/myapplication/ui/theme/): Configuración de tokens de color y tipografía de Material 3.
