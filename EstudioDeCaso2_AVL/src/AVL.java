import java.io.PrintStream;

/**
 * Implementación de un Árbol AVL.
 * Permite insertar, eliminar y buscar valores,
 * además de mostrar recorridos y detalles
 * como alturas y factores de balance.
 */
public class AVL {

    NodoAVL raiz;
    private PrintStream out = System.out;

    /**
     * Busca un valor dentro del árbol AVL.
     *
     * @param llave valor entero a buscar
     * @return true si existe, false si no
     */
    public boolean buscar(int llave) {
        NodoAVL actual = raiz;
        while (actual != null) {
            if (llave == actual.llave) return true;
            actual = (llave < actual.llave) ? actual.izquierda : actual.derecha;
        }
        return false;
    }

    /**
     * Inserta un valor en el árbol AVL.
     *
     * @param llave valor a insertar
     */
    public void insertar(int llave) {
        raiz = insertarRec(raiz, llave);
    }

    /**
     * Inserción recursiva con balanceo automático.
     */
    private NodoAVL insertarRec(NodoAVL nodo, int llave) {

        if (nodo == null) return new NodoAVL(llave);

        if (llave < nodo.llave)
            nodo.izquierda = insertarRec(nodo.izquierda, llave);
        else if (llave > nodo.llave)
            nodo.derecha = insertarRec(nodo.derecha, llave);
        else
            return nodo;

        nodo.actualizarAltura();
        return balancear(nodo, llave);
    }

    /**
     * Balancea el árbol después de una inserción.
     */
    private NodoAVL balancear(NodoAVL nodo, int llaveInsertada) {
        int fb = nodo.obtenerFactorBalance();

        // Caso LL
        if (fb > 1 && llaveInsertada < nodo.izquierda.llave) {
            out.println("[LL] Rotación derecha");
            return nodo.rotarDerecha();
        }

        // Caso RR
        if (fb < -1 && llaveInsertada > nodo.derecha.llave) {
            out.println("[RR] Rotación izquierda");
            return nodo.rotarIzquierda();
        }

        // Caso LR
        if (fb > 1 && llaveInsertada > nodo.izquierda.llave) {
            out.println("[LR] Rotación Izq-Der");
            return nodo.rotarIzquierdaDerecha();
        }

        // Caso RL
        if (fb < -1 && llaveInsertada < nodo.derecha.llave) {
            out.println("[RL] Rotación Der-Izq");
            return nodo.rotarDerechaIzquierda();
        }

        return nodo;
    }

    /**
     * Elimina un valor del árbol AVL.
     *
     * @param llave valor a eliminar
     */
    public void eliminar(int llave) {
        raiz = eliminarRec(raiz, llave);
    }

    /**
     * Proceso recursivo para eliminar un nodo.
     */
    private NodoAVL eliminarRec(NodoAVL nodo, int llave) {

        if (nodo == null) return null;

        if (llave < nodo.llave)
            nodo.izquierda = eliminarRec(nodo.izquierda, llave);
        else if (llave > nodo.llave)
            nodo.derecha = eliminarRec(nodo.derecha, llave);
        else {

            if (nodo.izquierda == null || nodo.derecha == null)
                nodo = (nodo.izquierda != null) ? nodo.izquierda : nodo.derecha;
            else {
                NodoAVL sucesor = obtenerMinimo(nodo.derecha);
                nodo.llave = sucesor.llave;
                nodo.derecha = eliminarRec(nodo.derecha, sucesor.llave);
            }
        }

        if (nodo == null) return null;

        nodo.actualizarAltura();
        return balancearEliminar(nodo);
    }

    /**
     * Encuentra el nodo con el valor mínimo
     * en un subárbol.
     */
    private NodoAVL obtenerMinimo(NodoAVL nodo) {
        while (nodo.izquierda != null)
            nodo = nodo.izquierda;
        return nodo;
    }

    /**
     * Balancea el árbol después de una eliminación.
     */
    private NodoAVL balancearEliminar(NodoAVL nodo) {
        int fb = nodo.obtenerFactorBalance();

        if (fb > 1 && nodo.izquierda.obtenerFactorBalance() >= 0)
            return nodo.rotarDerecha();

        if (fb > 1 && nodo.izquierda.obtenerFactorBalance() < 0)
            return nodo.rotarIzquierdaDerecha();

        if (fb < -1 && nodo.derecha.obtenerFactorBalance() <= 0)
            return nodo.rotarIzquierda();

        if (fb < -1 && nodo.derecha.obtenerFactorBalance() > 0)
            return nodo.rotarDerechaIzquierda();

        return nodo;
    }

    /**
     * Imprime los valores del árbol en orden ascendente.
     */
    public void imprimirEnOrden() {
        imprimirEnOrdenRec(raiz);
        System.out.println();
    }

    private void imprimirEnOrdenRec(NodoAVL nodo) {
        if (nodo != null) {
            imprimirEnOrdenRec(nodo.izquierda);
            System.out.print(nodo.llave + " ");
            imprimirEnOrdenRec(nodo.derecha);
        }
    }

    /**
     * Imprime detalles del árbol:
     * llaves, alturas y factores de balance.
     */
    public void imprimirDetalles() {
        imprimirDetallesRec(raiz, 0);
    }

    private void imprimirDetallesRec(NodoAVL nodo, int nivel) {
        if (nodo != null) {
            imprimirDetallesRec(nodo.derecha, nivel + 1);
            System.out.println("    ".repeat(nivel) + nodo.llave +
                    " (h=" + nodo.altura + ", fb=" + nodo.obtenerFactorBalance() + ")");
            imprimirDetallesRec(nodo.izquierda, nivel + 1);
        }
    }
}

