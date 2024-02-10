package org.project;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Main class
 */
public class Main {
    public static void main(String[] args) {   //arg[0] -> file path

        String filename = args[0];    //taking the file path

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