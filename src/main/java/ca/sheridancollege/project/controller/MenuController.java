package ca.sheridancollege.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import ca.sheridancollege.project.beans.MenuCategory;
import ca.sheridancollege.project.beans.MenuItem;
import ca.sheridancollege.project.database.DatabaseAccess;

@Controller
public class MenuController {

    @Autowired
    private DatabaseAccess da;

    @GetMapping("/menu")
    public String menuItems(Model model) {
        model.addAttribute("menuItem", new MenuItem());
        model.addAttribute("menuItemList", da.getMenuItemList()); 
        model.addAttribute("categories", MenuCategory.values()); 
        return "menu";
    }

    @PostMapping("/insertMenuItem")
    public String menuForm(Model model, @ModelAttribute MenuItem menuItem ) {
    	
    	if (menuItem.getId() == null) {
    		da.insertMenuItem(menuItem);
    	}else {
    		da.updateMenuItem(menuItem);
    	}
    	
        model.addAttribute("menuItem", new MenuItem());
        model.addAttribute("menuItemList", da.getMenuItemList());
        model.addAttribute("categories", MenuCategory.values());
        return "redirect:/menu";  
    }
    
    @GetMapping("/deleteMenuItemById/{id}")
    public String deleteStudentById(Model model, @PathVariable Long id) {
		da.deleteMenuItemById(id);
		model.addAttribute("MenuItem", new MenuItem());
		model.addAttribute("MenuItem", da.getMenuItemList());
		return "redirect:/menu";
    };
    
    @GetMapping("/editMenuItemById/{id}")
    public String editMenuItemById(Model model, @PathVariable Long id) {
        // Fetch the item by ID
        List<MenuItem> menuItems = da.getMenuItemListById(id);

        if (menuItems.isEmpty()) {
            model.addAttribute("menuItem", new MenuItem()); 
            model.addAttribute("menuItemList", da.getMenuItemList()); 
            model.addAttribute("categories", MenuCategory.values()); 
            return "menu";
        }

        MenuItem menuItem = menuItems.get(0);
        

        model.addAttribute("menuItem", menuItem);
        model.addAttribute("menuItemList", da.getMenuItemList());
        model.addAttribute("categories", MenuCategory.values());

        return "menu";
    }

}
