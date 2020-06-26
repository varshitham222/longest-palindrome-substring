package com.odx.test.service;

import com.odx.test.dao.DemoRepository;
import com.odx.test.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    DemoRepository demoRepository;

    public String saveLongestPalindrome(String str) {
        String longestPalindrome = getPalindrome(str);
        Demo demo = new Demo(longestPalindrome);
        demoRepository.save(demo);
        return "Longest palindrome is - " + longestPalindrome;
    }

    public String getPalindrome(String str) {
        if (str.isEmpty() || str == null) {
            return "Input cannot be empty!!";
        }

        if (str.length() == 1) {
            return str;
        }
        int len = str.length();
        int longestSoFar = 0;
        int startPos = 0;
        int endPos = 0;
        boolean[][] palindrome = new boolean[len][len];

        for (int j = 0; j < len; j++) {
            palindrome[j][j] = true;
            for (int i = 0; i < j; i++) {
                if (str.charAt(i) == str.charAt(j) && (j - i <= 2 || palindrome[i + 1][j - 1])) {
                    palindrome[i][j] = true;
                    if (j - i + 1 > longestSoFar) {
                        longestSoFar = j - i + 1;
                        startPos = i;
                        endPos = j;
                    }
                }
            }
        }
        return str.substring(startPos, endPos + 1);
    }
}
