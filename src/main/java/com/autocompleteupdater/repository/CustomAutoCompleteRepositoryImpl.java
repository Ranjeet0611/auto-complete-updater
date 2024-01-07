package com.autocompleteupdater.repository;

import com.autocompleteupdater.model.CompleteSearch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Slf4j
public class CustomAutoCompleteRepositoryImpl implements CustomAutoCompleteRepository {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<CompleteSearch> getCompleteSearchOfTwentyFourHours() {
        log.info("Start getCompleteSearchOfTwentyFourHours");
        Query query = new Query();
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime twentyFourHoursAgo = currentDate.minusHours(24);

        Date fromDate = Date.from(twentyFourHoursAgo.atZone(ZoneId.systemDefault()).toInstant());
        Date toDate = Date.from(currentDate.atZone(ZoneId.systemDefault()).toInstant());

        query.addCriteria(Criteria.where("currentDate").gte(fromDate).lte(toDate));
        log.info("Query :{}",query);
        return mongoTemplate.find(query, CompleteSearch.class);
    }
}
