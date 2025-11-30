# Estudio de Caso 2 – Árbol AVL en Java  
Curso: SOFT-10 Estructuras de Datos  
Estudiante: **Tatiana Solís**

---

## 📘 Descripción del Proyecto

Este repositorio contiene la implementación completa de un **Árbol AVL** en Java, desarrollada como parte del Segundo Estudio de Caso del curso SOFT-10.  
El proyecto incluye:

- Cálculo de **altura** y **factor de balance**
- Rotaciones: **LL**, **RR**, **LR**, **RL**
- Inserción, búsqueda y eliminación de nodos
- Rebalanceo automático del árbol
- Recorrido **en orden**
- Visualización de la estructura del árbol
- Menú interactivo mediante consola

Además, el repositorio incluye un documento PDF con la explicación teórica del funcionamiento de los árboles AVL, ejemplos gráficos, análisis y aplicaciones reales.

---

## 📁 Estructura del Repositorio

EstudioDeCaso2_AVL/
│
├── src/
│ ├── AVL.java
│ ├── Main.java
│ └── NodoAVL.java
│
├── docs/
│ └── EstudioDeCaso2_AVL.pdf
│
├── .gitignore
├── README.md
└── MOODLE_LINK.txt


---

## ⚙️ Funcionalidades Principales

### ✔ Inserción de nodos  
Actualiza alturas, calcula factor de balance y ejecuta la rotación necesaria.

### ✔ Eliminación de nodos  
Elimina correctamente un nodo en las tres posibilidades:
- Nodo hoja
- Nodo con un hijo
- Nodo con dos hijos (usando el sucesor mínimo)

Incluye re–balanceo posterior.

### ✔ Búsqueda  
Búsqueda tradicional de Árbol Binario de Búsqueda (ABB).

### ✔ Recorrido en orden  
Muestra los elementos en orden ascendente.

### ✔ Visualización del árbol  
Incluye alturas y factores de balance.

---

## ▶️ Ejecución del Programa

### 1️⃣ Compilar

```bash
javac src/*.java

2️⃣ Ejecutar
java -cp src Main

📄 Documento de Investigación

En la carpeta docs se incluye el archivo:

EstudioDeCaso2_AVL.pdf


Este documento contiene:

Explicación completa del factor de balance

Cálculo de alturas

Ejemplos visuales del funcionamiento

Rotaciones LL, RR, LR, RL con diagramas

Aplicaciones reales de los árboles AVL

Conclusiones del estudio de caso

🛠️ Tecnologías Utilizadas

Java 8+

Consola / Terminal

Git & GitHub

👩‍💻 Autora

Tatiana Solís
Proyecto académico – Universidad
Segundo Estudio de Caso – SOFT-10

📬 Enlace del Repositorio

https://github.com/tati-ui/EstudioDeCaso2_AVL
