package p2viajes;

/**
 *
 * @author lenovo
 */
public class Nodo {
    /**
     * Enlaza los nodos
     */ 
    public Nodo siguiente;
    /**
     * Enlaza los nodos
     */
    public Nodo anterior;
    /**
     * Guarda un valor entero
     */
    //public int dato;
    /**
     * Guarda un objeto
     */
    public Object objeto;
    /**
     * Guarda un String
     */
    public String cadena;
    /**
     * Constructor por defecto
     */
    public Nodo(){
    }
    /**
     * Inicializa el Nodo para que guarde tipos Object
     * @param objeto a almacenar 
     */
    public Nodo(Object objeto){
        this.objeto = objeto;
    }
    /**
     * Inicializa el Nodo para que guarda tipos int
     * @param dato entero a almacenar
     */
    //public Nodo(int dato){
    //    this.dato = dato;
    //}
    /**
     * Inicializar el Nodo para que gurde tipos String
     * @param cadena 
     */
    //public Nodo(String cadena){
    //    this.cadena = cadena;
    //}
}
