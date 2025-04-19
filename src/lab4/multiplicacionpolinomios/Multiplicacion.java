
package lab4.multiplicacionpolinomios;

import ListaEnlazada.ListaEnlazada;
import ListaEnlazada.Nodo;

public class Multiplicacion {
    public ListaEnlazada multiplicar(ListaEnlazada a, ListaEnlazada b) {
        ListaEnlazada resultado = new ListaEnlazada();
        multiplicarRec(a.getPrimero(), b.getPrimero(), resultado, b);
        return resultado;
    }
    
    private void multiplicarRec(Nodo actualA, Nodo actualB, ListaEnlazada resultado, ListaEnlazada polinomioB) {
        if (actualA == null) {
            return;
        }
        if (actualB == null) {
            multiplicarRec(actualA.getSiguiente(), polinomioB.getPrimero(), resultado, polinomioB);
            return;
        }
        int nuevoCoef = actualA.getCoeficiente() * actualB.getCoeficiente();
        int nuevoExp = actualA.getExponente() + actualB.getExponente();
        
        agregarTermino(resultado, nuevoCoef, nuevoExp);
        multiplicarRec(actualA, actualB.getSiguiente(), resultado, polinomioB);
    }
    
    private void agregarTermino(ListaEnlazada resultado, int coef, int exp) {
        if (coef == 0) {
            return;
        }

        Nodo actual = resultado.getPrimero();
        Nodo anterior = null;
        boolean encontrado = false;

        while (actual != null && actual.getExponente() > exp) {
            anterior = actual;
            actual = actual.getSiguiente();
        }

        if (actual != null && actual.getExponente() == exp) {
            int nuevoCoef = actual.getCoeficiente() + coef;

            if (nuevoCoef == 0) {
                if (anterior == null) {
                    resultado.setPrimero(actual.getSiguiente());
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
            } else {
                actual.setCoeficiente(nuevoCoef);
            }
            return;
        }
        
        Nodo nuevo = new Nodo(coef, exp, actual);

        if (anterior == null) {
            resultado.setPrimero(nuevo);
        } else {
            anterior.setSiguiente(nuevo);
        }
}
}
