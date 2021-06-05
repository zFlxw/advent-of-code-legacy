package com.github.zflxw.adventofcode.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public abstract class AocModule implements IModule{
    public String readFile(File file) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = Files.newBufferedReader(file.toPath());

        bufferedReader.lines().forEach(stringBuilder::append);
        bufferedReader.close();

        return stringBuilder.toString();
    }

    public List<String> readFileLines(File file) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader bufferedReader = Files.newBufferedReader(file.toPath());

        bufferedReader.lines().forEach(list::add);
        bufferedReader.close();

        return list;
    }
}
