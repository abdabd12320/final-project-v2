package com.example.thawaq.Service;

import com.example.thawaq.Api.ApiException;
import com.example.thawaq.Model.Request;
import com.example.thawaq.Repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RequestService {

    private final RequestRepository requestRepository;

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public void addRequest(Request request) {
        requestRepository.save(request);
    }

    public void updateRequest(Request request,Integer id) {
        Request request1 = requestRepository.findRequestById(id);
        if(request1 == null) {
            throw new ApiException("Request not found");
        }
        request1.setDescription(request.getDescription());
        request1.setStatus(request.getStatus());
        request1.setPrice(request.getPrice());
        request1.setRequestDate(request.getRequestDate());
        requestRepository.save(request1);}


    public void deleteRequest(Integer id) {
        Request r = requestRepository.findRequestById(id);
        if(r == null) {
            throw new ApiException("Request not found");
        }
        requestRepository.delete(r);
    }
}
