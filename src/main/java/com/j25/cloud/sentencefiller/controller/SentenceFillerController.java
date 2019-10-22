package com.j25.cloud.sentencefiller.controller;

import com.j25.cloud.sentencefiller.api.Randomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentenceFillerController {
    @Autowired
    private Randomizer randomizer;

    @GetMapping("/fill")
    public String fill(@RequestParam(name="sentence", required = false) String sentence){
        if(sentence!=null){

            while (sentence.contains("!!!")){
                sentence = sentence.replaceFirst("!!!", randomizer.randomNumber());
            }
            while (sentence.contains("@@@")){
                sentence = sentence.replaceFirst("@@@", randomizer.randomWord());
            }
            return sentence;
        }
        return "Proszę podać zdanie do wypełnienia";
    }

    private String getRandomWord() {
        return null;
    }

    private String getRandonNumber() {
        return null;
    }
}
