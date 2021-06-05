package com.github.zflxw.adventofcode.modules.yearone;

import com.github.zflxw.adventofcode.utils.AocModule;
import com.github.zflxw.adventofcode.utils.Module;

import java.util.List;

@Module(year = "2015", day = "03")
public class Day03 extends AocModule {
    @Override
    public void solution(String rawInput, List<String> input) {
        int maxLength = rawInput.length();
        int[][] houses = new int[maxLength][maxLength];

        int x = maxLength / 2;
        int y = maxLength / 2;

        int luckyHouses = 0;

        houses[x][y] = 1;

        for (char c : rawInput.toCharArray()) {
            switch (c) {
                // Go up
                case '^' -> {
                    y++;
                    houses[x][y]++;
                }
                // Go down
                case 'v' -> {
                    y--;
                    houses[x][y]++;
                }
                // Go left
                case '<' -> {
                    x--;
                    houses[x][y]++;
                }
                // Go right
                case '>' -> {
                    x++;
                    houses[x][y]++;
                }
            }
        }

        for (int i = 0; i < houses.length; i++)
            for (int j = 0; j < houses[i].length; j++)
                if (houses[i][j] >= 1)
                    luckyHouses++;

        System.out.println("Lucky Houses: " + luckyHouses);
    }
}
