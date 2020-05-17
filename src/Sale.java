import java.util.Map;

public class Sale {
    private Display display;
    private Map<String, String> pricesByBarcode;

    public Sale(Catalog catalog, Display display) {
        this.display = display;
        this.pricesByBarcode = catalog.getPricesByBarcode();
    }

    public void onBarcode(String barcode) {
        // SMELL Refused bequest: move this up the call stack?
        if ("".equals(barcode)) {
            display.displayEmptyBarcodeMessage();
            return;
        }

        final String priceAsText = findPrice(barcode);
        if (priceAsText == null) {
            display.displayProductNotFoundMessage(barcode);
        } else {
            display.displayPrice(priceAsText);
        }
    }

    private String findPrice(String barcode) {
        return pricesByBarcode.get(barcode);
    }

    private static class Catalog {
        private final Map<String, String> pricesByBarcode;

        private Catalog(Map<String, String> pricesByBarcode) {
            this.pricesByBarcode = pricesByBarcode;
        }

        public Map<String, String> getPricesByBarcode() {
            return pricesByBarcode;
        }
    }
}
