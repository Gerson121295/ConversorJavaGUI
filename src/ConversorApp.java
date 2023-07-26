import conversores.ConversorMoneda;

import java.util.Scanner;

public class ConversorApp {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int input = 0;

        while (input != 11){
            ConversorMoneda.mostrarMenu(); //gracias a que el metodo mostrarMenu está definido static no es necesario crear un objeto para su llamada.
            input = entrada.nextInt();// El valor de entrada se guarda en input.

            switch (input){
                case 1:
                    ConversorMoneda.conversionDeMoneda("Quetzal", "Dolar",0.12455, entrada);
                    break;
                case 2:
                    ConversorMoneda.conversionDeMoneda("Quetzal", "Euros",0.11227, entrada);
                    break;
                case 3:
                    ConversorMoneda.conversionDeMoneda("Quetzal", "Libras Esterlinas",0.097, entrada);
                    break;
                case 4:
                    ConversorMoneda.conversionDeMoneda("Quetzal", "Yen Japonés",17.6078, entrada);
                    break;
                case 5:
                    ConversorMoneda.conversionDeMoneda("Quetzal", "Won sul-coreano",159.464, entrada);
                    break;


                case 6:
                    ConversorMoneda.conversionDeMoneda("Dolar", "Quetzal", 8.02916, entrada);
                    break;
                case 7:
                    ConversorMoneda.conversionDeMoneda("Euros", "Quetzal", 8.90694, entrada);
                    break;
                case 8:
                    ConversorMoneda.conversionDeMoneda("Libras Esterlinas", "Quetzal", 10.3097, entrada);
                    break;
                case 9:
                    ConversorMoneda.conversionDeMoneda("Yen Japonés", "Quetzal", 0.05424, entrada);
                    break;
                case 10:
                    ConversorMoneda.conversionDeMoneda("Won sul-coreano", "Quetzal", 0.00598, entrada);
                    break;
                case 11:
                    System.out.println("Que pena! Saliendo del programa ...");
                    break;
                default:
                    System.out.println("Elija una opcion valida!");
                    break;
            }
            System.out.println();
        }
        entrada.close();//cierre de la entrada de texto, liberacion del recurso.
    }
}
