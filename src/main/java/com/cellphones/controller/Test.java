package com.cellphones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Test {

    @GetMapping("/hello")
    public String test ()
    {
        return "hello";
    }
}
