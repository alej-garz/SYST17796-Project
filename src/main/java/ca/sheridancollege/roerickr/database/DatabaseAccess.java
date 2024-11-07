package ca.sheridancollege.roerickr.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.roerickr.beans.MenuItem;

@Repository
public class DatabaseAccess {

    @Autowired
    protected NamedParameterJdbcTemplate jdbc;

    public void insertMenuItem(MenuItem menuItem) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("itemName", menuItem.getName());
        namedParameters.addValue("itemDescription", menuItem.getDescription());
        namedParameters.addValue("itemPrice", menuItem.getPrice());
        namedParameters.addValue("itemCategory", menuItem.getCategory().toString()); 
        namedParameters.addValue("itemAvailable", menuItem.getAvailable());
        
        String query = "INSERT INTO menu_items(name, description, price, category, available) VALUES(:itemName, :itemDescription, :itemPrice, :itemCategory, :itemAvailable)";
        
        int rowsAffected = jdbc.update(query, namedParameters);
        if (rowsAffected > 0) {
            System.out.println("New menu item inserted into database");
        }
    }

    public void updateMenuItem(MenuItem menuItem) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", menuItem.getId());
        namedParameters.addValue("itemName", menuItem.getName());
        namedParameters.addValue("itemDescription", menuItem.getDescription());
        namedParameters.addValue("itemPrice", menuItem.getPrice());
        namedParameters.addValue("itemCategory", menuItem.getCategory().toString());
        namedParameters.addValue("itemAvailable", menuItem.getAvailable());

        String query = "UPDATE menu_items SET name = :itemName, description = :itemDescription, price = :itemPrice, category = :itemCategory, available = :itemAvailable WHERE id = :id";

        int rowsAffected = jdbc.update(query, namedParameters);
        if (rowsAffected > 0) {
            System.out.println("Menu item updated in database");
        }
    }

    public List<MenuItem> getMenuItemList() {
        String query = "SELECT * FROM menu_items ORDER BY id";
        return jdbc.query(query, new MapSqlParameterSource(), new BeanPropertyRowMapper<>(MenuItem.class));
    }

    public void deleteMenuItemById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "DELETE FROM menu_items WHERE id = :id";

        namedParameters.addValue("id", id);

        int rowsAffected = jdbc.update(query, namedParameters);
        if (rowsAffected > 0) {
            System.out.println("Deleted menu item with ID " + id + " from the database.");
        }
    }

    public List<MenuItem> getMenuItemListById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM menu_items WHERE id = :id";

        namedParameters.addValue("id", id);

        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<>(MenuItem.class));
    }
}

