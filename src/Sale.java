import java.util.Map;

public class Sale {
    private Display display;
    private Map<String, String> pricesByBarcode;

    public Sale(Map<String, String> pricesByBarcode, Display display) {
        this.display = display;
        this.pricesByBarcode = pricesByBarcode;
    }

    public void onBarcode(String barcode) {
        // SMELL Refused bequest: move this up the call stack?
        if ("".equals(barcode)) {
            displayEmptyBarcodeMessage();
            return;
        }

        final String priceAsText = findPrice(barcode);
        if (priceAsText == null) {
            displayProductNotFoundMessage(barcode);
        } else {
            display.displayPrice(priceAsText);
        }
    }

    private String findPrice(String barcode) {
        return pricesByBarcode.get(barcode);
    }

    private void displayProductNotFoundMessage(String barcode) {
        display.setText("Product not found for "
            + barcode);
    }

    private void displayEmptyBarcodeMessage() {
        display.setText("Scanning error: empty barcode");
    }
}
