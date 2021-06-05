package com.github.zflxw.adventofcode.modules.yearone;

import com.github.zflxw.adventofcode.utils.AocModule;
import com.github.zflxw.adventofcode.utils.Module;

import java.util.List;

@Module(year = "2015", day = "01")
public class Day01 extends AocModule {
    @Override
    public void solution(String rawInput, List<String> input) {
        int story = 0;
        int basementFirst = 0;

        int i = 0;
        for (char c : rawInput.toCharArray()) {
            i++;
            if (c == '(') {
                story++;
            } else {
                story--;
            }

            if (story < 0 && basementFirst == 0)
                basementFirst = i;
        }

        System.out.println("Story: " + story);
        System.out.println("First Basement: " + basementFirst);
    }
}
