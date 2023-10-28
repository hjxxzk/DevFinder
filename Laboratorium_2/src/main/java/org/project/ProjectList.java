package org.project;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class responsible for creating a project list in the form of a HashMap
 * and list of employees available in the form of an ArrayList filled with Programmer objects
 */

public class ProjectList {

    /**
     * Metoda tworzy HashMapę z listą projektów na podstawie tablicy typu String: HashMap<String, ArrayList<String>>
     *                                                                       np.  HashMap<"P1", ArrayList<[JAVA, JAVA, QA, PM]>>
     *                                                                            HashMap<"P2", ArrayList<[PYTHON, QA, PM]>>
     *                                                                            itd.
     *
     * @param data tablica typu String[], na podstawie któej tworzona jest lista projektów
     * @return project_list zwracana HashMapa
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
     * Metoda tworzy ArrayListę z listą obiektów klasy Programmer na podstawie tablicy typu String: ArrayList<Programmer>
     *
     * @param data tablica typu String[], na podstawie któej tworzona jest lista projektów
     * @return dev_list zwracana ArrayLista programistów
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