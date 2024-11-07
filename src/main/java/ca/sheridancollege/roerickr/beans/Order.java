package ca.sheridancollege.roerickr.beans;

import java.sql.Date;

import lombok.Data;

@Data
public class Order {
	private Integer id;
	private InventoryItem inventoryItem;
	private int quantityToOrder;
	private Date orderDate;
	private String status;
}

