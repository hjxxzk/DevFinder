package org.project;

import java.util.ArrayList;
import java.util.HashMap;

public class ProjectList {

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