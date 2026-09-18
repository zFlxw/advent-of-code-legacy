package com.github.zflxw.adventofcode.utils;

import java.util.*;
import java.util.function.Consumer;

public final class PermutationUtility {
    public static <T> void permute(List<T> items, Consumer<List<T>> action) {
        permute(items, new ArrayList<>(), new boolean[items.size()], action);
    }

    private static <T> void permute(List<T> items, List<T> current,
                                    boolean[] used, Consumer<List<T>> action) {
        if (current.size() == items.size()) {
            action.accept(current);
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            if (used[i]) continue;
            used[i] = true;
            current.add(items.get(i));
            permute(items, current, used, action);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
