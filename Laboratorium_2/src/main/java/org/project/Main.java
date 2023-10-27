package org.project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        String filename = "/C:/Users/agnie/IdeaProjects/Laboratorium_2/Laboratorium_2/src/main/resources/data.txt/";
        String[] data;

        data = TXTFileWorker.ReadFile(filename);

        int position = 0;
        int end = 0;

        for (String s : data) {

            ++end;
            if (s.equals("STAFF")) {
                position = end;
            }

        }

        HashMap<String, ArrayList<String>> project_list = ProjectList.MakeAList(Arrays.copyOfRange(data, 1, position - 2));
        ArrayList<Programmer> dev_list = ProjectList.MakeADevList(Arrays.copyOfRange(data, position, end));

        for (String key : project_list.keySet()) {
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

        SigningUp.FindAProject(project_list, dev_list);


    }
}