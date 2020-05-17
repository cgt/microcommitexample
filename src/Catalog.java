import java.util.Map;

public class Catalog {
    private final Map<String, String> pricesByBarcode;

    private Catalog(Map<String, String> pricesByBarcode) {
        this.pricesByBarcode = pricesByBarcode;
    }

    public String findPrice(String barcode) {
        return pricesByBarcode.get(barcode);
    }
}
