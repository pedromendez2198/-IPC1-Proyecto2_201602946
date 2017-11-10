package p2viajes;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author HPBEATS
 */
public class P2Viajes {
        protected Colas transportes = new Colas("reservaciones");
        protected LSimple entidad = new LSimple("entidad");
        protected LSimple asientos = new LSimple("asiento");
    /**
     * @param args the command line arguments
    */
    public static void main(String[] args) {
        // TODO code application logic here
        P2Viajes vij = new P2Viajes();
        vij.P2Viajes();
    }
    public void P2Viajes(){

        Carga carga = new Carga();
        try {
            carga.llenarCola(new File("C:\\Users\\HPBEATS\\Desktop\\09 Reservaciones.csv"), transportes);
            carga.fillList(new File("C:\\Users\\HPBEATS\\Desktop\\04 EntidadFinanciera.csv"), entidad);
            carga.fillList(new File("C:\\Users\\HPBEATS\\Desktop\\11 Asientos.csv"), asientos);
        } catch (IOException ex) {
            Logger.getLogger(P2Viajes.class.getName()).log(Level.SEVERE, null, ex);
        }
        SimpleDateFormat n = new SimpleDateFormat("dd/MM/yyyy");
        Date d = new Date();
        System.out.println(n.format(d));
        String dd =n.format(d);
    }
    /*public void imprimir(){
        ListaSimple aux = transportes;
        Transporte ref;
        while(aux.inicio.siguiente != null){
            aux.inicio = aux.inicio.siguiente;
            ref = (Transporte)aux.inicio.objeto;
            System.out.println(ref.id + " -- Destino : " + ref.id_destino + " Pasajeros: " + ref.max_pasajeros );
        }
        System.out.println("");
        transportes.listar();
    }*/
}