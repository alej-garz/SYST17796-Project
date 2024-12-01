package ca.sheridancollege.project.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InventoryItem {
    private Integer id;
    private String name;
    private int quantity;
    private Units unit;  // Enum type Units
    private float pricePerUnit;
}
