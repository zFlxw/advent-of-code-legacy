package com.github.zflxw.adventofcode.modules.y2015;

import com.github.zflxw.adventofcode.utils.AocModule;
import com.github.zflxw.adventofcode.utils.Module;

import java.util.List;

@Module(year = "2015", day = "03")
public class Day03 extends AocModule {
    @Override
    public void solution(String rawInput, List<String> input) {
        // Problem 01
        problem01(rawInput);

        // Problem 02
        problem02(rawInput);
    }

    private void problem01(String rawInput) {
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

    private void problem02(String rawInput) {
        int maxLength = rawInput.length() + 1;
        int[][] houses = new int[maxLength][maxLength];

        int santaX = maxLength / 2;
        int santaY = maxLength / 2;
        int roboX = maxLength / 2;
        int roboY = maxLength / 2;

        int luckyHouses = 0;
        int turns = 0;

        houses[santaX][santaY] = 2;

        for (char c : rawInput.toCharArray()) {
            boolean santaTurn = turns % 2 == 0;

            switch (c) {
                // Go up
                case '^' -> {
                    if (santaTurn) {
                        santaY++;
                        houses[santaX][santaY]++;
                    } else {
                        roboY++;
                        houses[roboX][roboY]++;
                    }
                }
                // Go down
                case 'v' -> {
                    if (santaTurn) {
                        santaY--;
                        houses[santaX][santaY]++;
                    } else {
                        roboY--;
                        houses[roboX][roboY]++;
                    }
                }
                // Go left
                case '<' -> {
                    if (santaTurn) {
                        santaX--;
                        houses[santaX][santaY]++;
                    } else {
                        roboX--;
                        houses[roboX][roboY]++;
                    }
                }
                // Go right
                case '>' -> {
                    if (santaTurn) {
                        santaX++;
                        houses[santaX][santaY]++;
                    } else {
                        roboX++;
                        houses[roboX][roboY]++;
                    }
                }
            }

            turns++;
        }

        for (int i = 0; i < houses.length; i++)
            for (int j = 0; j < houses[i].length; j++)
                if (houses[i][j] >= 1)
                    luckyHouses++;

        System.out.println("Lucky Houses: " + luckyHouses);
    }
}
