package com.example.TextAnalyzer.controllers;

import com.example.TextAnalyzer.model.CustomText;
import com.example.TextAnalyzer.model.CyrillicText;
import com.example.TextAnalyzer.model.LatinText;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InputController {
    @GetMapping("/mode/1")
    public String getIndex1(){
        return "input1";
    }

    @GetMapping("/mode/2")
    public String getIndex2(){
        return "input2";
    }


    @GetMapping("/mode/3")
    public String getIndex3(){
        return "input3";
    }


}
