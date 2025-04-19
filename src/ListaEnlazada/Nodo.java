
package ListaEnlazada;

public class Nodo {
    private int coeficiente;
    private int exponente;
    private Nodo siguiente;

    public Nodo(int coeficiente, int exponente, Nodo siguiente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
        this.siguiente = siguiente;
    }

    public int getCoeficiente() {
        return coeficiente;
    }

    public int getExponente() {
        return exponente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setCoeficiente(int coeficiente) {
        this.coeficiente = coeficiente;
    }

    public void setExponente(int exponente) {
        this.exponente = exponente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
