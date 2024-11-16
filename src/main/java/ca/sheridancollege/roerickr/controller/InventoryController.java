package ca.sheridancollege.roerickr.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import ca.sheridancollege.roerickr.beans.InventoryItem;
import ca.sheridancollege.roerickr.beans.Units;
import ca.sheridancollege.roerickr.database.DatabaseAccess;

@Controller
public class InventoryController {

    @Autowired
    private DatabaseAccess da;

    @GetMapping("/inventory")
    public String inventoryItems(Model model) {
        model.addAttribute("inventoryItem", new InventoryItem());
        model.addAttribute("inventoryItemList", da.getInventoryItemList());
        model.addAttribute("units", Units.values());
        return "inventory";
    }

    @PostMapping("/insertInventoryItem")
    public String addInventoryItem(Model model, @ModelAttribute InventoryItem inventoryItem) {
        if (inventoryItem.getId() == null) {
            da.insertInventoryItem(inventoryItem);
        } else {
            da.updateInventoryItem(inventoryItem);
        }
        return "redirect:/inventory";
    }

    @GetMapping("/deleteInventoryItemById/{id}")
    public String deleteInventoryItemById(@PathVariable Integer id) {
        da.deleteInventoryItemById(id);
        return "redirect:/inventory";
    }

    @GetMapping("/editInventoryItemById/{id}")
    public String editInventoryItemById(Model model, @PathVariable Integer id) {
        InventoryItem inventoryItem = da.getInventoryItemById(id);
        model.addAttribute("inventoryItem", inventoryItem);
        model.addAttribute("inventoryItemList", da.getInventoryItemList());
        model.addAttribute("units", Units.values());
        return "inventory";
    }
}
