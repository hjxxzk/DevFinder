package org.project;

import java.io.*;
import java.util.*;

/**
 * This class provides functionality for working with TXT files: reads a txt file and creates a project list in the form of a HashMap
 * and list of employees available in the form of an ArrayList filled with Programmer objects
 */

public class TXTFileWorker {

    /**
     * Reads the TXT file and creates String Array storing data
     *
     * @param filename the name of the TXT file
     */

    public static ArrayList<String> ReadFile(String filename)  {

        ArrayList<String> input = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {

                    String[] text = line.split("\\s+");
                    input.addAll(Arrays.asList(text));
            }
                reader.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        return input;

    }



    /**
     * Creates a HashMap containing list of projects based on a String array
     *
     * @param data String Array containing data about projects
     * @return projectList HashMap<String - project id, ArrayList<String - employees needed>> e.g. HashMap<"P1", ArrayList<[JAVA, JAVA, QA, PM]>>, HashMap<"P2", ArrayList<[PYTHON, QA, PM]>> etc.
     */
    public static HashMap<String, ArrayList<String>> MakeAList(List<String> data) {

        HashMap<String, ArrayList<String>> projectList = new HashMap<>();
        int i, j;

        for (i = 0; i < data.size(); i++) {

            ArrayList<String> languages = new ArrayList<>();

            for (j = i + 1; j < data.size() && !(data.get(j).contains(":")); j++) {
                languages.add(data.get(j));
            }
            projectList.put(data.get(i).replace(":",""), languages);
            i = j - 1;
        }

        return projectList;

    }



    /**
     * Creates an ArrayList containing Programmer objects, storing data about employees and roles they can act as in project
     *
     * @param data  String Array containing data about programmers
     * @return devList ArrayList<Programmer> e.g. <"R1", [JAVA], 0>, <"R2", [ANGULAR, QA], 0> etc.
     */

    public static ArrayList<Programmer> MakeADevList(List<String> data)  {

        ArrayList<Programmer> devList = new ArrayList<>();
        int i,j;

        for (i = 0; i < data.size(); i++) {

            ArrayList<String> languages = new ArrayList<>();

            for (j = i + 1; j < data.size() && !(data.get(j).contains(":")); j++) {
                languages.add(data.get(j));
            }
                SetOrder(languages);

            devList.add(new Programmer(data.get(i).replace(":",""), languages));
            i = j - 1;
        }

        return devList;
    }

    /**
     * Makes sure that languages are set in correct order - programming languages are at the beginning.
     *
     * @param languages ArrayList<String>> list of languages a developer can write code in
     */

    public static void SetOrder(ArrayList<String> languages)    {

            if (languages.contains("QA"))    {
                Collections.swap(languages, languages.indexOf("QA"), languages.size() - 1);

                if (languages.contains("PM"))
                    Collections.swap(languages, languages.indexOf("PM"), languages.size() - 2);

            }   else if (languages.contains("PM")) {
                Collections.swap(languages, languages.indexOf("PM"), languages.size() - 1);
            }
    }



    /**
     * Writes TXT file with output data
     *
     * @param projectList HashMap<String, ArrayList<String>> projects list with matched programmers
     */

    public static void Write2File(HashMap<String, ArrayList<String>> projectList) {

        try {
            FileWriter filewriter = new FileWriter("Output.txt");
            BufferedWriter writer = new BufferedWriter(filewriter);

            for (String key : projectList.keySet()) {

                writer.write(key + ": " + projectList.get(key));
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
