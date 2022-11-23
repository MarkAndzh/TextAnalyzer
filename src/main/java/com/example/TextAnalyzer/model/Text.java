package com.example.TextAnalyzer.model;

import java.util.HashMap;
import java.util.Map;

//import static com.example.TextAnalyzer.model.MapCyrillicLatin;

abstract class Text implements TextInterface {
    String text;

    public abstract String getLanguage();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<Integer, Integer> numberQuantity() {
        Map<Integer, Integer> numbersMap = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {

                if (numbersMap.containsKey(Character.getNumericValue(text.charAt(i)))) {
                    int count = numbersMap.get(Character.getNumericValue(text.charAt(i)));
                    numbersMap.put(Character.getNumericValue(text.charAt(i)), count + 1);
                } else {
                    numbersMap.put(Character.getNumericValue(text.charAt(i)), 1);
                }

            }
        }

        return numbersMap;
    }

    public int sentenceCount() {
        int sentenceCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '.' || text.charAt(i) == '?' || text.charAt(i) == '!' || text.charAt(i) == ';') {
                sentenceCount++;
                while (i!=text.length()) {
                    if (!(text.charAt(i) == '.')) {
                        break;
                    }
                    i++;
                }
            }
        }
        return sentenceCount;
    }

    public void exchangeSymbol(char ch1, char ch2){
        for (int i=0; i<text.length(); i++){
            if (text.charAt(i) == ch1){
                char[] textChars = text.toCharArray();
                textChars[i] = ch2;
                text = String.valueOf(textChars);
            }
        }
    }

    public void changeToLatin(){
        MapCyrillicLatin map = new MapCyrillicLatin();
        char[] textChars = new char[text.length()];
        textChars = text.toCharArray();
        for (int i=0; i<text.length(); i++){
//            if (text.charAt(i) == ch1)
                if (map.cyrillicLatinMap.containsKey(textChars[i])){
                    textChars[i] = map.cyrillicLatinMap.get(textChars[i]);
                }
//            }
        }
        text = String.valueOf(textChars);


    }

}
