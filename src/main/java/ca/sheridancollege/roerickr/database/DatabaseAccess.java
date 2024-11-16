package ca.sheridancollege.roerickr.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.roerickr.beans.InventoryItem;
import ca.sheridancollege.roerickr.beans.MenuItem;
import ca.sheridancollege.roerickr.beans.Order;
import ca.sheridancollege.roerickr.beans.Units;

@Repository
public class DatabaseAccess {

    @Autowired
    protected NamedParameterJdbcTemplate jdbc;

    // ----------------------- Menu Item Methods -----------------------

    public void insertMenuItem(MenuItem menuItem) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("itemName", menuItem.getName());
        namedParameters.addValue("itemDescription", menuItem.getDescription());
        namedParameters.addValue("itemPrice", menuItem.getPrice());
        namedParameters.addValue("itemCategory", menuItem.getCategory().toString());
        namedParameters.addValue("itemAvailable", menuItem.getAvailable());

        String query = "INSERT INTO menu_items(name, description, price, category, available) VALUES(:itemName, :itemDescription, :itemPrice, :itemCategory, :itemAvailable)";
        jdbc.update(query, namedParameters);
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
        jdbc.update(query, namedParameters);
    }

    public List<MenuItem> getMenuItemList() {
        String query = "SELECT * FROM menu_items ORDER BY id";
        return jdbc.query(query, new MapSqlParameterSource(), new BeanPropertyRowMapper<>(MenuItem.class));
    }

    public void deleteMenuItemById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        String query = "DELETE FROM menu_items WHERE id = :id";
        jdbc.update(query, namedParameters);
    }

    public List<MenuItem> getMenuItemListById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        String query = "SELECT * FROM menu_items WHERE id = :id";
        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<>(MenuItem.class));
    }

    // ----------------------- Inventory Item Methods -----------------------

    public void insertInventoryItem(InventoryItem inventoryItem) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", inventoryItem.getName());
        namedParameters.addValue("quantity", inventoryItem.getQuantity());
        namedParameters.addValue("unit", inventoryItem.getUnit().toString());
        namedParameters.addValue("pricePerUnit", inventoryItem.getPricePerUnit());

        String query = "INSERT INTO inventory_items (name, quantity, unit, price_per_unit) VALUES (:name, :quantity, :unit, :pricePerUnit)";
        jdbc.update(query, namedParameters);
    }

    public void updateInventoryItem(InventoryItem inventoryItem) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", inventoryItem.getId());
        namedParameters.addValue("name", inventoryItem.getName());
        namedParameters.addValue("quantity", inventoryItem.getQuantity());
        namedParameters.addValue("unit", inventoryItem.getUnit().toString());
        namedParameters.addValue("pricePerUnit", inventoryItem.getPricePerUnit());

        String query = "UPDATE inventory_items SET name = :name, quantity = :quantity, unit = :unit, price_per_unit = :pricePerUnit WHERE id = :id";
        jdbc.update(query, namedParameters);
    }

    public List<InventoryItem> getInventoryItemList() {
        String query = "SELECT * FROM inventory_items ORDER BY id";
        return jdbc.query(query, new MapSqlParameterSource(), new BeanPropertyRowMapper<>(InventoryItem.class));
    }

    public void deleteInventoryItemById(Integer id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        String query = "DELETE FROM inventory_items WHERE id = :id";
        jdbc.update(query, namedParameters);
    }

    public InventoryItem getInventoryItemById(Integer id) {
        String query = "SELECT * FROM inventory_items WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        return jdbc.queryForObject(query, namedParameters, new BeanPropertyRowMapper<>(InventoryItem.class));
    }

    // ----------------------- Order Methods -----------------------

    public List<Order> getOrderList() {
        String query = "SELECT o.id, o.quantity_to_order, o.order_date, o.status, " +
                       "i.id AS inventoryItem_id, i.name, i.quantity, i.unit, i.price_per_unit " +
                       "FROM orders o JOIN inventory_items i ON o.inventory_item_id = i.id";

        return jdbc.query(query, (rs, rowNum) -> {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setQuantityToOrder(rs.getInt("quantity_to_order"));
            order.setOrderDate(rs.getDate("order_date"));
            order.setStatus(rs.getString("status"));

            InventoryItem item = new InventoryItem();
            item.setId(rs.getInt("inventoryItem_id"));
            item.setName(rs.getString("name"));
            item.setQuantity(rs.getInt("quantity"));
            item.setUnit(Units.valueOf(rs.getString("unit"))); // Convert String to Units enum
            item.setPricePerUnit(rs.getFloat("price_per_unit"));

            order.setInventoryItem(item); // Attach InventoryItem to the Order
            return order;
        });
    }

    public void insertOrder(Order order) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("inventoryItemId", order.getInventoryItem().getId());
        namedParameters.addValue("quantityToOrder", order.getQuantityToOrder());
        namedParameters.addValue("orderDate", order.getOrderDate());
        namedParameters.addValue("status", order.getStatus());

        String query = "INSERT INTO orders (inventory_item_id, quantity_to_order, order_date, status) " +
                       "VALUES (:inventoryItemId, :quantityToOrder, :orderDate, :status)";

        jdbc.update(query, namedParameters);
    }

    public Order getOrderById(Integer id) {
        String query = "SELECT o.id, o.quantity_to_order, o.order_date, o.status, " +
                       "i.id AS inventoryItem_id, i.name, i.quantity, i.unit, i.price_per_unit " +
                       "FROM orders o JOIN inventory_items i ON o.inventory_item_id = i.id WHERE o.id = :id";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);

        return jdbc.queryForObject(query, namedParameters, (rs, rowNum) -> {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setQuantityToOrder(rs.getInt("quantity_to_order"));
            order.setOrderDate(rs.getDate("order_date"));
            order.setStatus(rs.getString("status"));

            InventoryItem item = new InventoryItem();
            item.setId(rs.getInt("inventoryItem_id"));
            item.setName(rs.getString("name"));
            item.setQuantity(rs.getInt("quantity"));
            item.setUnit(Units.valueOf(rs.getString("unit"))); // Convert String to Units enum
            item.setPricePerUnit(rs.getFloat("price_per_unit"));

            order.setInventoryItem(item); // Attach InventoryItem to the Order
            return order;
        });
    }

    public void updateOrder(Order order) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", order.getId());
        namedParameters.addValue("inventoryItemId", order.getInventoryItem().getId());
        namedParameters.addValue("quantityToOrder", order.getQuantityToOrder());
        namedParameters.addValue("orderDate", order.getOrderDate());
        namedParameters.addValue("status", order.getStatus());

        String query = "UPDATE orders SET inventory_item_id = :inventoryItemId, quantity_to_order = :quantityToOrder, " +
                       "order_date = :orderDate, status = :status WHERE id = :id";

        jdbc.update(query, namedParameters);
    }

    public void updateOrderStatus(Integer orderId, String status) {
        String query = "UPDATE orders SET status = :status WHERE id = :orderId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("status", status);
        params.addValue("orderId", orderId);

        jdbc.update(query, params);
    }
}