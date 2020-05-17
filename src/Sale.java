import java.util.Map;

public class Sale {
    private Catalog catalog;
    private Display display;

    public Sale(Catalog catalog, Display display) {
        this.catalog = catalog;
        this.display = display;
    }

    public void onBarcode(String barcode) {
        // SMELL Refused bequest: move this up the call stack?
        if ("".equals(barcode)) {
            display.displayEmptyBarcodeMessage();
            return;
        }

        final String priceAsText = catalog.findPrice(barcode);
        if (priceAsText == null) {
            display.displayProductNotFoundMessage(barcode);
        } else {
            display.displayPrice(priceAsText);
        }
    }

    private static class Catalog {
        private final Map<String, String> pricesByBarcode;

        private Catalog(Map<String, String> pricesByBarcode) {
            this.pricesByBarcode = pricesByBarcode;
        }

        public Map<String, String> getPricesByBarcode() {
            return pricesByBarcode;
        }

        public String findPrice(String barcode) {
            return pricesByBarcode.get(barcode);
        }
    }
}
