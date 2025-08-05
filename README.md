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


## 📁 Estructura del proyecto

src/
├── app/
│   └── App.java
├── controlador/
│   └── Controlador.java
├── excepciones/
│   ├── CasillaFueraDeRangoException.java
│   └── CasillaYaDescubiertaException.java
├── modelo/
│   ├── Casilla.java
│   ├── Tablero.java
│   └── Jugador.java
├── persistencia/
│   ├── GestorArchivos.java
│   └── JuegoGuardado.java
└── vista/
    └── VistaConsola.java

test/
└── test/
    ├── CasillaTest.java
    └── TableroTest.java

## 🛠️ Instalación
git clone https://github.com/ney-21/examen-pr-ctico-poo.git
Ábrelo en Eclipse:
File > Import > Existing Project

Ejecuta la clase App.java.

## ▶️ Cómo jugar
Al iniciar, el sistema solicita el nombre del jugador.
Se mostrará el tablero en formato de matriz con coordenadas.
Luego, el jugador debe ingresar una coordenada (ej. C4) y elegir una acción:

D = Descubrir casilla

M = Marcar como mina

G = Guardar partida

C = Cargar partida

## 💬 Ejemplo de ejecución

```plaintext
Ingrese su nombre: Carla
   A  B  C  D
 1 -  -  -  -
 2 -  -  -  -
 3 -  -  -  -
Ingrese coordenada (ej. B4): D5
Acción (D = descubrir, M = marcar, G = guardar, C = cargar): D
✅ Partida guardada.
```

## 🧪 Pruebas Unitarias
Este proyecto incluye pruebas con JUnit 5 para:

CasillaTest.java

TableroTest.java

Para ejecutarlas:

Click derecho sobre la clase → Run As → JUnit Test

## Autor
Sneider Villamar Peñafiel