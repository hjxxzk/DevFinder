package org.project;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Main class
 */
public class Main {

    public static String Role1;             //Do zrobienia:     1. Wpakowanie programu do Jar   (opcjonalnie) 2. Użyć JAVA stream API w programie
    public static String Role2;

    public static void main(String[] args) {   //arg[0] -> file path, arg[1] -> role able to work on two projects (QA), arg[2] -> role able to work on two projects (PM)

        String filename = args[0];    //taking the file path
        Role1 = args[1];
        Role2 = args[2];

        ArrayList<String> data = TXTFileWorker.ReadFile(filename); //reading the file

        HashMap<String, ArrayList<String>> projectList = TXTFileWorker.MakeAList(data.subList(data.indexOf("PROJECTS") + 1 , data.indexOf("STAFF") - 1)); //creating lists
        ArrayList<Programmer> devList = TXTFileWorker.MakeADevList(data.subList(data.indexOf("STAFF") + 1 , data.size()));

        OutputDisplay.Display(projectList); //displaying data
        OutputDisplay.DevDisplay(devList);

        SigningUp.FindAProject(projectList, devList); //matching programmers to their projects

        OutputDisplay.Display(projectList); //displaying data

        TXTFileWorker.Write2File(projectList); //creating output file
    }


}