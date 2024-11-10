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
            throw new RuntimeException("Las monedas ingresadas no existen, verifique por favor");
        }
    }
}
