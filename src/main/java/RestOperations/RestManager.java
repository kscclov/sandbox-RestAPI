package RestOperations;

public class RestManager {

    private OperationAddProduct operationAddProduct;
    private static RestManager restManager;


    private RestManager() {}

    public static RestManager getRestManager() {
        if (restManager == null) {
            restManager = new RestManager();
        }
        return restManager;
    }

    public OperationAddProduct getAddProductOperation() {
        if (operationAddProduct == null) {
            operationAddProduct = new OperationAddProduct();
        }
        return operationAddProduct;
    }
}
