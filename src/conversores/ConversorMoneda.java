package conversores;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ConversorMoneda {


    public static void mostrarMenu(){
        System.out.println("==================================================");
        System.out.println("\t\tBienvenido al conversor ");
        System.out.println(" 1 - Convertir de Quetzal a Dólar ");
        System.out.println(" 2 - Convertir de Quetzal a Euros" );
        System.out.println(" 3 - Convertir de Quetzal a Libras Esterlinas");
        System.out.println(" 4 - Convertir de Quetzal a Yen Japonés");
        System.out.println(" 5 - Convertir de Quetzal a Won sul-coreano");
        System.out.println();
        System.out.println(" 6 - Convertir de Dólar a Quetzal");
        System.out.println(" 7 - Convertir de Euros a Quetzal");
        System.out.println(" 8 - Convertir de Libras Esterlina a Quetzal");
        System.out.println(" 9 - Convertir de Yen Japonés a Quetzal");
        System.out.println("10 - Convertir de Won sul-coreano a Quetzal");
        System.out.println("11 - salir");
        System.out.println("==================================================");
        System.out.print("Elija una opción valida: ");

    }

    public static void conversionDeMoneda(String unidadOrigen, String unidadDestino,
                                          double proporcionMoneda, Scanner lector){
        System.out.println("Elegiste la opcion de convertir de "+ unidadOrigen+ " A "+unidadDestino);
        System.out.println("Ingrese la cantidad de "+unidadOrigen);
        double cantidadIngresada = lector.nextDouble();// valor guarda el dato que usuario ingreso en el lector
        double totalMonedas = cantidadIngresada * proporcionMoneda;
        System.out.println("Total: "+ totalMonedas+ " " +unidadDestino);

    }


    public static double conversionDeMonedaGUI(String unidadOrigen, String unidadDestino,
                                          double proporcionMoneda, double cantidadMonedaAConvertir){
        System.out.println("Elegiste la opcion de convertir de "+ unidadOrigen+ " A "+unidadDestino);
        double totalMonedas = cantidadMonedaAConvertir * proporcionMoneda;
        // Redondear el resultado a dos dígitos después del punto
        double resultadoFormateado = Math.round(totalMonedas * 100.0) / 100.0;
        //System.out.println("Total: "+ totalMonedas+ " " +unidadDestino);
        return resultadoFormateado;
    }

}
