# 🍔 App de Recetas

Esta aplicación es el resultado práctico de la **Unidad 4: Navegación y Arquitectura**. Es una app nativa para Android construida de forma declarativa que muestra un catálogo interactivo de recetas, permitiendo la navegación fluida entre una lista principal y una vista de detalles.

---

## 🚀 Características Principales

* **Listado Dinámico:** Muestra una colección de platillos (Hamburguesa, Hotdogs, Papas a la francesa) renderizados de forma eficiente.
* **Navegación Moderna:** Implementación de rutas y paso de argumentos utilizando el componente de navegación de Jetpack Compose.
* **Gestión de Estado Robusta:** Uso de la arquitectura recomendada para Android, garantizando que el estado de la aplicación sobreviva a la rotación del dispositivo.
* **Diseño Adaptable (Edge-to-Edge):** Interfaz limpia que respeta los márgenes del sistema (notch, barra de estado y navegación) mediante la implementación de layouts modernos.

---

## 🛠️ Tecnologías y Arquitectura

El proyecto está estructurado separando las responsabilidades de la vista, la navegación y la lógica de estado.

| Tecnología / Concepto | Propósito en la App |
| :--- | :--- |
| **Jetpack Compose** | Construcción de la interfaz gráfica 100% declarativa (reemplazando el antiguo sistema de XML). |
| **Navigation Compose** | Gestión del `NavHost` y rutas para la transición entre la pantalla `Home` y `Detail`. |
| **ViewModel & StateFlow** | Aislamiento de la lógica de negocio y mantenimiento del estado (receta seleccionada) independiente del ciclo de vida de la UI. |
| **Scaffold** | Componente de Material Design 3 que provee `paddingValues` para adaptar la interfaz a los recortes de la cámara y la barra de sistema. |
| **LazyColumn** | Renderizado altamente eficiente de la lista de elementos en pantalla. |

---

## 📂 Estructura del Proyecto

El código está organizado modularmente para facilitar su mantenimiento y escalabilidad:

* `model/`: Contiene la estructura de datos (`Receta.kt`).
* `viewmodel/`: Contiene la lógica de estado (`RecetasViewModel.kt`).
* `ui.screens/`: Contiene los Composables de las vistas (`Pantallas.kt`).
* `navigation/`: Define las rutas y el controlador (`AppNavegacion.kt`).
* `ui.theme/`: Configuración de tokens de color y tipografía de Material 3.

---

## 📱 Cómo ejecutar el proyecto

1. Clona este repositorio en tu máquina local.
2. Abre el proyecto utilizando **Android Studio** (versión recomendada: Hedgehog o superior).
3. Sincroniza los archivos de Gradle.
4. Conecta un dispositivo físico mediante USB (con la depuración USB habilitada) o inicia un Emulador (AVD).
5. Presiona el botón **Run** (Shift + F10) para compilar e instalar la aplicación.
