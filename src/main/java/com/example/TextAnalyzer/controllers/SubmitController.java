package com.example.TextAnalyzer.controllers;

import com.example.TextAnalyzer.model.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class SubmitController {
    private TextInterface textInt;
    private CustomText customText;
    private Character ch1;
    private Character ch2;

    @PostMapping("/input1")
    public String postMapping1(@RequestParam("text") String text, @Nullable @RequestParam("changeFrom") Character ch1,  @Nullable @RequestParam("changeTo") Character ch2, @Nullable @RequestParam("outputExport") boolean exportToFile, Model model) throws IOException {
        textInt = new LatinText(text);
        textInt.setText(text);
        this.ch1 = ch1; // implement
        this.ch2 = ch2; // implement
        String outputToFile = "";

        Map<Integer, Integer> numbersMap = textInt.numberQuantity();
        if(numbersMap.isEmpty()){
            model.addAttribute("result", "No numbers in text");
        }

        String[] resultList = new String[numbersMap.size()*2+1];

       //ERROR WITH FUNCTION NUMBERQUANTITY
        String sentencesCount = "";
        sentencesCount+= String.valueOf(textInt.sentenceCount());

        if (ch1!=null && ch2!=null){
            textInt.exchangeSymbol(ch1, ch2);
        }

        model.addAttribute("text", textInt.getText());
        model.addAttribute("sentences", sentencesCount);
        model.addAttribute("result", numbersMap);

        if (exportToFile == true){
            File file = new File("courseWork.txt");
                FileWriter fileWriter = new FileWriter("courseWork.txt");
                PrintWriter printWriter = new PrintWriter(fileWriter);

            outputToFile+= textInt.getText() + "\n";
            outputToFile+= " -------------------------\n";
            outputToFile+= "Number of sentences: " + sentencesCount + "\n\n";
            outputToFile+= " ------------------------\n";

            if (numbersMap.isEmpty()){
                outputToFile+= "There are no number in text";
            }
            else{
                for (Map.Entry<Integer, Integer> entry: numbersMap.entrySet()){
                    outputToFile+= "|     " + entry.getKey() + "      |     " +  entry.getValue() + "     |\n";
                    outputToFile+= " ------------------------\n";
                }
            }

            printWriter.print(outputToFile);

            printWriter.close();
        }

        return "input1";
    }

    @PostMapping("/input2")
    public String postMapping2(@RequestParam("text") String text, @Nullable @RequestParam("changeFrom") Character ch1,  @Nullable @RequestParam("changeTo") Character ch2, @Nullable @RequestParam("outputExport") boolean exportToFile, Model model) throws IOException {
        textInt = new CyrillicText(text);
        textInt.setText(text);
        this.ch1 = ch1; // implement
        this.ch2 = ch2; // implement
        String outputToFile = "";

        Map<Integer, Integer> numbersMap = textInt.numberQuantity();
        if(numbersMap.isEmpty()){
            model.addAttribute("result", "No numbers in text");
        }

        String[] resultList = new String[numbersMap.size()*2+1];

        String sentencesCount = "";
        sentencesCount+= String.valueOf(textInt.sentenceCount());

        if (ch1!=null && ch2!=null){
            textInt.exchangeSymbol(ch1, ch2);
        }
        model.addAttribute("text", textInt.getText());
        model.addAttribute("sentences", sentencesCount);
        model.addAttribute("result", numbersMap);

        if (exportToFile == true){
            File file = new File("courseWork.txt");
            FileWriter fileWriter = new FileWriter("courseWork.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            outputToFile+= textInt.getText() + "\n";
            outputToFile+= " -------------------------\n";
            outputToFile+= "Number of sentences: " + sentencesCount + "\n\n";
            outputToFile+= " ------------------------\n";

            if (numbersMap.isEmpty()){
                outputToFile+= "There are no number in text";
            }
            else{
                for (Map.Entry<Integer, Integer> entry: numbersMap.entrySet()){
                    outputToFile+= "|     " + entry.getKey() + "      |     " +  entry.getValue() + "     |\n";
                    outputToFile+= " ------------------------\n";
                }
            }

            printWriter.print(outputToFile);

            printWriter.close();
        }

        return "input2";
    }

    @PostMapping("/input3")
    public String postMapping3(@RequestParam("text") String text, @Nullable @RequestParam("changeFrom") Character ch1,  @Nullable @RequestParam("changeTo") Character ch2, @Nullable @RequestParam("outputExport") boolean exportToFile, Model model) throws IOException {
        textInt = new CustomText(text);
        textInt.setText(text);
        this.ch1 = ch1; // implement
        this.ch2 = ch2; // implement
        String outputToFile = "";

        Map<Integer, Integer> numbersMap = textInt.numberQuantity();
        if(numbersMap.isEmpty()){
            model.addAttribute("result", "No numbers in text");
        }

        String[] resultList = new String[numbersMap.size()*2+1];

        //ERROR WITH FUNCTION NUMBERQUANTITY
        String sentencesCount = "";
        sentencesCount+= String.valueOf(textInt.sentenceCount());

        if (ch1!=null && ch2!=null){
            customText.exchangeSymbol(ch1, ch2);
        }

        model.addAttribute("text", textInt.getText());
        model.addAttribute("latinPerc", Math.round(((FindPercentage)textInt).latinPercentage()));
        model.addAttribute("cyrillicPerc", (100 - Math.round(((FindPercentage)textInt).latinPercentage())));
        model.addAttribute("sentences", sentencesCount);
        model.addAttribute("result", numbersMap);

        if (exportToFile == true){
            File file = new File("courseWork.txt");
            PrintWriter printWriter = null;

            try {
                FileWriter fileWriter = new FileWriter("courseWork.txt");
                printWriter = new PrintWriter(fileWriter);
            } catch (IOException ioe){
                ioe.printStackTrace();
            }


            outputToFile+= textInt.getText() + "\n";
            outputToFile+= " -------------------------\n";
            outputToFile+= "Number of sentences: " + sentencesCount + "\n\n";
            outputToFile+= " ------------------------\n";
            outputToFile+= "Latin: " + Math.round(((FindPercentage)textInt).latinPercentage()) + " %\n";
            outputToFile+= "Cyrillic: " + (100 - Math.round(((FindPercentage)textInt).latinPercentage())) + " %\n";
            outputToFile+= " ------------------------\n";

            if (numbersMap.isEmpty()){
                outputToFile+= "There are no numbers in text";
            }
            else{
                for (Map.Entry<Integer, Integer> entry: numbersMap.entrySet()){
                    outputToFile+= "|     " + entry.getKey() + "      |     " +  entry.getValue() + "     |\n";
                    outputToFile+= " ------------------------\n";
                }
            }

            try{
                printWriter.print(outputToFile);
            } catch (NullPointerException nullPointerException){
                nullPointerException.printStackTrace();;
            }


            printWriter.close();



        }

        return "input3";
    }


    @PostMapping("/changeToLatin")
    public String changeToLatin(@RequestBody String text, @NotNull Model model) throws IOException {
        textInt = new LatinText(text);
        textInt.setText(text);
        textInt.changeToLatin();
        model.addAttribute("text", textInt.getText());
        return "input1";
    }

    @GetMapping("/result1")
    public String getMapping(Model model){
        return "";
    }
}
