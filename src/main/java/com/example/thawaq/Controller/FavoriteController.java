package com.example.thawaq.Controller;

import com.example.thawaq.Model.Favorite;
import com.example.thawaq.Service.FavoriteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/favorite")
@AllArgsConstructor
public class FavoriteController {
    private final FavoriteService favoriteService;

    @PostMapping("/add/{MenuId}")
    public ResponseEntity addLike(@RequestBody Favorite favorite, @PathVariable Integer MenuId) {
        favoriteService.AddFavorite(favorite,MenuId);
        return ResponseEntity.status(200).body("add favorite successfully");
    }






    @DeleteMapping("/delete/{favoriteId}")
    public ResponseEntity deleteLike(@PathVariable Integer favoriteId) {
        favoriteService.DeleteFavorite(favoriteId);
        return ResponseEntity.status(200).body("delete favorite successfully");
    }
}
