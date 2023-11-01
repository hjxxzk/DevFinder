package org.project;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class responsible for creating a project list in the form of a HashMap
 * and list of employees available in the form of an ArrayList filled with Programmer objects
 */

public class ProjectList {

    /**
     * Creates a HashMap containing list of projects based on a String array
     *
     * @param data String Array containing data about projects
     * @return project_list HashMap<String - project id, ArrayList<String - employees needed>> e.g. HashMap<"P1", ArrayList<[JAVA, JAVA, QA, PM]>>, HashMap<"P2", ArrayList<[PYTHON, QA, PM]>> etc.
     */
    public static HashMap<String, ArrayList<String>> MakeAList(String[] data) {

        HashMap<String, ArrayList<String>> project_list = new HashMap<>();
        int i, j;

        for (i = 0; i < data.length; i++) {

            if (data[i].equals("STAFF"))
                break;

            ArrayList<String> languages = new ArrayList<>();

            for (j = i + 1; j < data.length && !(data[j].contains(":")); j++) {
                languages.add(data[j]);
            }
                project_list.put(data[i].replace(":",""), languages);
                i = j - 1;
        }

        return project_list;

    }

    /**
     * Creates an ArrayList containing Programmer objects, storing data about employees and roles they can act as in project
     *
     * @param data  String Array containing data about programmers
     * @return dev_list ArrayList<Programmer> e.g. <"R1", [JAVA], 0>, <"R2", [ANGULAR, QA], 0> etc.
     */

    public static ArrayList<Programmer> MakeADevList(String[] data)  {

        ArrayList<Programmer> dev_list = new ArrayList<>();
        int i,j;

        for (i = 0; i < data.length; i++) {

            ArrayList<String> languages = new ArrayList<>();

            for (j = i + 1; j < data.length && !(data[j].contains(":")); j++) {
                languages.add(data[j]);
            }
            dev_list.add(new Programmer(data[i].replace(":",""), languages));
            i = j - 1;
        }

        return dev_list;
    }

}