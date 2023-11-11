package org.project;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class responsible for displaying output on screen and writing TXT output file
 */

public class OutputDisplay {

    /**
     * Displaying projects list
     */

    public static void Display(HashMap<String, ArrayList<String>> projectList) {

        projectList.forEach((key, value) -> {
            System.out.print(key + " ");
            value.forEach(language -> System.out.print(language + " "));
            System.out.println();
        });

        System.out.println();
    }

    /**
     * Displaying programmers list
     */

    public static void DevDisplay(ArrayList<Programmer> devList) {

        devList
                .forEach(programmer -> System.out.println(programmer.id + " " + programmer.roles));
        System.out.println();

    }
}
