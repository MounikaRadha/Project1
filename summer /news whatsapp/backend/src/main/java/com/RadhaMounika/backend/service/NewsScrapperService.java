package com.RadhaMounika.backend.service;

import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Service;

@Service
public class NewsScrapperService {
    public String scrapeNews(){
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("//Users//radha.mounika//personalProjects//new//summer //news whatsapp//backend//src//main//java//com//RadhaMounika//backend//python//scrape.py");
        return "scrapped news";
    }
}
