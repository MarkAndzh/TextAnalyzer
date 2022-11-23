package com.example.TextAnalyzer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModeController {
    @GetMapping("/mode")
    public String getIndex(){
        return "mode";
    }
}
