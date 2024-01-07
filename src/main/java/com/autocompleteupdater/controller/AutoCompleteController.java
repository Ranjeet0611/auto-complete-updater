package com.autocompleteupdater.controller;

import com.autocompleteupdater.model.CompleteSearchRequest;
import com.autocompleteupdater.model.SuccessResponse;
import com.autocompleteupdater.service.AutoCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autocomplete/v1")
public class AutoCompleteController {

    @Autowired
    private AutoCompleteService autoCompleteService;

    @PostMapping("/complete")
    public ResponseEntity<SuccessResponse<String>> addCompleteSearch(@RequestBody CompleteSearchRequest completeSearchRequest){
        autoCompleteService.addCompleteSearch(completeSearchRequest);
        SuccessResponse<String> successResponse = new SuccessResponse.SuccessResponseBuilder<String>()
                .setData("SUCCESS")
                .setStatus(HttpStatus.OK.name()).
                setTime().
                build();
        return new ResponseEntity<>(successResponse,HttpStatus.OK);
    }
}
