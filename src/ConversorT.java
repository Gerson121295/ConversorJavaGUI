import conversores.ConversorTemperatura;

import java.util.Scanner;

public class ConversorT {

    /**
     System.out.println("\t\tBienvenido al conversor de Temperatura ");
     System.out.println(" 1 - Grados Celcius a Grados Farenheit  ");
     System.out.println(" 2 - Grados Celcius a Kelvin" );
     System.out.println(" 3 - Grados Farenheit a Grados Celcius");
     System.out.println(" 4 - Kelvin a Grados Celcius");
     System.out.println(" 5 - Kelvin a Grados a Farenheit");
     System.out.println(" 6 - salir");
     System.out.println("==============
     */
    public static <gradosKelvin> void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Scanner lector = new Scanner(System.in);

        int input = 0;

        while(input!=6){
            ConversorTemperatura.MenuTemperatura();//gracias a que el metodo mostrarMenu está definido static no es necesario crear un objeto para su llamada.
            input = entrada.nextInt();// El valor de entrada se guarda en input.

            switch (input){
                case 1:
                    System.out.println("\n 1 - Grados Celcius a Grados Farenheit  ");
                    System.out.println("Ingrese los grados Celcius");
                    double gradosCelciusIngresados = lector.nextDouble();// valor guarda el dato que usuario ingreso en el lector
                    double gradosFarenheit = (1.8 * gradosCelciusIngresados) + 32; // F= 9/5 * c +32
                    System.out.println(gradosFarenheit + " Grados Farenheit");
                    break;
                case 2:
                    System.out.println("\n 2 - Grados Celcius a Kelvin" );
                    System.out.println("Ingrese los grados Celcius");
                    double gradosCelciusIngresado = lector.nextDouble();
                    double gradosKelvin = gradosCelciusIngresado + 273.15; // C + 273.15 = K
                    System.out.println(gradosKelvin+ " Grados Kelvin");
                    break;
                case 3:
                    System.out.println("\n 3 - Grados Farenheit a Grados Celcius");
                    System.out.println("Ingrese los grados Farenheit");
                    double gradosFarenheitIngresado = lector.nextDouble();
                    double gradosCelcius =(5 * (gradosFarenheitIngresado - 32)) / 9;  //  C = (5 (F-32)/9) + 32
                    System.out.println(gradosCelcius + " Grados Celcius");
                    break;
                case 4:
                    System.out.println("\n 4 - Kelvin a Grados Celcius");
                    System.out.println("Ingrese los grados Kelvin");
                    double gradosKelvinIngresado = lector.nextDouble();
                    double gradosCelciu = gradosKelvinIngresado - 273.15; //C = K - 273.15
                    System.out.println(gradosCelciu+" Grados Celcius");
                    break;
                case 5:
                    System.out.println("\n 5 - Kelvin a Grados a Farenheit");
                    System.out.println("Ingrese los grados Kelvin");
                    double gradoskelvinIngresados = lector.nextDouble();
                    double gradosFarenheits = ((gradoskelvinIngresados - 273.15) * 1.8) +32; //(K − 273.15) × 9/5 + 32 = °F
                    System.out.println(gradosFarenheits + "Grados Farenheit");
                    break;
                case 6:
                    System.out.println("Que pena! Saliendo del programa ...");
                    break;
                default:
                    System.out.println("Elija una opcion valida!");
                    break;
            }
            System.out.println();
        }
        entrada.close(); //cerramos la entrada de texto Scanner para liberar recursos.
    }
}
