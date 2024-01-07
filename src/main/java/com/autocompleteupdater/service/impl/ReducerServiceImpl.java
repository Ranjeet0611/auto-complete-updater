package com.autocompleteupdater.service.impl;

import com.autocompleteupdater.model.CompleteSearch;
import com.autocompleteupdater.model.WordCountPair;
import com.autocompleteupdater.service.ReducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class ReducerServiceImpl implements ReducerService {

    @Value("${top.words.count}")
    private String topWordCount;
    @Override
    public List<String> getTopWords(List<CompleteSearch> completeSearchList) {
        log.info("Start getTopWords");
        Map<String,Integer> wordsCountMap = new HashMap<>();
        for(CompleteSearch completeSearch:completeSearchList){
            wordsCountMap.put(completeSearch.getQuery(),wordsCountMap.getOrDefault(completeSearch.getQuery(),0)+1);
        }
        List<String> topKWords = getTopKCount(wordsCountMap);
        log.info("Eng topKWords");
        return topKWords;
    }

    private List<String> getTopKCount(Map<String, Integer> wordsCountMap) {
        log.info("Start getTopKCount");
        PriorityQueue<WordCountPair> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        List<String> topWordsList = new ArrayList<>();
        wordsCountMap.forEach((key,value)->{
            priorityQueue.add(new WordCountPair(key,value));
        });
        int topCount = Integer.parseInt(topWordCount);
        while(!priorityQueue.isEmpty() && topCount>0){
            topWordsList.add(priorityQueue.poll().getWord());
            topCount--;
        }
        log.info("End getTopKCount");
        return topWordsList;
    }
}
