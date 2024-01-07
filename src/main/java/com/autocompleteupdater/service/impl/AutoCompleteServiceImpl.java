package com.autocompleteupdater.service.impl;

import com.autocompleteupdater.model.CompleteSearch;
import com.autocompleteupdater.model.CompleteSearchRequest;
import com.autocompleteupdater.repository.AutoCompleteRepository;
import com.autocompleteupdater.service.AutoCompleteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class AutoCompleteServiceImpl implements AutoCompleteService {

    @Autowired
    private AutoCompleteRepository autoCompleteRepository;
    @Override
    public void addCompleteSearch(CompleteSearchRequest completeSearchRequest) {
        log.info("Start addCompleteSearch :{}",completeSearchRequest);
        try{
            if(Objects.isNull(completeSearchRequest)){
                throw new IllegalArgumentException("Request cannot be empty");
            }
            CompleteSearch completeSearch = new CompleteSearch();
            completeSearch.setId(UUID.randomUUID().toString());
            completeSearch.setQuery(completeSearchRequest.getQuery().toLowerCase());
            completeSearch.setCurrentDate(completeSearchRequest.getCurrentDate());
            autoCompleteRepository.save(completeSearch);
            log.info("End addCompleteSearch :{}",completeSearchRequest);
        }
        catch (Exception e){
            log.error("Exception occurred while addCompleteSearch :{}",e.getMessage(),e);
        }

    }
}
