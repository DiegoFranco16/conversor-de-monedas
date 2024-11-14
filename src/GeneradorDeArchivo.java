import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GeneradorDeArchivo {
    private static final String FILE_NAME = "Historial_conversion_de_monedas.json";
    public void guardarJson(ConversionMoneda conversionMoneda) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<ConversionMoneda> historialTransacciones = new ArrayList<>();
        // Verificar si el archivo existe
        File archivo = new File(FILE_NAME);
        if (archivo.exists()) {
            // Leer las transacciones existentes en el archivo
            FileReader lector = new FileReader(archivo);
            Type tipoLista = new TypeToken<List<ConversionMoneda>>(){}.getType();
            historialTransacciones = gson.fromJson(lector, tipoLista);
            lector.close();
        }
        // Agregar la nueva transacción a la lista
        historialTransacciones.add(conversionMoneda);
        // Guardar la lista actualizada en el archivo
        FileWriter escritura = new FileWriter(FILE_NAME);
        gson.toJson(historialTransacciones, escritura);
        escritura.close();

//        FileWriter escritura = new FileWriter("Historial conversion de monedas" + ".json");
//        escritura.write(gson.toJson(conversionMoneda));
//        escritura.close();
    }
}