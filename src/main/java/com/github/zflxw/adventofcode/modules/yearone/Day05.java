package com.github.zflxw.adventofcode.modules.yearone;

import com.github.zflxw.adventofcode.utils.AocModule;
import com.github.zflxw.adventofcode.utils.Module;

import java.util.ArrayList;
import java.util.List;

@Module(year = "2015", day = "05")
public class Day05 extends AocModule {
    @Override
    public void solution(String rawInput, List<String> input) {
        // Solution 01
        solution01(input);

        // Solution 02
        solution02(input);
    }

    private void solution01(List<String> input) {
        int niceStrings = 0;

        for (String str : input) {
            char[] vowels = {'a', 'e', 'i', 'o', 'u'};
            int vowelCount = 0;

            str = str.toLowerCase();

            if (str.contains("ab") || str.contains("cd") || str.contains("pq") || str.contains("xy"))
                continue;

            for (char c : str.toCharArray())
                for (char v : vowels)
                    if (c == v)
                        vowelCount++;

            if (vowelCount < 3)
                continue;

            boolean hasDoubleChars = false;
            char[] chars = str.toCharArray();

            for (int i = 0; i < str.length(); i++) {
                char c = chars[i];

                if (i == 0) {
                    if (str.charAt(i + 1) == c)
                        hasDoubleChars = true;
                } else if (i < chars.length - 1) {
                    if (str.charAt(i - 1) == c || str.charAt(i + 1) == c)
                        hasDoubleChars = true;
                } else {
                    if (str.charAt(i - 1) == c)
                        hasDoubleChars = true;
                }
            }

            if (!hasDoubleChars)
                continue;

            niceStrings++;
        }

        System.out.println("Input Length: " + input.size());
        System.out.println("Nice Strings: " + niceStrings);

    }

    private void solution02(List<String> input) {
        int niceStrings = 0;

        for (String string : input) {
            List<String> pairs = new ArrayList<>();

            boolean hasRepeating = false;

            for (int i = 0; i < string.length() - 1; i++) {
                if (i < string.length() - 2) {
                    String pair = string.substring(i, i + 2);
                    if (string.indexOf(pair, i + 2) > i) {
                        pairs.add(pair);
                    }
                }
            }

            for (int i = 1; i < string.length() - 1; i++) {
                String lastChar = String.valueOf(string.charAt(i - 1));
                String currentChar = String.valueOf(string.charAt(i));
                String nextChar = String.valueOf(string.charAt(i + 1));

                if (lastChar.equals(nextChar)) {
                    hasRepeating = true;
                    System.out.println("Repeat found! " + (lastChar + currentChar + nextChar));
                    break;
                }
            }

            if (!pairs.isEmpty() && hasRepeating)
                niceStrings++;
        }

        System.out.println(niceStrings);
    }
}
