package ca.sheridancollege.roerickr.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ca.sheridancollege.roerickr.beans.Order;
import ca.sheridancollege.roerickr.beans.InventoryItem;
import ca.sheridancollege.roerickr.database.DatabaseAccess;

@Controller
public class OrderController {

    @Autowired
    private DatabaseAccess da;

    // Display the Order Management page
    @GetMapping("/order")
    public String orderPage(Model model) {
        List<Order> orderList = da.getOrderList();
        model.addAttribute("orderList", orderList);
        return "order"; // Renders order.html
    }

    // Display the Create Order page
    @GetMapping("/createOrder")
    public String createOrderPage(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("inventoryItemList", da.getInventoryItemList());
        return "createOrder"; // Renders createOrder.html
    }

    // Handle creating a new order
    @PostMapping("/submitOrder")
    public String submitOrder(@ModelAttribute Order order, RedirectAttributes redirectAttributes, Model model) {
        // If orderDate is null, set it to today's date
        if (order.getOrderDate() == null) {
            order.setOrderDate(Date.valueOf(LocalDate.now()));
        }

        // Validate InventoryItem and quantity
        if (order.getQuantityToOrder() > 0 && order.getInventoryItem() != null && order.getInventoryItem().getId() != null) {
            InventoryItem selectedInventoryItem = da.getInventoryItemById(order.getInventoryItem().getId());
            order.setInventoryItem(selectedInventoryItem);

            da.insertOrder(order);
            redirectAttributes.addFlashAttribute("message", "Order submitted successfully!");
        } else {
            model.addAttribute("message", "Please select an inventory item and enter a valid quantity.");
            model.addAttribute("inventoryItemList", da.getInventoryItemList());
            return "createOrder"; // Show the form again with an error
        }
        return "redirect:/order";
    }

    // Edit Order Page
    @GetMapping("/editOrder/{id}")
    public String editOrderPage(@PathVariable Integer id, Model model) {
        List<Order> orderList = da.getOrderList();
        Order order = orderList.stream()
                               .filter(o -> o.getId().equals(id))
                               .findFirst()
                               .orElse(null);

        if (order == null) {
            model.addAttribute("message", "Order not found.");
            return "redirect:/order";
        }

        model.addAttribute("order", order);
        model.addAttribute("inventoryItemList", da.getInventoryItemList());
        return "editOrder"; // Renders editOrder.html
    }

    // Handle updating an existing order
    @PostMapping("/updateOrder")
    public String updateOrder(@ModelAttribute Order order, RedirectAttributes redirectAttributes) {
        try {
            da.updateOrder(order);
            redirectAttributes.addFlashAttribute("message", "Order updated successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to update the order. Please check your inputs.");
            return "redirect:/editOrder/" + order.getId(); // Redirect back to edit page on error
        }
        return "redirect:/order";
    }
}
