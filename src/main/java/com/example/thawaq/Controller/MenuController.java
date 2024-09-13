package com.example.thawaq.Controller;

import com.example.thawaq.Model.Menu;
import com.example.thawaq.Service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/menu")
@AllArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/get")
    public ResponseEntity getAllMenu() {
        return ResponseEntity.status(200).body(menuService.getAllMenus());
    }
    @PostMapping("/add/{CategoryId}")
    public ResponseEntity addMenu(@RequestBody Menu menu,@PathVariable Integer CategoryId) {
        menuService.addMenu(menu,CategoryId);
        return ResponseEntity.status(200).body("added successfully");

    }
    @PutMapping("/update/{MenuId}/{CategoryId}")
    public ResponseEntity updateMenu(@RequestBody Menu menu,@PathVariable Integer MenuId,@PathVariable Integer CategoryId) {
        menuService.updateMenu(menu,MenuId,CategoryId);
        return ResponseEntity.status(200).body("updated successfully");
    }

    @DeleteMapping("/delete/{MenuId}")
    public ResponseEntity deleteMenu(@PathVariable Integer MenuId) {
        menuService.deleteMenu(MenuId);
        return ResponseEntity.status(200).body("deleted successfully");
    }
}
