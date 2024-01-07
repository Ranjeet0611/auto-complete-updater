package com.autocompleteupdater.repository;

import com.autocompleteupdater.model.CompleteSearch;

import java.util.List;

public interface CustomAutoCompleteRepository {
    List<CompleteSearch> getCompleteSearchOfTwentyFourHours();
}
