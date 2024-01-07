package com.autocompleteupdater.repository;

import com.autocompleteupdater.model.CompleteSearch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoCompleteRepository extends MongoRepository<CompleteSearch,String>,CustomAutoCompleteRepository {
}
