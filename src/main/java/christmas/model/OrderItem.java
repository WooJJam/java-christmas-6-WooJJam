package christmas.model;

public class OrderItem {
    private final String menu;
    private final int quantity;

    public OrderItem(String menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public String getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }
}
