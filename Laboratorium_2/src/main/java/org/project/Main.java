package org.project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Main class
 */

public class Main {
    public static void main(String[] args) throws IOException {

        String filename = "/C:/Users/agnie/IdeaProjects/Laboratorium_2/Laboratorium_2/src/main/resources/data.txt/";    //wczytanie nazwy pliku
        String[] data;

        data = TXTFileWorker.ReadFile(filename); //odczyt z pliku

        int position = 0;
        int end = 0;

        for (String s : data) {     //ustalenie, gdzie zaczyna się sekcja "STAFF"

            ++end;
            if (s.equals("STAFF")) {
                position = end;
            }

        }

        HashMap<String, ArrayList<String>> project_list = ProjectList.MakeAList(Arrays.copyOfRange(data, 1, position - 2)); //tworzenie hashmapy, przesyłając do metody jedynie część "PROJECTS"
        ArrayList<Programmer> dev_list = ProjectList.MakeADevList(Arrays.copyOfRange(data, position, end)); //tworzenie hashmapy, przesyłając do metody jedynie część "STAFF"

        for (String key : project_list.keySet()) {      //Wyświetlanie w konsoli
            System.out.print(key + " ");
            ArrayList<String> projectLanguages = project_list.get(key);
            for (String language : projectLanguages) {
                System.out.print(language + " ");
            }
            System.out.println();
        }

        for (Programmer s : dev_list) {
            System.out.println(s.id + " " + s.roles);
        }

        SigningUp.FindAProject(project_list, dev_list); //dopasywanie pracownika do projektu

    }
}