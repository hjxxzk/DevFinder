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
        // ze zmiennej args
        //stream
        String filename = "data.txt";    //taking the file path
        String[] data;

        data = TXTFileWorker.ReadFile(filename); //reading the file

        int position = 0;
        int end = 0;

        for (String s : data) {     //finding the position of "STAFF" element to slice data array

            ++end;
            if (s.equals("STAFF")) {
                position = end;
            }

        }

        HashMap<String, ArrayList<String>> project_list = ProjectList.MakeAList(Arrays.copyOfRange(data, 1, position - 2)); //creating a hashmap containing list of projects
        ArrayList<Programmer> dev_list = ProjectList.MakeADevList(Arrays.copyOfRange(data, position, end)); //creating an arraylist containing list of programmers

        OutputDisplay.Display(project_list); //displaying data
        OutputDisplay.DevDisplay(dev_list);

        SigningUp.FindAProject(project_list, dev_list); //matching programmers to their projects
        OutputDisplay.Display(project_list); //displaying data
        TXTFileWorker.Write2File(project_list); //creating output file

    }


}