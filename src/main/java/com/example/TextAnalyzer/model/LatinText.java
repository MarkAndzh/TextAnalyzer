package com.example.TextAnalyzer.model;

public class LatinText extends Text{
    @Override
    public String getLanguage() {
        return "Latin";
    }

    public LatinText(String text){
        this.text = text;
    }

    public LatinText(LatinText latinText){
        this.text = latinText.getText();
    }

    public LatinText(){
        this.text = "";
    }

}
