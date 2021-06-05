package com.github.zflxw.adventofcode;

import com.github.zflxw.adventofcode.utils.AocModule;
import com.github.zflxw.adventofcode.utils.Module;
import org.reflections8.Reflections;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class ModuleLoader {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        Reflections reflections = new Reflections("com.github.zflxw.adventofcode.modules");

        System.out.println("Which solution do you search for? (<year>/<day>)");
        System.out.print("> ");
        String searchedSolution = scanner.next();

        for (Class<?> clazz : reflections.getTypesAnnotatedWith(Module.class)) {
            Object loadedClass = clazz.getDeclaredConstructor().newInstance();
            Module annotation = clazz.getAnnotation(Module.class);

            if (!((annotation.year() + "/" + annotation.day()).equals(searchedSolution)))
                continue;

            if (loadedClass instanceof AocModule) {
                AocModule module = (AocModule) loadedClass;
                System.out.println("Starting Solution: " + annotation.year() + "/" + annotation.day() + ":");
                String fileName = annotation.year() + "/day" + annotation.day() + ".txt";

                try {
                    File file = loadResourceFile(fileName);

                    String rawFile = module.readFile(file);
                    List<String> lines = module.readFileLines(file);

                    module.solution(rawFile, lines);

                } catch (URISyntaxException | IOException exception) {
                    exception.printStackTrace();
                }

                return;
            }
        }

        System.out.println("No Solution found for that input...");
    }

    private static File loadResourceFile(String fileName) throws URISyntaxException {
        ClassLoader classLoader = ModuleLoader.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            throw new IllegalArgumentException("File not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }
    }
}
