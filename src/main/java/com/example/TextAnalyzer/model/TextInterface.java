package com.example.TextAnalyzer.model;

import java.util.Map;

public interface TextInterface {
    public abstract String getLanguage();
    public Map<Integer, Integer> numberQuantity();
    public int sentenceCount();
    public void exchangeSymbol(char ch1, char ch2);
    void setText(String text);
    public String getText();
    public void changeToLatin();


}
