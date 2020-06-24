package com.programatori.zuul.xss;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class XSSCleaner {

    private static List<Pattern> XSS_COMMON_PATTERNS = new ArrayList<Pattern>();

    static {
        XSS_COMMON_PATTERNS.add(Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE));
        XSS_COMMON_PATTERNS.add(Pattern.compile("<iframe(.*?)>(.*?)</iframe>", Pattern.CASE_INSENSITIVE));
        XSS_COMMON_PATTERNS.add(Pattern.compile("<input(.*?)>(.*?)</input>", Pattern.CASE_INSENSITIVE));
    }


    public static String clearXSS(String value) {
        try {
            if (value != null) {
                value = value.replaceAll("\0", "");
                for (Pattern xssInputPattern : XSS_COMMON_PATTERNS) {
                    value = xssInputPattern.matcher(value).replaceAll("");
                }
            }

        } catch (Exception ex) {
            System.out.println("Could not strip XSS from value = " + value + " | ex = " + ex.getMessage());
        }

        return value;
    }
}
