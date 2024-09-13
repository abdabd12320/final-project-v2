package com.example.thawaq.Controller;

import com.example.thawaq.Api.ApiResponse;
import com.example.thawaq.Model.Request;
import com.example.thawaq.Service.RequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/request")
@RequiredArgsConstructor
public class RequestController {
    private final RequestService requestService;

    @GetMapping("/get-all")
    public ResponseEntity getAllRatings() {
        return ResponseEntity.status(200).body(requestService.getAllRequests());
    }

    @PostMapping("/add-request")
    public ResponseEntity addRequest(@Valid @RequestBody Request request) {
        requestService.addRequest(request);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully added request !"));
    }

    @PutMapping("/update-request/{id}")
    public ResponseEntity updateRequest(@PathVariable Integer id, @Valid @RequestBody Request request) {
        requestService.updateRequest(request,id);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully updated request!"));}


    @DeleteMapping("/delete-request/{id}")
    public ResponseEntity deleteRequest(@PathVariable Integer id) {
        requestService.deleteRequest(id);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully deleted request!"));}
}
