package com.example.thawaq.Service;


import com.example.thawaq.Api.ApiException;
import com.example.thawaq.Model.Favorite;
import com.example.thawaq.Model.Menu;
import com.example.thawaq.Repository.FavoriteRepository;
import com.example.thawaq.Repository.MenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final MenuRepository menuRepository;

    public void AddFavorite(Favorite favorite, Integer MenuId) {
        Menu menu = menuRepository.findMenuById(MenuId);
        if (menu==null){
            throw new ApiException("can not add favorite");
        }
        favorite.setMenu(menu);
        favoriteRepository.save(favorite);
    }

    public void DeleteFavorite(Integer favoriteId) {
        Favorite favorite = favoriteRepository.findFavoriteById(favoriteId);
        if (favorite ==null){
            throw new ApiException("can not delete favorite");
        }
        favoriteRepository.delete(favorite);

    }


}
