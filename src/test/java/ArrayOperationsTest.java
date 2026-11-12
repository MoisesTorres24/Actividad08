import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayOperationsTest {
    @Test
    public void testNumZeroCerosDespuesDelPrimerIndice() {
        int[] arrayTest1 = {2, 5, 0, 1, 0};

        // esta prueba sí pasa, debido a que los ceros están después del primer índice
        assertEquals(2, ArrayOperations.numZero(arrayTest1));
    }

    @Test
    public void testNumZeroCeroEnPrimerIndice() {
        int[] arrayTest2 = {0, 5, 0, 1, 0};

        // esta prueba no pasa debido a que la función numZero no toma en cuenta el primer índice
        // realmente hay 3 ceros en el array, pero la función solo cuenta 2
        assertEquals(3, ArrayOperations.numZero(arrayTest2));
    }

    @Test
    public void testNumZeroSinCeros() {
        int[] arraySinCeros = {4, 8, 15, 16, 23, 42};

        // evalúa que devuelva 0 cuando ningún elemento es cero
        assertEquals(0, ArrayOperations.numZero(arraySinCeros));
    }

    @Test
    public void testNumZeroArrayVacio() {
        int[] arrayVacio = {};

        // evalúa el comportamiento de borde cuando el array no tiene elementos
        assertEquals(0, ArrayOperations.numZero(arrayVacio));
    }

    @Test
    public void testNumZeroArrayNulo() {
        int[] arrayNulo = null;

        // verifica que lance la excepcion esperada cuando se pasa null
        assertThrows(NullPointerException.class, () -> {
            ArrayOperations.numZero(arrayNulo);
        });
    }

    @Test
    void testFindLast() {
        int[] arrayTest1 = {2, 3, 5};
        int num = 2;

        // no pasa, porque nunca evalua el indice 1 donde realmente esta el 2
        assertEquals(0, ArrayOperations.findLast(arrayTest1, num));
    }

    @Test
    void testCountPositive() {
        int[] arrayTest1 = {-4, 2, 0, 2};

        // no pasa porque tambien cuenta el cero como positivo
        assertEquals(2, ArrayOperations.countPositive(arrayTest1));
    }


    @Test
    void testLastZero() {
        int[] arrayTest1 = {0, 1, 0};

        // no pasa porque no termina de recorrer el arreglo, se detiene en el primer cero que encuentre
        assertEquals(2, ArrayOperations.lastZero(arrayTest1));
    }

    @Test
    void testOddOrPos() {
        int[] x = {-3, -2, 0, 1, 4};

        // falla porque no cuenta toma en cuenta a -3
        assertEquals(3, ArrayOperations.oddOrPos(x));

    }

}
