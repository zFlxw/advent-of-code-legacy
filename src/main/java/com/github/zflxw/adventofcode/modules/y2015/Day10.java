package com.github.zflxw.adventofcode.modules.y2015;

import com.github.zflxw.adventofcode.utils.AocModule;
import com.github.zflxw.adventofcode.utils.Module;

import java.util.List;

@Module(year = "2015", day = "10")
public class Day10 extends AocModule {
    private final int N = 50;

    @Override
    public void solution(String rawInput, List<String> input) {
        String last = rawInput;
        for (int i = 0; i < N; i++) {
            System.out.println("Current Interation: " + i);
            last = lookAndSee(last);
        }

        System.out.println("Look-and-see (Length): " + last.length());
    }

    private String lookAndSee(String input) {
        StringBuilder out = new StringBuilder();
        int n = 0;
        int i = 0;
        char last = 0;

        while (i < input.length()) {
            char c = input.charAt(i);
            if (last == 0) {
                last = c;
                n = 1;
                i++;
                continue;
            }

            if (c == last) {
                n++;
                i++;
                continue;
            }

            out.append(n).append(last);
            n = 1;
            last = c;
            i++;
        }

        out.append(n).append(last);

        return out.toString();
    }
}

