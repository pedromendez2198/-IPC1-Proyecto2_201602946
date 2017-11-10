package p2viajes;

/**
 *
 * @author lenovo
 */
public class LSimple {
    public Nodo inicio;
    //Llevará el conteo de Objetos
    private int size; 
    //Identifica a la lista
    private String id;
    /**
     * Consulta cuántos (nodos) elementos tiene la lista
     * @return número entero
     */
    public int getSize() {
        return size;
    }
    /**
     * Consulta el identificador de la lista
     * @return identificador o nombre de lista asignado
     */
    public String getId(){
        return id;
    }
    /**
     * Constructor por defecto
     * @param nombre o identificador de la lista
     */
    public LSimple(String nombre){
        this.inicio = null;
        this.size = 0;
        this.id = nombre;
    }
    /**
     * Consulta si la lista esta vacía
     * @return true si el primer nodo (inicio), no apunta a otro nodo
     */
    public boolean esVacia(){
        return inicio == null;
    }
    /**
     * Agrega un nuevo nodo al final de la lista
     * @param clase objeto a almacenar en el nodo
     */
    public void agregarAlFinal(Object clase){
        Nodo nuevo = new Nodo(clase);
        if (esVacia()){
            inicio = nuevo;
        } else {
            /**
             * El objeto  a insertar  no es el «inicio»
             * de la lista, por lo que recorre la lista
             * hasta llegar al último nodo y agrega el 
             * objeto
             */
            Nodo aux = inicio;
            while(aux.siguiente != null){
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
        size++;
    }
    /**
     * Busca si existe un Objeto en la lista
     * @param referencia (Objeto) a buscar
     * @return true si existe el Objeto en la lista
     */
    public boolean buscar(Object referencia){
        Nodo aux = inicio;//Crea una copia de la lista
        boolean existe = false;//Servirá para indicar si el objeto existe o no
        //Realiza un recorrido, muy parecido a la mecánica for each, 
        //hasta encontrar el Objeto o hasta llegar al final de la lista
        while(aux != null){ //&& existe != true){
            if(referencia == aux.objeto){
                //Referencia encontrada!
                existe = true;
            } else {
                //Avanza al siguiente nodo
                aux = aux.siguiente;
            }
        }
        return existe;
    }/*
    public Reservaciones getReservacionB(String expresion, Pila pilaReservaciones, int posicionComa){
        Nodo pilaAux = null;
        Reservaciones ref = (Reservaciones) pilaReservaciones.Ver();
        String referencia = getBD(ref,posicionComa);
        Reservaciones retorno = ref;
        while(!referencia.equals(expresion)){
            Nodo temp = new Nodo();
            temp.objeto = pilaReservaciones.Ver();
            if (pilaAux==null){
                pilaAux = temp;
            } else {
                temp.siguiente = pilaAux;
                pilaAux = temp;
            }
            pilaReservaciones.Desapilar();
            retorno = (Reservaciones) (Reservaciones)pilaReservaciones.Ver();
            referencia = getBD(retorno,posicionComa);
        }
        while(pilaAux!=null){
            pilaReservaciones.Apilar(pilaAux.objeto);
            pilaAux = pilaAux.siguiente;
        }
        //
        pilaAux = null;
        return retorno;
    }*/
    /**
     * Devuelve un objeto según una 'expresion' a comparar, 
     * dicha 'expresion' se aloja en la 'posicionComa' del 
     * objeto guardado en el nodo
     * @param expresion valor a comparar con la información que guarda el objeto del nodo de la pila
     * @param posicionComa poisicion en la que se encuentra la expresion a comparar
     * @return 
     */
    public Object buscar(String expresion, int posicionComa){
        //Crea una copia de la lista
        Nodo aux = inicio;
        //Crea otra copia de la lista
        Nodo temp = inicio;
        //Variable en donde se guardará la referencia a comparar con 'expresion
        String referencia;
        //Tipo de objeto guardado
        String objeto = getId();
        //System.out.println(objeto);
        //Elegi cómo va a castear los objetos
        try {
            switch(objeto){
                case "transporte":
                    //Castea el objeto del nodo aux
                    Transportes transporte = (Transportes) aux.objeto;
                    //Guarda la referencia a buscar
                    referencia = transporte.getBD(transporte, posicionComa);
                    //Se detendrá hasta que encuentre una coincidencia 
                    //entre la referencia y la expresion dada
                    //verificará que el nodo no sea nulo
                    while (!referencia.equals(expresion) && temp!=null ) {
                        //Se mueve al siguiente nodo
                        temp = temp.siguiente;
                        //Caste el objeto del nodo -siguiente
                        transporte = (Transportes) temp.objeto;
                        //Obtiene la referencia con la cual
                        //se volverá a compara la expresion
                        referencia = transporte.getBD(transporte,posicionComa);
                    }
                    return transporte;
                case "asiento":
                    //Castea el objeto del nodo aux
                    Asientos asiento = (Asientos) aux.objeto;
                    //Guarda la referencia a buscar
                    referencia = asiento.getBD(asiento, posicionComa);
                    //Se detendrá hasta que encuentre una coincidencia 
                    //entre la referencia y la expresion dada
                    //verificará que el nodo no sea nulo
                    while (!referencia.equals(expresion) && temp!=null ) {
                        //Se mueve al siguiente nodo
                        temp = temp.siguiente;
                        //Caste el objeto del nodo -siguiente
                        asiento = (Asientos) temp.objeto;
                        //Obtiene la referencia con la cual
                        //se volverá a compara la expresion
                        referencia = asiento.getBD(asiento,posicionComa);
                    }
                    return asiento;
                case "hoteles":
                    //Castea el objeto del nodo aux
                    Hoteles hoteles = (Hoteles) aux.objeto;
                    //Guarda la referencia a buscar
                    referencia = hoteles.getBD(hoteles, posicionComa);
                    //Se detendrá hasta que encuentre una coincidencia 
                    //entre la referencia y la expresion dada
                    //verificará que el nodo no sea nulo
                    while (!referencia.equals(expresion) && temp!=null ) {
                        //Se mueve al siguiente nodo
                        temp = temp.siguiente;
                        //Caste el objeto del nodo -siguiente
                        hoteles = (Hoteles) temp.objeto;
                        //Obtiene la referencia con la cual
                        //se volverá a compara la expresion
                        referencia = hoteles.getBD(hoteles,posicionComa);
                    }
                    return hoteles;
                case "habitacion":
                    //Castea el objeto del nodo aux
                    Habitaciones habitacion = (Habitaciones) aux.objeto;
                    //Guarda la referencia a buscar
                    referencia = habitacion.getBD(habitacion, posicionComa);
                    //Se detendrá hasta que encuentre una coincidencia 
                    //entre la referencia y la expresion dada
                    //verificará que el nodo no sea nulo
                    while (!referencia.equals(expresion) && temp!=null ) {
                        //Se mueve al siguiente nodo
                        temp = temp.siguiente;
                        //Caste el objeto del nodo -siguiente
                        habitacion = (Habitaciones) temp.objeto;
                        //Obtiene la referencia con la cual
                        //se volverá a compara la expresion
                        referencia = habitacion.getBD(habitacion,posicionComa);
                    }
                    return habitacion;
                case "cruceros":
                    //Castea el objeto del nodo aux
                    Cruceros crucero = (Cruceros) aux.objeto;
                    //Guarda la referencia a buscar
                    referencia = crucero.getBD(crucero, posicionComa);
                    //Se detendrá hasta que encuentre una coincidencia 
                    //entre la referencia y la expresion dada
                    //verificará que el nodo no sea nulo
                    while (!referencia.equals(expresion) && temp!=null ) {
                        //Se mueve al siguiente nodo
                        temp = temp.siguiente;
                        //Caste el objeto del nodo -siguiente
                        crucero = (Cruceros) temp.objeto;
                        //Obtiene la referencia con la cual
                        //se volverá a compara la expresion
                        referencia = crucero.getBD(crucero,posicionComa);
                    }
                    return crucero;
                case "camarot":
                    //Castea el objeto del nodo aux
                    Camarotes camarot = (Camarotes) aux.objeto;
                    //Guarda la referencia a buscar
                    referencia = camarot.getBD(camarot, posicionComa);
                    //Se detendrá hasta que encuentre una coincidencia 
                    //entre la referencia y la expresion dada
                    //verificará que el nodo no sea nulo
                    while (!referencia.equals(expresion) && temp!=null ) {
                        //Se mueve al siguiente nodo
                        temp = temp.siguiente;
                        //Caste el objeto del nodo -siguiente
                        camarot = (Camarotes) temp.objeto;
                        //Obtiene la referencia con la cual
                        //se volverá a compara la expresion
                        referencia = camarot.getBD(camarot,posicionComa);
                    }
                    return camarot;
                case "renta_autos":
                    //Castea el objeto del nodo aux
                    RentaDeAutos renta = (RentaDeAutos) aux.objeto;
                    //Guarda la referencia a buscar
                    referencia = renta.getBD(renta, posicionComa);
                    //Se detendrá hasta que encuentre una coincidencia 
                    //entre la referencia y la expresion dada
                    //verificará que el nodo no sea nulo
                    while (!referencia.equals(expresion) && temp!=null ) {
                        //Se mueve al siguiente nodo
                        temp = temp.siguiente;
                        //Caste el objeto del nodo -siguiente
                        renta = (RentaDeAutos) temp.objeto;
                        //Obtiene la referencia con la cual
                        //se volverá a compara la expresion
                        referencia = renta.getBD(renta,posicionComa);
                    }
                    return renta;
                case "destinos":
                    //Castea el objeto del nodo aux
                    DestinosTuristicos destino = (DestinosTuristicos) aux.objeto;
                    //Guarda la referencia a buscar
                    referencia = destino.getBD(destino, posicionComa);
                    //Se detendrá hasta que encuentre una coincidencia 
                    //entre la referencia y la expresion dada
                    //verificará que el nodo no sea nulo
                    while (!referencia.equals(expresion) && temp!=null ) {
                        //Se mueve al siguiente nodo
                        temp = temp.siguiente;
                        //Caste el objeto del nodo -siguiente
                        destino = (DestinosTuristicos) temp.objeto;
                        //Obtiene la referencia con la cual
                        //se volverá a compara la expresion
                        referencia = destino.getBD(destino,posicionComa);
                    }
                    return destino;
                case "lugares"://Castea el objeto del nodo aux
                    LEntretenimiento lugar = (LEntretenimiento) aux.objeto;
                    //Guarda la referencia a buscar
                    referencia = lugar.getBD(lugar, posicionComa);
                    //Se detendrá hasta que encuentre una coincidencia 
                    //entre la referencia y la expresion dada
                    //verificará que el nodo no sea nulo
                    while (!referencia.equals(expresion) && temp!=null ) {
                        //Se mueve al siguiente nodo
                        temp = temp.siguiente;
                        //Caste el objeto del nodo -siguiente
                        lugar = (LEntretenimiento) temp.objeto;
                        //Obtiene la referencia con la cual
                        //se volverá a compara la expresion
                        referencia = lugar.getBD(lugar,posicionComa);
                    }
                    return lugar;
                case "clientes"://Castea el objeto del nodo aux
                    Clientes clientes = (Clientes) aux.objeto;
                    //Guarda la referencia a buscar
                    referencia = clientes.getBD(clientes, posicionComa);
                    //Se detendrá hasta que encuentre una coincidencia 
                    //entre la referencia y la expresion dada
                    //verificará que el nodo no sea nulo
                    while (!referencia.equals(expresion) && temp!=null ) {
                        //Se mueve al siguiente nodo
                        temp = temp.siguiente;
                        //Caste el objeto del nodo -siguiente
                        clientes = (Clientes) temp.objeto;
                        //Obtiene la referencia con la cual
                        //se volverá a compara la expresion
                        referencia = clientes.getBD(clientes,posicionComa);
                    }
                    return clientes;
                case "entidad"://Castea el objeto del nodo aux
                    Entidadfinanciera entidad = (Entidadfinanciera) aux.objeto;
                    //Guarda la referencia a buscar
                    referencia = entidad.getBD(entidad, posicionComa);
                    //Se detendrá hasta que encuentre una coincidencia 
                    //entre la referencia y la expresion dada
                    //verificará que el nodo no sea nulo
                    while (!referencia.equals(expresion) && temp!=null ) {
                        //Se mueve al siguiente nodo
                        temp = temp.siguiente;
                        //Caste el objeto del nodo -siguiente
                        entidad = (Entidadfinanciera) temp.objeto;
                        //Obtiene la referencia con la cual
                        //se volverá a compara la expresion
                        referencia = entidad.getBD(entidad,posicionComa);
                    }
                    return entidad;
                case "paquetes"://Castea el objeto del nodo aux
                    Packs paquetes = (Packs) aux.objeto;
                    //Guarda la referencia a buscar
                    referencia = paquetes.getBD(paquetes, posicionComa);
                    //Se detendrá hasta que encuentre una coincidencia 
                    //entre la referencia y la expresion dada
                    //verificará que el nodo no sea nulo
                    while (!referencia.equals(expresion) && temp!=null ) {
                        //Se mueve al siguiente nodo
                        temp = temp.siguiente;
                        //Caste el objeto del nodo -siguiente
                        paquetes = (Packs) temp.objeto;
                        //Obtiene la referencia con la cual
                        //se volverá a compara la expresion
                        referencia = paquetes.getBD(paquetes,posicionComa);
                    }
                    return paquetes;
                case "reservaciones"://Castea el objeto del nodo aux
                    Reservaciones reservaciones = (Reservaciones) aux.objeto;
                    //Guarda la referencia a buscar
                    referencia = reservaciones.getBD(reservaciones, posicionComa);
                    //Se detendrá hasta que encuentre una coincidencia 
                    //entre la referencia y la expresion dada
                    //verificará que el nodo no sea nulo
                    while (!referencia.equals(expresion) && temp!=null ) {
                        //Se mueve al siguiente nodo
                        temp = temp.siguiente;
                        //Caste el objeto del nodo -siguiente
                        reservaciones = (Reservaciones) temp.objeto;
                        //Obtiene la referencia con la cual
                        //se volverá a compara la expresion
                        referencia = reservaciones.getBD(reservaciones,posicionComa);
                    }
                    return reservaciones;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }    
    /**
     * Actualiza el valor de un nodo que se encuentre en la lista
     * ubicado por un Objeto de referencia
     * @param referencia,Objeto del nodo que se desea actualizar 
     * @param clase, nuevo Objeto para el nodo.
     */
    public void editarPorReferencia(Object referencia, Object clase){
        //Consulta si el objeto existe
        if(buscar(referencia)){
            //Crea una copia de la lista
            Nodo aux = inicio;
            while(aux.objeto != referencia){
                aux = aux.siguiente;
            }
            //Actualiza la lista
            aux.objeto = clase;
        }
    }
    /**
     * Elimina un nodo que se encuentre en la lista
     * según un Objeto de referencia 
     * @param referencia, Objeto del nodo que se desea eliminar
     */
    public void removerPorReferencia(Object referencia){
        //Verifica si existe el Objeto en la lista
        if(buscar(referencia)){
            //Verifica sí el nodo a eliminar es el primero
            if(inicio.objeto==referencia){
                //Arregla el apuntador hacia el siguiente
                inicio = inicio.siguiente;
            } else {
                //Crea una copia de la lista
                Nodo aux = inicio;
                //Recorre la lista y se detiene 
                //justo antes del Nodo que contiene el 
                //Objeto referencia
                while(aux.siguiente.objeto!=referencia){
                    aux = aux.siguiente;
                }
                //Guarda el nodo siguiente del nodo a eliminar.
                Nodo siguiente = aux.siguiente.siguiente;
                //Enlaza el nodo anterior al de eliminar con 
                //el siguiente despues de el.
                aux.siguiente = siguiente;
            }
            //Disminuye el contador
            size--;
        }
    }
    /**
     * Desmonta la lista desde el principio
     * desmonta nodo por nodo
     * @return 
     */
    public Object listar(){
        if(!esVacia()){
            Object obj = inicio.objeto;
            inicio = inicio.siguiente;
            size--;
            return obj;
        }
        return null;
    }
}
