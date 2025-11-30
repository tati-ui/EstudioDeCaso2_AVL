/**
 * Clase que representa un nodo de un Árbol AVL.
 * Contiene una llave, su altura y referencias
 * a los nodos hijo izquierdo y derecho.
 *
 * También incluye los métodos para realizar
 * rotaciones necesarias para mantener el árbol equilibrado.
 */
public class NodoAVL {

    int llave;
    int altura;
    NodoAVL izquierda;
    NodoAVL derecha;

    /**
     * Constructor que inicializa un nodo AVL.
     *
     * @param llave valor entero almacenado en el nodo
     */
    public NodoAVL(int llave) {
        this.llave = llave;
        this.altura = 1;
    }

    /**
     * Obtiene la altura de un nodo.
     *
     * @param n nodo cuyo valor de altura se quiere obtener
     * @return altura del nodo o 0 si es nulo
     */
    public static int obtenerAltura(NodoAVL n) {
        return (n == null) ? 0 : n.altura;
    }

    /**
     * Actualiza la altura del nodo en función
     * de las alturas de sus hijos.
     */
    public void actualizarAltura() {
        this.altura = 1 + Math.max(obtenerAltura(this.izquierda),
                obtenerAltura(this.derecha));
    }

    /**
     * Calcula el factor de balance del nodo.
     *
     * @return diferencia entre altura izquierda y derecha
     */
    public int obtenerFactorBalance() {
        return obtenerAltura(this.izquierda) - obtenerAltura(this.derecha);
    }

    // ============================
    //     ROTACIONES AVL
    // ============================

    /**
     * Rotación simple a la derecha (caso LL).
     *
     * @return nueva raíz del subárbol rotado
     */
    public NodoAVL rotarDerecha() {
        NodoAVL nuevaRaiz = this.izquierda;
        NodoAVL temp = nuevaRaiz.derecha;

        nuevaRaiz.derecha = this;
        this.izquierda = temp;

        this.actualizarAltura();
        nuevaRaiz.actualizarAltura();

        return nuevaRaiz;
    }

    /**
     * Rotación simple a la izquierda (caso RR).
     *
     * @return nueva raíz del subárbol rotado
     */
    public NodoAVL rotarIzquierda() {
        NodoAVL nuevaRaiz = this.derecha;
        NodoAVL temp = nuevaRaiz.izquierda;

        nuevaRaiz.izquierda = this;
        this.derecha = temp;

        this.actualizarAltura();
        nuevaRaiz.actualizarAltura();

        return nuevaRaiz;
    }

    /**
     * Rotación doble Izquierda–Derecha (caso LR).
     *
     * @return nueva raíz del subárbol tras la rotación doble
     */
    public NodoAVL rotarIzquierdaDerecha() {
        this.izquierda = this.izquierda.rotarIzquierda();
        return this.rotarDerecha();
    }

    /**
     * Rotación doble Derecha–Izquierda (caso RL).
     *
     * @return nueva raíz del subárbol tras la rotación doble
     */
    public NodoAVL rotarDerechaIzquierda() {
        this.derecha = this.derecha.rotarDerecha();
        return this.rotarIzquierda();
    }
}
