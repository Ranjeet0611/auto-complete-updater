package com.autocompleteupdater.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@Document("complete_search_map")
public class CompleteSearch {
    @Id
    private String id;
    @Field
    private String query;
    @Field
    private Date currentDate;
}
