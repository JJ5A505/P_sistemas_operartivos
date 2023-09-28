import java.io.*;
import java.util.Scanner;

public class Metodos {
    File archivo = new File("C:\\Users\\win\\OneDrive\\Escritorio\\archivos\\archivositemasoperativos\\productos.txt");
    Scanner lector = new Scanner(System.in);

    public void alta() throws IOException {
        FileWriter escribir = new FileWriter(archivo, true);
        //(ruta del archivo, que se quiere anadir al archivo y no sobreescribir);
        System.out.println("Ingresa la clave del producto");
        String clave = lector.nextLine();
        escribir.write("Clave :" + clave + "\n");

        System.out.println("Ingresa el nombre del producto");
        String nombre = lector.nextLine();
        escribir.write("Nombre :" + nombre + "\n");

        System.out.println("Ingresa la marca del producto");
        String marca = lector.nextLine();
        escribir.write("Marca :" + marca + "\n");

        System.out.println("Ingresa el precio del producto");
        double precio = Double.parseDouble(lector.nextLine());
        //se cambia el tipo de dato
        escribir.write("Precio :" + precio + "\n");

        System.out.println("Ingresa la cantidad del producto");
        int cantidad = Integer.parseInt(lector.nextLine());
        //tambien aqui se cambia el tipo de dato
        escribir.write("Cantidad :" + cantidad + "\n");
        escribir.close();
    }

    public void borrar() throws IOException {

        File archivoTemporal = new File("C:\\Users\\win\\OneDrive\\Escritorio\\archivos\\archivositemasoperativos\\productostem.txt");
        // Creación del nuevo archivo temporal
        BufferedReader lectora = new BufferedReader(new FileReader(archivo));
        // Buffer para leer
        BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));
        // Buffer para escribir

        System.out.println("Ingresa la clave del producto a borrar");
        String Claveborrar = "Clave :" + lector.nextLine();

        String linea;
        boolean productoEncontrado = false;

        while ((linea = lectora.readLine()) != null) {
            if (linea.contains(Claveborrar)) {
                // aqui vamos a escribir el asterisco para identificar que lo borramos
                escritor.write("* "+linea+"\n");
                // Producto encontrado, no escribirlo en el archivo temporal
                productoEncontrado = true;
            } else {

                escritor.write(linea + "\n");
            }
        }

        escritor.close();
        lectora.close();

        if (!productoEncontrado) {
            System.out.println("No se encontró el producto.");
            archivoTemporal.delete();
            // no tiene sentido por que al final es el mismo texto
        } else {
            archivo.delete();
            archivoTemporal.renameTo(archivo);
            //se renombra el archivo a la ruta del archivo
            System.out.println("Producto eliminado");
        }
    }



public void modificar() throws IOException {
    File archivoTemporal = new File("C:\\Users\\win\\OneDrive\\Escritorio\\archivos\\archivositemasoperativos\\productostem.txt");
    // Creación del nuevo archivo temporal
    BufferedReader lectora = new BufferedReader(new FileReader(archivo));
    // Buffer para leer
    BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));
    // Buffer para escribir
    System.out.println("Dame la clave del producto a modificar");
    String claveAModificar = "Clave :"+lector.nextLine();
    String linea;
    boolean encontrado =false;
    while((linea = lectora.readLine()) !=null){
        if(linea.contains(claveAModificar)){
            for(int i=0; i<4;i++){
                lectora.readLine();
            }
            encontrado=true;
            System.out.println("Ingresa la nueva clave del producto");
            String clave = lector.nextLine();
            escritor.write("Clave :" + clave + "\n");

            System.out.println("Ingresa el nuevo nombre del producto");
            String nombre = lector.nextLine();
            escritor.write("Nombre :" + nombre + "\n");

            System.out.println("Ingresa la nueva marca del producto");
            String marca = lector.nextLine();
            escritor.write("Marca :" + marca + "\n");

            System.out.println("Ingresa el nuevo precio del producto");
            double precio = Double.parseDouble(lector.nextLine());
            //se cambia el tipo de dato
            escritor.write("Precio :" + precio + "\n");

            System.out.println("Ingresa la cantidad del producto");
            int cantidad = Integer.parseInt(lector.nextLine());
            //tambien aqui se cambia el tipo de dato
            escritor.write("Cantidad :" + cantidad + "\n");
        }else {
            escritor.write(linea +"\n");
        }

    }
    escritor.close();
    lectora.close();
    if(!encontrado){
        System.out.println("No se encontro el producto a modificar");
        archivoTemporal.delete();
    }else{
       /* System.out.println("Archivo modificado");
        archivo.delete();
        archivoTemporal.renameTo(archivo);*/

    }

}
public void mostrar()throws IOException{
    BufferedReader lectora = new BufferedReader(new FileReader(archivo));
String cadena;
if(archivo.exists()){
    while ((cadena= lectora.readLine()) != null){
        System.out.println(cadena);
}
    System.out.println("\n");
    lectora.close();
}else{
    System.out.println("El archivo no existe");
}
}
    }


