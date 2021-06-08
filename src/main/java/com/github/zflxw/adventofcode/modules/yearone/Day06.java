package com.github.zflxw.adventofcode.modules.yearone;

import com.github.zflxw.adventofcode.utils.AocModule;
import com.github.zflxw.adventofcode.utils.Module;

import java.util.List;

@Module(year = "2015", day = "06")
public class Day06 extends AocModule {
    @Override
    public void solution(String rawInput, List<String> input) {
        // Solution 01
        solution01(input);

        // Solution 02
        solution02(input);
    }

    private void solution01(List<String> input) {
        int[][] lightMap = new int[1000][1000];
        long lights = 0;

        for (String entry : input) {
            String[] args = entry.split(" ");
            int startX, startY;
            int endX, endY;

            if (args[0].equals("turn")) {
                startX = Integer.parseInt(args[2].split(",")[0]);
                startY = Integer.parseInt(args[2].split(",")[1]);

                endX = Integer.parseInt(args[4].split(",")[0]);
                endY = Integer.parseInt(args[4].split(",")[1]);

                for (int x = startX; x <= endX; x++) {
                    for (int y = startY; y <= endY; y++) {
                        if (args[1].equals("on"))
                            lightMap[x][y] = 1;
                        else
                            lightMap[x][y] = 0;
                    }
                }
            } else {
                startX = Integer.parseInt(args[1].split(",")[0]);
                startY = Integer.parseInt(args[1].split(",")[1]);
                endX = Integer.parseInt(args[3].split(",")[0]);
                endY = Integer.parseInt(args[3].split(",")[1]);

                for (int x = startX; x <= endX; x++) {
                    for (int y = startY; y <= endY; y++) {
                        if (lightMap[x][y] == 1)
                            lightMap[x][y] = 0;
                        else
                            lightMap[x][y] = 1;
                    }
                }
            }
        }

        for (int x = 0; x < lightMap.length; x++) {
            for (int y = 0; y < lightMap[x].length; y++) {
                if (lightMap[x][y] == 1)
                    lights++;
            }
        }

        System.out.println("Lights: " + lights);
    }

    private void solution02(List<String> input) {
        int[][] lightMap = new int[1000][1000];
        long brightness = 0;

        for (String entry : input) {
            String[] args = entry.split(" ");
            int startX, startY;
            int endX, endY;

            if (args[0].equals("turn")) {
                startX = Integer.parseInt(args[2].split(",")[0]);
                startY = Integer.parseInt(args[2].split(",")[1]);

                endX = Integer.parseInt(args[4].split(",")[0]);
                endY = Integer.parseInt(args[4].split(",")[1]);

                for (int x = startX; x <= endX; x++) {
                    for (int y = startY; y <= endY; y++) {
                        if (args[1].equals("on"))
                            lightMap[x][y]++;
                        else
                            lightMap[x][y] = Math.max(0, lightMap[x][y] - 1);
                    }
                }
            } else {
                startX = Integer.parseInt(args[1].split(",")[0]);
                startY = Integer.parseInt(args[1].split(",")[1]);
                endX = Integer.parseInt(args[3].split(",")[0]);
                endY = Integer.parseInt(args[3].split(",")[1]);

                for (int x = startX; x <= endX; x++) {
                    for (int y = startY; y <= endY; y++) {
                        lightMap[x][y] += 2;
                    }
                }
            }
        }

        for (int x = 0; x < lightMap.length; x++) {
            for (int y = 0; y < lightMap[x].length; y++) {
                if (lightMap[x][y] >= 1)
                    brightness += lightMap[x][y];
            }
        }

        System.out.println("Brightness: " + brightness);
    }
}
