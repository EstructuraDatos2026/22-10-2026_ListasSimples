/**
*Reto 3 (Lista circular): Turnos de préstamo
*author: Luis Fernando Campuzano Hernández
*date: 22-10-2026
**/

package src;

class NodoCircular {
    String estudiante;
    NodoCircular siguiente;

    NodoCircular(String estudiante) {
        this.estudiante = estudiante;
        this.siguiente = null;
    }
}

class ListaCircular {
    private NodoCircular cabeza, cola;

    public void insertar(String estudiante) {
        NodoCircular nuevo = new NodoCircular(estudiante);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        }
    }

    public void mostrarUnaVuelta() {
        if (cabeza == null) {
            System.out.println("Lista vacia");
            return;
        }

        NodoCircular actual = cabeza;

        do {
            System.out.print(actual.estudiante + " -> ");
            actual = actual.siguiente;
        } while (actual != cabeza);

        System.out.println("(vuelve a " + cabeza.estudiante + ")");
    }

    public int contar() {
        if (cabeza == null) return 0;

        int contador = 0;
        NodoCircular actual = cabeza;

        do {
            contador++;
            actual = actual.siguiente;
        } while (actual != cabeza);

        return contador;
    }

    public void eliminarSiguienteDe(String estudiante) {
        if (cabeza == null) return;

        NodoCircular actual = cabeza;

        do {
            if (actual.estudiante.equals(estudiante)) {
                NodoCircular eliminar = actual.siguiente;

                if (eliminar == actual) {
                    cabeza = null;
                    cola = null;
                } else {
                    actual.siguiente = eliminar.siguiente;

                    if (eliminar == cabeza) {
                        cabeza = eliminar.siguiente;
                    }

                    if (eliminar == cola) {
                        cola = actual;
                    }

                    cola.siguiente = cabeza;
                }

                return;
            }

            actual = actual.siguiente;
        } while (actual != cabeza);
    }
}

public class Reto3 {
    public static void main(String[] args) {
        ListaCircular turnos = new ListaCircular();

        turnos.insertar("Luis");
        turnos.insertar("Ana");
        turnos.insertar("Pedro");
        turnos.insertar("Maria");

        System.out.println("Turnos de prestamo:");
        turnos.mostrarUnaVuelta();

        System.out.println("Total de estudiantes: " + turnos.contar());

        turnos.eliminarSiguienteDe("Luis");

        System.out.println("Despues de eliminar el siguiente de Luis:");
        turnos.mostrarUnaVuelta();

        System.out.println("Total de estudiantes: " + turnos.contar());
    }
}
