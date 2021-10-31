package com.lab1;

import java.util.HashMap;
import java.util.Map;

public class SamePhrase {
    public static void main(String[] args) {
        String my_phrase = "Look at my horse my horse is amazing";
        String[] split = my_phrase.split("\\s");
        Map<String, Integer> histogram = new HashMap<>();
        for (String s : split)
            if (!histogram.containsKey(s))
                histogram.put(s, 1);
            else
                histogram.replace(s, histogram.get(s) + 1);
        for (String key : histogram.keySet())
            System.out.println(key + ": " + histogram.get(key));


    }
}
