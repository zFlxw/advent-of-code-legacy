package com.github.zflxw.adventofcode.modules.yearone;

import com.github.zflxw.adventofcode.utils.AocModule;
import com.github.zflxw.adventofcode.utils.Module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Module(year = "2015", day = "02")
public class Day02 extends AocModule {
    @Override
    public void solution(String rawInput, List<String> input) {
        int totalArea = 0;
        int totalRibbon = 0;

        for (String line : input) {
            String[] contents = line.split("x");
            int     l = Integer.parseInt(contents[0]),
                    w = Integer.parseInt(contents[1]),
                    h = Integer.parseInt(contents[2]);

            List<Integer> numbers = new ArrayList<>();
            numbers.add(l);
            numbers.add(w);
            numbers.add(h);

            Collections.sort(numbers);

            int areaL = 2 * l * w;
            int areaW = 2 * w * h;
            int areaH = 2 * h * l;

            int area = areaH + areaL + areaW;

            int smallestSide = numbers.get(0);
            int smallestSide2 = numbers.get(1);
            int ribbon = (smallestSide * 2) + (smallestSide2 * 2) + (l * w * h);

            area += smallestSide;
            totalArea += area;
            totalRibbon += ribbon;
        }

        System.out.println("Total Area: " + totalArea);
        System.out.println("Total Ribbon: " + totalRibbon);
    }
}
