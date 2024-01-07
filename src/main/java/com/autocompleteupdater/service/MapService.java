package com.autocompleteupdater.service;

import com.autocompleteupdater.model.CompleteSearch;

import java.util.List;
import java.util.Map;

public interface MapService {
    Map<String,String> createPrefixMap(List<CompleteSearch> completeSearchList);
}
