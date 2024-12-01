

package ca.sheridancollege.project.beans;

import lombok.Data;

@Data
public class MenuItem {
	private Integer id;
	private String name;
	private String description;
	private float price;
	private MenuCategory category;
	private Boolean available;
	
}
