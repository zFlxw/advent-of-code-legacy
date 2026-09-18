package com.github.zflxw.adventofcode.modules.y2015;

import com.github.zflxw.adventofcode.utils.AocModule;
import com.github.zflxw.adventofcode.utils.Module;
import com.github.zflxw.adventofcode.utils.PermutationUtility;

import java.util.*;

record MapKey(String from, String to) {
}

@Module(year = "2015", day = "09")
public class Day09 extends AocModule {
    @Override
    public void solution(String rawInput, List<String> input) {
        Set<String> cities = parseCities(input);
        Map<MapKey, Integer> individualCosts = parseCosts(input);
        List<Integer> summedCosts = new ArrayList();

        PermutationUtility.permute(new ArrayList<>(cities), (List<String> c) -> {
            int sum = 0;
            for (int i = 0; i < c.size() - 1; i++) {
                String from = c.get(i);
                String to = c.get(i + 1);
                int cost = individualCosts.get(new MapKey(from, to));
                sum += cost;
            }

            summedCosts.add(sum);
        });

        System.out.println("Min Cost: " + Collections.min(summedCosts));
        System.out.println("Max Cost: " + Collections.max(summedCosts));
    }

    private Set<String> parseCities(List<String> lines) {
        Set<String> cities = new HashSet<>();
        for (String line : lines) {
            String from = line.split(" ")[0];
            String to = line.split(" ")[2];
            if (!cities.contains(from)) {
                cities.add(from);
            }

            if (!cities.contains(to)) {
                cities.add(to);
            }
        }

        return cities;
    }

    private Map<MapKey, Integer> parseCosts(List<String> lines) {
        Map<MapKey, Integer> result = new HashMap<>();

        for (String line : lines) {
            String[] split = line.split(" ");
            String from = split[0];
            String to = split[2];
            int cost = Integer.parseInt(split[4]);
            if (result.containsKey(new MapKey(from, to)) || result.containsKey(new MapKey(to, from))) {
                continue;
            }

            result.put(new MapKey(from, to), cost);
            result.put(new MapKey(to, from), cost);
        }

        return result;
    }
}
