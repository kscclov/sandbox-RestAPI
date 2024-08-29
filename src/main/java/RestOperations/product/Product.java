package RestOperations.product;

import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Getter
@Setter
@ToString
public class Product {
    private int id;
    private String name;
    private ProductType type;
    private boolean isExotic;

    public static Product getProductFromJson(String filename) {
        try {
            String fileContent = Files.readString(Paths.get("./src/test/resources", filename).toAbsolutePath().normalize());
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(fileContent, Product.class);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка прочтение или парсинга JSON файла: " + filename, e);
        }
    }
}

