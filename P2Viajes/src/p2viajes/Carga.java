package p2viajes;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Carga {
    public Transportes transporte;
    public Asientos asiento;
    public Hoteles hoteles;
    public Habitaciones habitacion;
    public Cruceros cruceros;
    public Camarotes camarot;
    public RentaDeAutos renta;
    public DestinosTuristicos destino;
    public LEntretenimiento lugar;
    public Clientes clientes;
    public Entidadfinanciera entidad;
    public Packs paquetes;
    public Reservaciones reservaciones;
    /**
     * Consulta el identificador del modulo;
     * @return Identificador de clase
     */
    public String getId(){
        return "Carga";
    }
    /**
     * Despliega un JFileChooser, permitiendóle al usuario seleccionar un archivo '.csv'
     * @return Archivo.csv que se seleccionó para cargar
     */
    public File openFile(){
        //Prepara la ventana para elegir el archivo a cargar
        JFileChooser mFileChooser = new JFileChooser();
        //Limita los archivos que se pueden cargar a CSV
        FileNameExtensionFilter ExtensionFilter = new FileNameExtensionFilter("CSV","csv");
        //Evita que el usuario eliga 'All Files'
        mFileChooser.setAcceptAllFileFilterUsed(false);
        //Aplica el filtro para archivos CSV
        mFileChooser.setFileFilter(ExtensionFilter);
        //Declara la variable en donde se guardará la decisión del usuario
        int resultFileC = mFileChooser.showDialog(null, "Aceptar");
        //Si el usuario ACEPTA se devuelve un Archivo.CSV
        if (resultFileC==JFileChooser.APPROVE_OPTION){
            //Retorna el archivo con la ruta completa según sea el SO
            mFileChooser.getSelectedFile().getAbsolutePath();
            //System.out.print("en OpenFile()" + "\n");
            return mFileChooser.getSelectedFile();
        } else {
            //Sale del programa
            System.exit(0);
        }
        //Si no existe archivo válido no retorna nada
        return null;
    }
    /**
     * Llena una lista (lista) con 'una' línea leída del archivo (file) '.csv'
     * 
     * @method getObject Crea una clase segun sea el identificador (nombre); separa y almacena los atributos que se proporcionan en 'linea'
     * @param file archivo a leer
     * @param lista a llenar con la línea deseada
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void fillList(File file, LSimple lista) throws FileNotFoundException, IOException{
        //Variable en donde se almacena la línea leída
        String texto;
        //Verifica si el archivo es válido 
        if(file != null){
            BufferedReader fileBuffer = new BufferedReader(new FileReader(file));
            while((texto = fileBuffer.readLine())!=null){
                lista.agregarAlFinal(getObject(texto,lista.getId()));
            }
            fileBuffer.close();
        }
    }//fillList(openFile(),transporte);
    
    
    public void writeFile(){

    }
    /**
     * Crea una clase segun sea el identificador (nombre); separa y almacena los atributos que se proporcionan en 'linea'
     * @param linea que contiene los atributos a guardar
     * @param nombre o identificador de la clase en donde se desea guardar la 'linea' de informacion
     * @return Object a guardar en una lista
     */
    public Object getObject(String linea, String nombre){
        String[] atributos = linea.split(",");
        //Segun sea la lista, se llenará con los datos que contiene la linea del archivo '.csv' cargado
        switch(nombre){
            case "transporte":
                transporte = new Transportes(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4]);
                return transporte;
            case "asiento":
                asiento = new Asientos(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4]);
                return asiento;
            case "hoteles":
                hoteles = new Hoteles(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3]);
                return hoteles;
            case "habitacion":
                habitacion = new Habitaciones(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5]);
                return habitacion;
            case "cruceros":
                cruceros = new Cruceros(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5],
                    atributos[6]);
                return cruceros;
            case "camarot":
                camarot = new Camarotes(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3]);
                return camarot;
            case "renta_autos":
                renta = new RentaDeAutos(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5],
                    atributos[6],
                    atributos[7],
                    atributos[8]);
                return renta;
            case "destinos":
                destino = new DestinosTuristicos(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5]);
                return destino;
            case "lugares":
                lugar = new LEntretenimiento(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5],
                    atributos[6],
                    atributos[7],
                    atributos[8],
                    atributos[9]);
                return lugar;
            case "clientes":
                clientes = new Clientes(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5],
                    atributos[6],
                    atributos[7],
                    atributos[8],
                    atributos[9]);
                return clientes;
            case "entidad":
                entidad = new Entidadfinanciera(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5]);
                return entidad;
            case "paquetes":
                paquetes = new Packs(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5],
                    atributos[6],
                    atributos[7],
                    atributos[8],
                    atributos[9],
                    atributos[10]);
                return paquetes;  
            case "reservaciones":
                reservaciones = new Reservaciones(atributos[0],
                    atributos[1],
                    atributos[2],
                    atributos[3],
                    atributos[4],
                    atributos[5],
                    atributos[6],
                    atributos[7]);
                return reservaciones;                
        }       
        return null;
    }
    /**
     * Llena una pila (pila) con 'una' línea leída del archivo (file) '.csv'
     * @method getObject Crea una clase segun sea el identificador (nombre); separa y almacena los atributos que se proporcionan en 'linea'
     * @param cola se llena con la linea deseada
     * @param file archivo a leer
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void llenarCola(File file, Colas cola)throws FileNotFoundException, IOException {
        //Variable en donde se almacena la línea leída
        String texto;
        //Verifica si el archivo es válido 
        if(file != null){
            BufferedReader fileBuffer = new BufferedReader(new FileReader(file));
            while((texto = fileBuffer.readLine())!=null){
                cola.Encolar(getObject(texto,cola.getId()));
            }
            fileBuffer.close();
        }
    }
}
