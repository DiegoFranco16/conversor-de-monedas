import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    //Método para devolver la moneda luego de consultar la API
    public ConversionMoneda buscaConversion(String moneda1, String moneda2, double cantidad){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/2a93fab3b8385295cb927991/pair/" +
                moneda1 + "/" + moneda2 + "/" + cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConversionMoneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No es posible realizar la conversión de monedas");
        }
    }

    public ConversionMoneda buscaConversionIndividual(String moneda2, double cantidad){
        URI direccion = URI.create("https://openexchangerates.org/api/latest.json?app_id=d7b6ea597a334d3cb2ccfc1969f8555e&symbols=" +
                moneda2);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            ConversionMonedaIndividual conversionIndividual= new Gson().fromJson(response.body(), ConversionMonedaIndividual.class);
            ConversionMoneda conversion = new ConversionMoneda(conversionIndividual.base(), moneda2, cantidad * conversionIndividual.rates().get(moneda2));

            return conversion;
        } catch (Exception e) {
            throw new RuntimeException("No es posible realizar la conversión de monedas");
        }
    }
}
