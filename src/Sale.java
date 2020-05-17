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

        if (pricesByBarcode.containsKey(barcode))
            display.setText(pricesByBarcode.get(barcode));
        else
            display.setText("Product not found for "
                + barcode);
    }

    private void displayEmptyBarcodeMessage() {
        display.setText("Scanning error: empty barcode");
    }
}
