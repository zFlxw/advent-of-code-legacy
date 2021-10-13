package com.github.zflxw.adventofcode.modules.yearone;

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

        /*for (String string : input) {
            String toWire = string.split(" -> ")[1];
            String value = string.split(" -> ")[0];

            String[] valueArray = value.split(" ");

            if (valueArray.length == 1) {
                if (Character.isDigit(value.charAt(0))) {
                    wires.put(toWire, Integer.parseInt(value));

                } else {
                    if (!wires.containsKey(value)) {
                        wires.put(value, 0);
                    }
                    wires.put(toWire, wires.get(value));
                }
            } else if (valueArray.length == 3) {
                if (!wires.containsKey(valueArray[0])) {
                    if (!Character.isDigit(valueArray[0].charAt(0))) {
                        wires.put(valueArray[0], 0);
                    }
                }

                if (!wires.containsKey(valueArray[2])) {
                    if (!Character.isDigit(valueArray[2].charAt(0))) {
                        wires.put(valueArray[2], 0);
                    }
                }

                int wireOne = (Character.isDigit(valueArray[0].charAt(0))) ? Integer.parseInt(valueArray[0]) : wires.get(valueArray[0]);
                int wireTwo = (Character.isDigit(valueArray[2].charAt(0))) ? Integer.parseInt(valueArray[2]) : wires.get(valueArray[2]);

                switch (valueArray[1].toLowerCase()) {
                    case "and" -> wires.put(toWire, wireOne & wireTwo);
                    case "or" -> wires.put(toWire, wireOne | wireTwo);
                    case "lshift" -> wires.put(toWire, wireOne << wireTwo);
                    case "rshift" -> wires.put(toWire, wireOne >> wireTwo);
                }
            } else if (valueArray.length == 2) {
                if (valueArray[0].equalsIgnoreCase("not")) {
                    if (!wires.containsKey(valueArray[1])) {
                        wires.put(valueArray[1], 0);
                    }

                    int wire = (Character.isDigit(valueArray[1].charAt(0))) ? Integer.parseInt(valueArray[1]) : wires.get(valueArray[1]);
                    wires.put(toWire, ~wire & 0xFFFF);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : wires.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }*/
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
