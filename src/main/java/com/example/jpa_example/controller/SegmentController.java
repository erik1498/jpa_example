package com.example.jpa_example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/segment")
public class SegmentController {
    @GetMapping("/all")
    public List<String> getAllSegment(){
        String satu = "satu";
        String dua = "dua";
        List<String> list = new ArrayList<>();
        list.add(satu);
        list.add(dua);
        return list;
    }
}
