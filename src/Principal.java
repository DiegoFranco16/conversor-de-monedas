import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int salir = 0;
        final int VALOR_SALIDA = 10;
        while (salir != VALOR_SALIDA) {
            String menuInicial = """
                    ************************************************
                    ¡Bienvenido/a al sistema conversor de moneadas!
                    
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileño
                    4) Real brasileño =>> Dólar                    
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Dólar =>> Renminbi chino
                    8) Renminbi chino =>> Dólar
                    9) Dólar =>> Cualquier moneda
                    10) Salir                    
                 
                    ************************************************
                    Elija una opción válida: 
                    """;
            System.out.print(menuInicial);
            int opcion = lectura.nextInt();
            String moneda1 = "";
            String moneda2 = "";
            double cantidad = 0;
            switch (opcion) {
                case 1:
                    moneda1 = "USD";
                    moneda2 = "ARS";
                    break;
                case 2:
                    moneda1 = "ARS";
                    moneda2 = "USD";
                    break;
                case 3:
                    moneda1 = "USD";
                    moneda2 = "BRL";
                    break;
                case 4:
                    moneda1 = "BRL";
                    moneda2 = "USD";
                    break;
                case 5:
                    moneda1 = "USD";
                    moneda2 = "COP";
                    break;
                case 6:
                    moneda1 = "COP";
                    moneda2 = "USD";
                    break;
                case 7:
                    moneda1 = "USD";
                    moneda2 = "CNY";
                    break;
                case 8:
                    moneda1 = "CNY";
                    moneda2 = "USD";
                    break;
                case 9:
                    moneda1 = "USD";
                    System.out.println("Escriba las tres letras de la moneda destino (Ej: GBP)");
                    moneda2 = lectura.next();
                    break;
                case VALOR_SALIDA:
                    salir = VALOR_SALIDA;
                    System.out.println("Gracias por usar nuestro sistema :)");
                    break;
                default:
                    System.out.println("La opción seleccionada no es válida, inténtelo de nuevo");
                    esperarEnter();
                    continue;
            }
            if (salir == VALOR_SALIDA) return;
            System.out.print("Ingrese la cantidad que desea convertir: ");
            try {
                cantidad = lectura.nextDouble();
                ConsultaMoneda consulta = new ConsultaMoneda();
                ConversionMoneda conversionMoneda;
                if(opcion ==9){
                    conversionMoneda = consulta.buscaConversionIndividual(moneda2, cantidad);
                } else {
                    conversionMoneda = consulta.buscaConversion(moneda1, moneda2, cantidad);
                }
                System.out.println("El valor " + cantidad + " [" + moneda1 + "] " + "corresponde al valor final de " +
                            "=>>> " + conversionMoneda.conversion_result() + " [" + moneda2 + "]");
                GeneradorDeArchivo generador = new GeneradorDeArchivo();
                generador.guardarJson(conversionMoneda);

            } catch (RuntimeException | IOException e) {
                System.out.println("La cantidad ingresada presenta errores: " + e.getMessage());
            } finally {
                esperarEnter();
            }

        }
    }

    public static void esperarEnter(){
        Scanner lectura = new Scanner(System.in);
        //lectura.nextLine(); //Limpiamos buffer del System.in
        System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR..."); //Mensaje en pantalla
        lectura.nextLine(); //Ahora el programa se detiene hasta que se pulse ENTER
    }
}
