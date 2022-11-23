package com.example.TextAnalyzer.model;

public class CyrillicText extends Text{
    @Override
    public String getLanguage() {
        return "Cyrillic";
    }

    public CyrillicText(String text) {
        this.text = text;
    }

    public CyrillicText(CyrillicText latinText){
        this.text = latinText.getText();
    }
}
