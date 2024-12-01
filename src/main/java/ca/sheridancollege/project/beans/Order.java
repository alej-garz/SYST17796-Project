package ca.sheridancollege.project.beans;

import java.sql.Date;
import lombok.Data;

@Data
public class Order {
    private Integer id;
    private Integer inventoryItemId; // To capture selected inventory item ID from form
    private InventoryItem inventoryItem; // Full InventoryItem object for displaying details
    private int quantityToOrder;
    private Date orderDate;
    private String status;
    private float totalCost;

    public Order() {
        this.status = "Pending";
        this.orderDate = new Date(System.currentTimeMillis());
    }

    public void setQuantityToOrder(int quantityToOrder) {
        if (quantityToOrder < 0) {
            throw new IllegalArgumentException("Quantity to order must be a positive value.");
        }
        this.quantityToOrder = quantityToOrder;
    }

    public float getTotalCost() {
        if (inventoryItem == null) {
            throw new IllegalStateException("Inventory item is not set.");
        }
        return quantityToOrder * inventoryItem.getPricePerUnit();
    }
}
