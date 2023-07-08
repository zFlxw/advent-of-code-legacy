package com.github.zflxw.adventofcode.modules.y2015;

import com.github.zflxw.adventofcode.utils.AocModule;
import com.github.zflxw.adventofcode.utils.Module;

import java.util.ArrayList;
import java.util.List;

@Module(year = "2015", day = "08")
public class Day08 extends AocModule {
    @Override
    public void solution(String rawInput, List<String> input) {
        long codeLength = 0;
        long inMemoryLength = 0;
        long encodedLength = 0;
        for (String string : input) {
            codeLength += string.length();
            String decodeContent = string.substring(1, string.length() - 1)
                    .replaceAll("\\\\", "@")
                    .replaceAll("@\\\"", "!")
                    .replaceAll("@@", "#")
                    .replaceAll("@x..", "%");

            inMemoryLength += decodeContent.length();
            String encodeContent = string
                    .replaceAll("^\"", "!@!")
                    .replaceAll("\"$", "!@!")
                    .replaceAll("\\\\", "@@")
                    .replaceAll("\"", "@!");

            encodedLength += encodeContent.length();
        }

        System.out.println("Difference (Part 1): " + (codeLength - inMemoryLength));
        System.out.println("Difference (Part 2): " + (encodedLength - codeLength));
    }
}
