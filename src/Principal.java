public class Principal {
    public static void main(String[] args) {
        ConsultaMoneda consulta = new ConsultaMoneda();
        ConversionMoneda conversionMoneda = consulta.buscaConversion("COP", "USD", 200);
        System.out.println(conversionMoneda);

    }
}
