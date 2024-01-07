package com.autocompleteupdater.service.impl;

import com.autocompleteupdater.model.CompleteSearch;
import com.autocompleteupdater.service.MapService;
import com.autocompleteupdater.service.ReducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MapServiceImpl implements MapService {

    @Autowired
    private ReducerService reducerService;
    @Override
    public Map<String,String> createPrefixMap(List<CompleteSearch> completeSearchList) {
        log.info("Start createPrefixMap");
        List<String> topWords = reducerService.getTopWords(completeSearchList);
        Map<String, String> prefixMap = getPrefixMap(topWords);
        System.out.println(prefixMap);
        log.info("End createPrefixMap");
        return prefixMap;
    }

    private Map<String,String> getPrefixMap(List<String> completeSearchList) {
        log.info("Start getPrefixMap");
        Map<String,String> prefixMap = new HashMap<>();
        for(String completeSearch:completeSearchList){
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<completeSearch.length()-1;i++){
                stringBuilder.append(completeSearch.charAt(i));
                prefixMap.put(stringBuilder.toString(),completeSearch);
            }
        }
        log.info("End getPrefixMap");
        return prefixMap;
    }
}
