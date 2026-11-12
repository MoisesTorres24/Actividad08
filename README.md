# Pruebas Unitarias con JUnit - Actividad 08

## Datos del Alumno
* **Nombre:** Moisés Gerónimo Torres González
* **Matrícula:** S25018144
* **Experiencia Educativa:** Diseño y Programación Orientada a Objetos

---

## Detalle de las Pruebas (`ArrayOperationsTest`)

### 1. `numZero(int[] x)`
Cuenta la cantidad de ceros en un arreglo. El método contiene un error lógico al iniciar el ciclo `for` en el índice `1` en lugar de `0`.

* **`testNumZeroCerosDespuesDelPrimerIndice`**: Esta prueba sí pasa, debido a que los ceros están después del primer índice.
* **`testNumZeroCeroEnPrimerIndice`**: Esta prueba no pasa debido a que la función `numZero` no toma en cuenta el primer índice (realmente hay 3 ceros en el array, pero la función solo cuenta 2).
* **`testNumZeroSinCeros`**: Evalúa que devuelva `0` cuando ningún elemento es cero. *(Pasa)*
* **`testNumZeroArrayVacio`**: Evalúa el comportamiento de borde cuando el array no tiene elementos. *(Pasa)*
* **`testNumZeroArrayNulo`**: Verifica que lance la excepción esperada (`NullPointerException`) cuando se pasa `null`. *(Pasa)*

### 2. `findLast(int[] x, int y)`
Busca el último índice en el que aparece el elemento `y` dentro del arreglo `x`.

* **`testFindLast`**: No pasa, porque nunca evalúa el índice `0` (donde realmente está el `2`), ya que la condición del ciclo es `i > 0` en lugar de `i >= 0`.

### 3. `countPositive(int[] x)`
Cuenta cuántos números positivos existen en el arreglo.

* **`testCountPositive`**: No pasa porque también cuenta el cero como positivo (`x[i] >= 0` en lugar de `x[i] > 0`).

### 4. `lastZero(int[] x)`
Devuelve el índice de la última aparición del número `0` en el arreglo.

* **`testLastZero`**: No pasa porque no termina de recorrer el arreglo; se detiene y retorna en el primer cero que encuentra.

### 5. `oddOrPos(int[] x)`
Cuenta los elementos que son impares o positivos.

* **`testOddOrPos`**: Falla porque no toma en cuenta a `-3`, debido a que en Java el residuo de un número negativo impar es `-1` (`-3 % 2 == -1`), por lo que no cumple la condición `x[i] % 2 == 1`.

---

## Reflexión de la Actividad

### Retos y Aprendizajes
El principal reto fue identificar los errores lógicos ocultos en las funciones originales, ya que a simple vista parecían estar bien escritas, pero fallaban en casos límite o condiciones específicas (como el manejo de índices iniciales `0`, el comportamiento del operador módulo `%` con números negativos en Java o condiciones mal planteadas).

Como aprendizaje, comprendí la importancia de diseñar pruebas unitarias que evalúen no solo el camino normal, sino también los casos borde (arreglos vacíos, nulos o valores en los extremos), así como la utilidad de escribir pruebas independientes y descriptivas en JUnit para aislar exactamente qué escenario está fallando.

### Uso de la Inteligencia Artificial
Utilicé la IA como apoyo para resolver dudas puntuales sobre por qué fallaban ciertas funciones (por ejemplo, el comportamiento del residuo negativo en `oddOrPos`) y para estructurar y redactar este archivo `README.md`. Sin embargo, la identificación inicial de los fallos y el análisis del flujo de ejecución lo realicé apoyándome directamente en el depurador (debugger) del IDE.