package com.example.xmltodb.controllers;

import com.example.xmltodb.services.FileHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fileHandler")
public class FileHandlerController {
    private final FileHandler fileHandler;
    @GetMapping("/download")
    public ResponseEntity<?> downloadCities() {
        fileHandler.downloadCities("https://www.smartform.cz/download/kopidlno.xml.zip");
        return ResponseEntity.ok().build();
    }
}
