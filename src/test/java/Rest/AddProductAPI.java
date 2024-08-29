package Rest;

import Rest.basetest.BaseTest;
import RestOperations.product.Product;
import RestOperations.product.ProductData;
import org.junit.jupiter.api.Test;

public class AddProductAPI extends BaseTest {

    /**
     * Получаем данные продукта из файла JSON
     */
    private final ProductData fruitExotic = new ProductData(
            Product.getProductFromJson("passionFruit.json")
    );

    /**
     * Прогонка теста:
     * 1 - Получаем количество выведенных на страницу товаров
     * 2 - Посылаем запрос на добавление нового товара
     * 3 - Сравниваем количество ранее выведенных на страницу товаров с количеством товаров после запроса на добавление товара
     * 4 - Сравниваем значение выводимого товара с данными товара, которые были отправлены в запросе в п.2
     */
    @Test
    public void testAddProduct() {
        restManager.getAddProductOperation()
                .setCurrentEntriesCount()
                .executeAddProductRequest(fruitExotic)
                .checkEntriesCountAfterAddProduct()
                .checkAddedProductPresence(fruitExotic);
    }

}
