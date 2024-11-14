import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class GeneradorDeArchivo {

    public void guardarJson(ConversionMoneda conversionMoneda) throws IOException {
        // Configura Gson para usar el TypeAdapter de LocalDateTime
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()) // Registra el adaptador
                .create();

        // Guarda el objeto como JSON en el archivo
        try (FileWriter escritura = new FileWriter("Historial conversion de monedas.json", true)) { // Uso del 'true' para agregar datos al archivo existente
            escritura.write(gson.toJson(conversionMoneda) + ",\n"); // Agrega cada transacción en una nueva línea
        }
    }
}
