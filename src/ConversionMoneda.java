import java.time.LocalDateTime;

public record ConversionMoneda(String base_code, String target_code, double amount, double conversion_result, LocalDateTime timestamp) {
}