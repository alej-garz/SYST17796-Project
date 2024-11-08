package ca.sheridancollege.outstandingjavadevelopersteam.beans;

import lombok.Data;

@Data
public class InventoryItem {
	private Integer id;
	private String name;
	private int quantity;
	private Units unit;
	private float pricePerUnit;
	
}
