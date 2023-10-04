import java.io.*;
import java.util.Scanner;

public class Metodos {
    File archivo = new File("C:\\Users\\win\\OneDrive\\Escritorio\\archivos\\archivositemasoperativos\\productos.txt");
    File archivo2 = new File("C:\\Users\\win\\OneDrive\\Escritorio\\archivos\\archivositemasoperativos\\productos2.txt");
    Scanner lector = new Scanner(System.in);

    public void alta() throws IOException {

        System.out.println("Ingresa la clave del producto");
        int clave = lector.nextInt();
        // Consumir el carácter de nueva línea restante
        lector.nextLine();

        System.out.println("Ingresa el nombre del producto");
        String nombre = lector.nextLine();

        System.out.println("Ingresa la marca del producto");
        String marca = lector.nextLine();

        System.out.println("Ingresa el precio del producto");
        double precio = Double.parseDouble(lector.nextLine());
        //se cambia el tipo de dato

        System.out.println("Ingresa la cantidad del producto");
        int cantidad = Integer.parseInt(lector.nextLine());
        //tambien aqui se cambia el tipo de dato

        if(clave>10){
            archivo=archivo2;
        }else{
            archivo= new File("C:\\Users\\win\\OneDrive\\Escritorio\\archivos\\archivositemasoperativos\\productos.txt");
        }

        File archivoTemporal = new File(archivo.getAbsolutePath() + ".tmp");
        // Creación del nuevo archivo temporal
        BufferedReader lectora = new BufferedReader(new FileReader(archivo));
        // Buffer para leer
        FileWriter escritor = new FileWriter(archivoTemporal);
        // Buffer para escribir
        int contador =0;

        String linea;
        boolean productoEncontrado = false;

        while ((linea = lectora.readLine()) != null) {
            if (linea.contains("*") && contador==0) {
                //aqui vamos a escribir el nueva producto
                for(int i=0; i<4;i++){
                    lectora.readLine();
                    // nos pasamos las lineas donde esta el producto
                }
                productoEncontrado = true;// Producto encontrado, no escribirlo en el archivo temporal
                escritor.write("Clave :" + clave + "\n");
                escritor.write("Nombre :" + nombre + "\n");
                escritor.write("Marca :" + marca + "\n");
                escritor.write("Precio :" + precio + "\n");
                escritor.write("Cantidad :" + cantidad + "\n");
                contador++;
            } else {
                escritor.write(linea + "\n");
            }

        }
        escritor.close();
        lectora.close();


        if (!productoEncontrado) {

            archivoTemporal.delete();
            // no tiene sentido por que al final es el mismo texto
            escritor = new FileWriter(archivo,true);
            escritor.write("Clave :" + clave + "\n");
            escritor.write("Nombre :" + nombre + "\n");
            escritor.write("Marca :" + marca + "\n");
            escritor.write("Precio :" + precio + "\n");
            escritor.write("Cantidad :" + cantidad + "\n");
            escritor.close();

        } else {
            archivo.delete();
            archivoTemporal.renameTo(archivo);//se renombra el archivo a la ruta del archivo
        }

    }




    public void borrar() throws IOException {

        System.out.println("Ingresa la clave del producto a borrar");
        int clave =  lector.nextInt();

        if(clave >10){
            archivo=archivo2;
        }else{
            archivo= new File("C:\\Users\\win\\OneDrive\\Escritorio\\archivos\\archivositemasoperativos\\productos.txt");
        }

        File archivoTemporal = new File("C:\\Users\\win\\OneDrive\\Escritorio\\archivos\\archivositemasoperativos\\productostem.txt");
        // Creación del nuevo archivo temporal
        BufferedReader lectora = new BufferedReader(new FileReader(archivo));
        // Buffer para leer
        BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));
        // Buffer para escribir


        String Claveborrar = "Clave :" + clave;
        String linea;
        boolean productoEncontrado = false;

        while ((linea = lectora.readLine()) != null) {
            if (linea.contains(Claveborrar)) {
                // aqui vamos a describe el asterisco para identificar que lo borramos
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

    System.out.println("Dame la clave del producto a modificar");
    int cla = lector.nextInt();
    String claveAModificar = "Clave :"+cla;

    if(cla>10){
        archivo=archivo2;
    }else{
        archivo= new File("C:\\Users\\win\\OneDrive\\Escritorio\\archivos\\archivositemasoperativos\\productos.txt");
    }

    File archivoTemporal = new File("C:\\Users\\win\\OneDrive\\Escritorio\\archivos\\archivositemasoperativos\\productostem.txt");
    // Creación del nuevo archivo temporal
    BufferedReader lectora = new BufferedReader(new FileReader(archivo));
    // Buffer para leer
    BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));
    // Buffer para escribir

    String linea;
    boolean encontrado =false;
    while((linea = lectora.readLine()) !=null){
        if(linea.contains(claveAModificar)){
            for(int i=0; i<4;i++){
                lectora.readLine();
            }
            encontrado=true;

 //dejamos la misma clave del producto
            escritor.write("Clave :" + cla + "\n");
            lector.nextLine();

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
        System.out.println("Archivo modificado");
        archivo.delete();
        archivoTemporal.renameTo(archivo);

    }
}
    public void mostrar() throws IOException {

        BufferedReader lectora = new BufferedReader(new FileReader(archivo));
        String cadena;
        archivo = new File("C:\\Users\\win\\OneDrive\\Escritorio\\archivos\\archivositemasoperativos\\productos.txt");

        while ((cadena = lectora.readLine()) != null) {
            if (cadena.contains("*")) {
                for (int i = 0; i < 4; i++) {
                    lectora.readLine();
                }
            } else {
                System.out.println(cadena);
            }
        }
        // Cerrar el primer archivo
        lectora.close();

        // Crear un nuevo bufer para el archivo2
        BufferedReader lectora2 = new BufferedReader(new FileReader(archivo2));
        archivo2 = new File("C:\\Users\\win\\OneDrive\\Escritorio\\archivos\\archivositemasoperativos\\productos2.txt");

        while ((cadena = lectora2.readLine()) != null) {
            if (cadena.contains("*")) {
                for (int i = 0; i < 4; i++) {
                    lectora2.readLine();
                }
            } else {
                System.out.println(cadena);
            }
        }
        lectora2.close();
    }

}
