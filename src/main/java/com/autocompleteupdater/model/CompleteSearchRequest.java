package com.autocompleteupdater.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CompleteSearchRequest {
    private String query;
    private Date currentDate;
}
