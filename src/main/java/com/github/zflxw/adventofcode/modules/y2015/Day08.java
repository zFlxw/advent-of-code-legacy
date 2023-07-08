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

        for (String string : input) {
            codeLength += string.length();
            String content = string.substring(1, string.length() - 1)
                    .replaceAll("\\\\", "@")
                    .replaceAll("@\\\"", "!")
                    .replaceAll("@@", "#")
                    .replaceAll("@x..", "%");

            inMemoryLength += content.length();
        }

        System.out.println("Code Length: " + codeLength);
        System.out.println("In Memory Length: " + inMemoryLength);
        System.out.println("Difference: " + (codeLength - inMemoryLength));
    }

    private boolean isValidHex(char c) {
        return Character.isDigit(c) || (c >= 65 && c <= 70) || (c >= 97 && c <= 102);
    }
}
