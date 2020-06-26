package com.odx.test.controller;

import com.odx.test.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    /* saves and retrieves the stored longest palindrome substring for a given string  */
    @PostMapping("/savePalindrome/{str}")
    public String savePalindrome(@PathVariable String str){
        return demoService.saveLongestPalindrome(str);
    }

}
