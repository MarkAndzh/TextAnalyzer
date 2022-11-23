package com.example.TextAnalyzer.model;

import java.util.HashMap;
import java.util.Map;

public class CustomText extends Text implements FindPercentage{
    private int autochange = 0;

    public CustomText(String text){
        this.text = text;
    }

    public CustomText(CustomText customText) {
        this.text = customText.getText();
    }

    @Override
    public String getLanguage() {
        int isCyrillic = 0;
        int isLatin = 0;
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char character = text.charAt(i);
            int ascii = character;
            if (ascii < 128) {
                isLatin = 1;
            } else if (ascii > 128) {
                isCyrillic = 1;
            }

            if (isLatin == 1 && isCyrillic == 1) {
                return "Unknown";
            }
        }
        if (isLatin == 1) return "Latin";
        else if (isCyrillic == 1) return "Cyrillic";

        return "Unknown";
    }

    public String getCharLanguage(char ch){
        int ascii = ch;
        if (ascii < 128) {
            return "Latin";
        } else if (ascii > 128) {
            return "Cyrillic";
        }
        return "Unknown";
    }


    public double latinPercentage(){
        if (getLanguage() == "Cyrillic") return 0;
        else if (getLanguage() == "Latin") return 100;
        int latinCount = 0;
        int cyrillicCount = 0;
        int unknown = 0;
        for (int i=0; i<text.length(); i++){
            if (getCharLanguage(text.charAt(i)) == "Latin"){
                latinCount++;
            }
            else if(getCharLanguage(text.charAt(i)) == "Cyrillic"){
                cyrillicCount++;
            }
            else{
                unknown++;
            }
        }

        double value = ((double)latinCount/((double)(latinCount+cyrillicCount)))*100;
        return value;
    }


}
