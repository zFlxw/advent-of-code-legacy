package com.github.zflxw.adventofcode.modules.y2015;

import com.github.zflxw.adventofcode.utils.AocModule;
import com.github.zflxw.adventofcode.utils.Module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Module(year = "2015", day = "07")
public class Day07 extends AocModule {
    Map<String, String[]> calculations = new HashMap<>();
    Map<String, Long> results = new HashMap<>();

    @Override
    public void solution(String rawInput, List<String> input) {
        for (String string : input) {
            String operation = string.split("->")[0].trim();
            String destination = string.split("->")[1].trim();

            calculations.put(destination.strip(), operation.strip().split(" "));
        }

        long a = calculate("a");
        results.clear();
        results.put("b", a);

        System.out.println("a: " + calculate("a"));
    }

    private long calculate(String wire) {
        try {
            return Long.parseLong(wire);
        } catch (NumberFormatException exception) {
            if (!results.containsKey(wire)) {
                String[] operations = calculations.get(wire);
                long result = 0;

                if (operations.length == 1) {
                    result = calculate(operations[0]);
                } else {
                    String operator = operations[operations.length - 2];

                    switch (operator) {
                        case "AND" -> result = calculate(operations[0]) & calculate(operations[2]);
                        case "OR" -> result = calculate(operations[0]) | calculate(operations[2]);
                        case "NOT" -> result = ~calculate(operations[1]) & 0xFFFF;
                        case "RSHIFT" -> result = calculate(operations[0]) >> calculate(operations[2]);
                        case "LSHIFT" -> result = calculate(operations[0]) << calculate(operations[2]);
                    }
                }

                results.put(wire, result);
            }

            return results.get(wire);
        }
    }
}
