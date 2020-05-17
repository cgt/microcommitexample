public class Display {
    public void setText(String text) {
        // ...
    }

    public void displayPrice(String priceAsText) {
        setText(priceAsText);
    }

    public void displayProductNotFoundMessage(String barcode) {
        setText("Product not found for "
            + barcode);
    }
}
