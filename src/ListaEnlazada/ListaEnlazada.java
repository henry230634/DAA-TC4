package ListaEnlazada;

public class ListaEnlazada {

    private Nodo primero;
    private int numElem;

    public ListaEnlazada() {
        primero = null;
        numElem = 0;
    }
    
    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public int getNumElem() {
        return numElem;
    }

    public void setNumElem(int numElem) {
        this.numElem = numElem;
    }

    public void insertarPrimero(int coef, int expo) {
        Nodo nuevo = new Nodo(coef, expo, primero);
        primero = nuevo;
        numElem++;
    }

    public void insertarFinal(int coef, int expo) {
        Nodo nuevo = new Nodo(coef, expo, null);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        numElem++;
    }

    public void borrar(int coef, int expo) {
        if (primero == null) {
            System.out.println("Lista vacía");
        } else if (primero.getCoeficiente() == coef && primero.getExponente() == expo) {
            primero = primero.getSiguiente();
            numElem--;
        } else {
            Nodo actual = primero;
            while (actual.getSiguiente() != null
                    && !(actual.getSiguiente().getCoeficiente() == coef && actual.getSiguiente().getExponente() == expo)) {
                actual = actual.getSiguiente();
            }
            if (actual.getSiguiente() == null) {
                System.out.println("Elemento (" + coef + ", " + expo + ") no está en la lista");
            } else {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                numElem--;
            }
        }
    }

    public String listar() {
        if (primero == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Nodo actual = primero;
        
        sb.append(actual.getCoeficiente()).append("X^").append(actual.getExponente());
        actual = actual.getSiguiente();
        
        while (actual != null) {
            sb.append(" + ")
                    .append(actual.getCoeficiente())
                    .append("X^")
                    .append(actual.getExponente());
            actual = actual.getSiguiente();
        }

        return sb.toString();
    }
}
