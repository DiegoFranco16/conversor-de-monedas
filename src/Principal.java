import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int salir = 0;

        while (salir != 9) {
            String menuInicial = """
                    ************************************************
                    ¡Bienvenido/a al sistema conversor de moneadas!
                    
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Real brasileño =>> Dólar
                    4) Dólar =>> Real brasileño
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Dólar =>> Renminbi chino
                    8) Renminbi chino =>> Dólar
                    9) Salir                    
                 
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
                    salir = 9;
                    break;
                default:
                    System.out.println("La opción seleccionada no es válida, inténtelo de nuevo");
                    esperarEnter();
                    continue;
            }
            if (salir == 9) return;
            System.out.print("Ingrese la cantidad que desea convertir: ");
            try {
                cantidad = lectura.nextDouble();
                ConsultaMoneda consulta = new ConsultaMoneda();
                ConversionMoneda conversionMoneda = consulta.buscaConversion(moneda1, moneda2, cantidad);
                System.out.println("El valor " + cantidad + " [" + moneda1 + "] " + "corresponde al valor final de " +
                "=>>> " + conversionMoneda.conversion_result() + " [" + moneda2 + "]");
            } catch (RuntimeException e) {
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
