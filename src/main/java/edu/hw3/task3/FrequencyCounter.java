package edu.hw3.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {
    public <T> Map<T, Integer> freqDict(List<T> list) {
        HashMap<T, Integer> dictionary = new HashMap<>();
        for (var element : list) {
            if (dictionary.containsKey(element)) {
                dictionary.put(element, dictionary.get(element) + 1);
            } else {
                dictionary.put(element, 1);
            }
        }
        return dictionary;
    }
}
