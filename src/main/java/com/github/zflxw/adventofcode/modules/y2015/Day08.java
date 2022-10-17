package com.github.zflxw.adventofcode.modules.y2015;

import com.github.zflxw.adventofcode.utils.AocModule;
import com.github.zflxw.adventofcode.utils.Module;

import java.util.List;

@Module(year = "2015", day = "08")
public class Day08 extends AocModule {
    @Override
    public void solution(String rawInput, List<String> input) {
        long totalLength = 0;
        long codeLength = 0;

        for (String string : input) {
            System.out.println(string);
            totalLength += string.length();
            String code = string.substring(1, string.length() - 1)
                    .replace("\\\\", "\\")
                    .replace("\\\"", "\"");
            System.out.println(code);

            if (code.contains("\\x")) {
                char numOne = code.charAt(code.indexOf("\\x") + 2);
                char numTwo = code.charAt(code.indexOf("\\x") + 3);

                if (this.isValidHex(numOne) && this.isValidHex(numTwo)) {
                    int character = Integer.parseInt(code.substring(code.indexOf("\\x") + 2, code.indexOf("\\x") + 4), 16);
                    char c = (char) character;
                    System.out.println("\\" + numOne + numTwo + " = " + character + " = " + c);
                    code = code.replace("\\x" + numOne + numTwo, String.valueOf(c));
                    System.out.println(code);
                }
            }

            System.out.println(code.length());
            codeLength += code.length();
            System.out.println("---");

        }

        System.out.println("Total Length: " + totalLength);
        System.out.println("Code Length: " + codeLength);
        System.out.println("Difference: " + (totalLength - codeLength));
    }

    private boolean isValidHex(char c) {
        return Character.isDigit(c) || (c >= 65 && c <= 70) || (c >= 97 && c <= 102);
    }
}
