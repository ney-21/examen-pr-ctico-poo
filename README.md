# 🧨 Buscaminas - Juego en Consola

Este proyecto implementa el clásico juego **Buscaminas** utilizando **Java**, siguiendo los principios de **Programación Orientada a Objetos (POO)** y el patrón **MVC**. El juego se ejecuta completamente por consola y permite guardar y cargar partidas.

---

## 🎯 Objetivo

- Simular el juego Buscaminas desde consola
- Usar clases bien estructuradas (POO)
- Aplicar excepciones personalizadas
- Utilizar archivos binarios para persistencia
- Implementar pruebas con JUnit 5

---

## ⚙️ Tecnologías utilizadas

- Java 8 o superior
- JUnit 5
- Eclipse IDE (o cualquier otro)
- PlantUML (para el diagrama UML)

---

## 📁 Estructura del proyecto

src/
├── app/
│ └── App.java
├── controlador/
│ └── Controlador.java
├── excepciones/
│ ├── CasillaFueraDeRangoException.java
│ └── CasillaYaDescubiertaException.java
├── modelo/
│ ├── Casilla.java
│ ├── Tablero.java
│ └── Jugador.java
├── persistencia/
│ ├── GestorArchivos.java
│ └── JuegoGuardado.java
└── vista/
└── VistaConsola.java

test/
└── test/
├── CasillaTest.java
└── TableroTest.java

---

## 🛠️ Instalación

1. Clona este repositorio:

```bash
git clone https://github.com/ney-21/examen-pr-ctico-poo.git
Ábrelo en Eclipse (File > Import > Existing Project).

Ejecuta la clase App.java.

▶️ Cómo jugar
Al iniciar, ingresa tu nombre.

Se mostrará el tablero.

Ingresa una coordenada (ej. C4) y elige una acción:


D = Descubrir casilla
M = Marcar como mina
G = Guardar partida
C = Cargar partida
Ejemplo:

Ingrese coordenada (ej. B4): D5
Acción (D = descubrir, M = marcar, G = guardar, C = cargar): D
💾 Guardar y Cargar partidas
Puedes guardar el progreso en cualquier momento con G, y volver a cargarlo luego con C. El sistema guarda también tu nombre y el estado completo del tablero.

📸 Ejemplo de ejecución

Ingrese su nombre: Carlos
   A  B  C  D
 1 - - - -
 2 - - - -
 3 - - - -
Ingrese coordenada: C2
Acción: D
✅ Descubriste la casilla correctamente.

Acción: G
✅ Partida guardada.
🧪 Pruebas Unitarias
Este proyecto incluye pruebas con JUnit 5 para:

CasillaTest.java

TableroTest.java

Para ejecutarlas:

Click derecho en la clase → Run As → JUnit Test

📌 Autor
Sneider Villamar Peñafiel