package com.example.thawaq.Repository;

import com.example.thawaq.Model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    Favorite findFavoriteById(Integer id);
}
