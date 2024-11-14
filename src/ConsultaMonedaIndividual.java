import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMonedaIndividual {
    public ConversionMonedaIndividual buscaConversion(String moneda2){
        URI direccion = URI.create("https://openexchangerates.org/api/latest.json?app_id=d7b6ea597a334d3cb2ccfc1969f8555e&symbols=" +
                  moneda2);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConversionMonedaIndividual.class);
        } catch (Exception e) {
            throw new RuntimeException("No es posible realizar la conversión de monedas");
        }
    }
}
