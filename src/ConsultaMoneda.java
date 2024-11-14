import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

public class ConsultaMoneda {

    private final HttpClient client = HttpClient.newHttpClient();

    // Método para obtener la conversión con el API
    public ConversionMoneda buscaConversion(String moneda1, String moneda2, double cantidad) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/2a93fab3b8385295cb927991/pair/" + moneda1 + "/" + moneda2 + "/" + cantidad);
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Configura Gson para usar el TypeAdapter de LocalDateTime
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()) // Registra el adaptador
                    .create();

            ConversionMoneda conversionIndividual = gson.fromJson(response.body(), ConversionMoneda.class);
            return new ConversionMoneda(conversionIndividual.base_code(), conversionIndividual.target_code(), cantidad, conversionIndividual.conversion_result(), LocalDateTime.now());

        } catch (Exception e) {
            throw new RuntimeException("Error en la conversión de monedas: " + e.getMessage());
        }
    }

    // Otro método de consulta
    public ConversionMoneda buscaConversionIndividual(String moneda2, double cantidad) {
        URI direccion = URI.create("https://openexchangerates.org/api/latest.json?app_id=d7b6ea597a334d3cb2ccfc1969f8555e&symbols=" + moneda2);
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Configura Gson para usar el TypeAdapter de LocalDateTime
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()) // Registra el adaptador
                    .create();

            ConversionMonedaIndividual conversionIndividual = gson.fromJson(response.body(), ConversionMonedaIndividual.class);
            return new ConversionMoneda(conversionIndividual.base(), moneda2, cantidad, cantidad * conversionIndividual.rates().get(moneda2), LocalDateTime.now());
        } catch (Exception e) {
            throw new RuntimeException("Error en la conversión de monedas: " + e.getMessage());
        }
    }
}
