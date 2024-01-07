package com.autocompleteupdater.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WordCountPair implements Comparable<WordCountPair> {
    private String word;
    private int count;

    @Override
    public int compareTo(WordCountPair wordCountPair) {
        if(this.count < wordCountPair.getCount()){
            return 1;
        }
        else if(this.count > wordCountPair.getCount()){
            return -1;
        }
        return this.word.compareTo(wordCountPair.getWord());
    }
}
