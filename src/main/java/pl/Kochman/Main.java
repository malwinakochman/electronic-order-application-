package pl.Kochman;

import java.sql.Array;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Malwina", "Jakub", "Amelia", "Szymon");

        Greeter greeter = new Greeter();
        List<String> ladies = new ArrayList<String>();

        for (String name : names) {
            if (name.endsWith("a")) {
                ladies.add(name);
            }
        }

        for (String ladyName : ladies) {
            greeter.greet(ladyName);
        }

        names.stream()
                .filter(name -> name.endsWith("a"))
                .filter(name -> name.startsWith("M"))
                .map(String::toUpperCase)
                .forEach(greeter::greet);
    }
}