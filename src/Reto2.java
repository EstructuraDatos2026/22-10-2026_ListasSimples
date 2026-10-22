/**
*Reto 2 (Lista doble): Historial de lectura
*author: Luis Fernando Campuzano Hernández
*date: 22-10-2026
**/

package src;

class NodoDoble {
    String libro;
    NodoDoble siguiente, anterior;

    NodoDoble(String libro) {
        this.libro = libro;
        this.siguiente = null;
        this.anterior = null;
    }
}

class ListaDoble {
    private NodoDoble cabeza, cola;

    public void insertarInicio(String libro) {
        NodoDoble nuevo = new NodoDoble(libro);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
    }

    public boolean eliminar(String libro) {
        NodoDoble actual = cabeza;

        while (actual != null && !actual.libro.equals(libro)) {
            actual = actual.siguiente;
        }

        if (actual == null) return false;

        if (actual.anterior != null) {
            actual.anterior.siguiente = actual.siguiente;
        } else {
            cabeza = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente.anterior = actual.anterior;
        } else {
            cola = actual.anterior;
        }

        return true;
    }

    public void mostrarAdelante() {
        NodoDoble actual = cabeza;

        while (actual != null) {
            System.out.print(actual.libro + " <-> ");
            actual = actual.siguiente;
        }

        System.out.println("null");
    }

    public void mostrarInverso() {
        NodoDoble actual = cola;

        while (actual != null) {
            System.out.print(actual.libro + " <-> ");
            actual = actual.anterior;
        }

        System.out.println("null");
    }
}

public class Reto2 {
    public static void main(String[] args) {
        ListaDoble historial = new ListaDoble();

        historial.insertarInicio("El principito");
        historial.insertarInicio("Don Quijote");
        historial.insertarInicio("Cien años de soledad");

        System.out.println("Historial hacia adelante:");
        historial.mostrarAdelante();

        System.out.println("Historial inverso:");
        historial.mostrarInverso();

        System.out.println("Eliminar Don Quijote: " + historial.eliminar("Don Quijote"));

        historial.mostrarAdelante();
    }
}

