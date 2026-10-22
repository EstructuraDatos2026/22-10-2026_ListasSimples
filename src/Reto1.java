/**
*Reto 1 (Lista simple): Catálogo de libros
*author: Luis Fernando Campuzano Hernández
*date: 22-10-2026
**/

package src;

class Nodo {
    String libro;
    Nodo siguiente;

    Nodo(String libro) {
        this.libro = libro;
        this.siguiente = null;
    }
}

class ListaSimple {
    private Nodo cabeza;

    public void insertarFinal(String libro) {
        Nodo nuevo = new Nodo(libro);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }

            actual.siguiente = nuevo;
        }
    }

    public boolean buscar(String libro) {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.libro.equals(libro)) {
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    public boolean eliminar(String libro) {
        if (cabeza == null) return false;

        if (cabeza.libro.equals(libro)) {
            cabeza = cabeza.siguiente;
            return true;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null) {
            if (actual.siguiente.libro.equals(libro)) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    public void mostrar() {
        Nodo actual = cabeza;

        while (actual != null) {
            System.out.print(actual.libro + " -> ");
            actual = actual.siguiente;
        }

        System.out.println("null");
    }
}

public class Reto1 {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();

        lista.insertarFinal("El principito");
        lista.insertarFinal("Don Quijote");
        lista.insertarFinal("Cien años de soledad");

        System.out.println("Catalogo de libros:");
        lista.mostrar();

        System.out.println("Buscar Don Quijote: " + lista.buscar("Don Quijote"));

        System.out.println("Eliminar El principito: " + lista.eliminar("El principito"));

        lista.mostrar();
    }
}