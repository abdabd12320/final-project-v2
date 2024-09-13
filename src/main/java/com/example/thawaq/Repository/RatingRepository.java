package com.example.thawaq.Repository;

import com.example.thawaq.Model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    Rating findRatingById(Integer id);

    List<Rating> findRatingByCommentContains(String comment);  //v2



}