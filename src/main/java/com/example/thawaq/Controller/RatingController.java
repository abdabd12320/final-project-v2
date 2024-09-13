package com.example.thawaq.Controller;

import com.example.thawaq.Api.ApiResponse;
import com.example.thawaq.Model.Rating;
import com.example.thawaq.Service.RatingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rating")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;
    @GetMapping("/get-all")
    public ResponseEntity getAllRatings() {
        return ResponseEntity.status(200).body(ratingService.getAllRatings());
    }

    @PostMapping("/user/add-rating/{userId}/{storeId}")  //v2
    public ResponseEntity addRatingFromUserToStore(@PathVariable Integer userId,@PathVariable Integer storeId,@Valid @RequestBody Rating rating) {
        ratingService.addRatingFromUserToStore(userId,storeId,rating);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully added rating to store!"));
    }
    @PostMapping("/expert/add-rating/{expertId}/{storeId}")  //v2
    public ResponseEntity addRatingFromExpertToStore(@PathVariable Integer expertId,@PathVariable Integer storeId,@Valid @RequestBody Rating rating) {
        ratingService.addRatingFromExpertToStore(expertId, storeId, rating);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully added rating to store!"));
    }

    @PutMapping("/update-rating/{id}")
    public ResponseEntity updateRatingToStore(@PathVariable Integer id,@Valid @RequestBody Rating rating) {
        ratingService.updateRating(rating,id);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully updated rating!"));}


    @DeleteMapping("/delete-rating/{id}")
    public ResponseEntity deleteRating(@PathVariable Integer id) {
        ratingService.deleteRating(id);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully deleted rating!"));}

    @GetMapping("/get-both-by-cleaning-of-rating")  //v2
    public ResponseEntity getBOTHByCleaningOfRating()
    {
        return ResponseEntity.status(200).body(ratingService.getBOTHByCleaningOfRating());
    }
    @GetMapping("/get-restaurant-by-cleaning-of-rating")  //v2
    public ResponseEntity getRestaurantByCleaningOfRating()
    {
        return ResponseEntity.status(200).body(ratingService.getRestaurantByCleaningOfRating());
    }
    @GetMapping("/get-cafe-by-cleaning-of-rating")  //v2
    public ResponseEntity getCafeByCleaningOfRating()
    {
        return ResponseEntity.status(200).body(ratingService.getCafeByCleaningOfRating());
    }
//    @GetMapping("/get-branch-both-by-cleaning-of-rating")
//    public ResponseEntity getBranchBOTHByCleaningOfRating()
//    {
//        return ResponseEntity.status(200).body(ratingService.getBranchBOTHByCleaningOfRating());
//    }
    @GetMapping("/get-rating-by-latest")  //v2
    public ResponseEntity getRatingByLatest()
    {
        return ResponseEntity.status(200).body(ratingService.getRatingByLatest());
    }
    @GetMapping("/get-rating-by-high")  //v2
    public ResponseEntity getRatingByHigh()
    {
        return ResponseEntity.status(200).body(ratingService.getRatingByHigh());
    }
    @GetMapping("/get-rating-by-low")  //v2
    public ResponseEntity getRatingByLow()
    {
        return ResponseEntity.status(200).body(ratingService.getRatingByLow());
    }
    @GetMapping("/get-rating-by-comment/{comment}")  //v2
    public ResponseEntity getRatingByComment(@PathVariable String comment)
    {
        return ResponseEntity.status(200).body(ratingService.getRatingByComment(comment));
    }
}
