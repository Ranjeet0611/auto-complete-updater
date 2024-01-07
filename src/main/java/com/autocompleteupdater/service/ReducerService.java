package com.autocompleteupdater.service;

import com.autocompleteupdater.model.CompleteSearch;

import java.util.List;

public interface ReducerService {
    List<String> getTopWords(List<CompleteSearch> completeSearchList);
}
