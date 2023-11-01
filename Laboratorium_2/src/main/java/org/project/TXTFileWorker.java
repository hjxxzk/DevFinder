package org.project;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * This class provides functionality for working with TXT files.
 */

public class TXTFileWorker {

    /**
     * Reads the TXT file and creates String Array storing data
     *
     * @param filename the name of the TXT file
     * @throws IOException if an I/O error occurs
     */

    public static String[] ReadFile(String filename) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArrayList<String> input = new ArrayList<>();
        String line;

        try {
            while ((line = reader.readLine()) != null) {

                String[] text = line.split("\\s+");
                input.addAll(Arrays.asList(text));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        reader.close();

        return input.toArray(new String[0]);

    }

    /**
     * Writes TXT file with output data
     *
     * @param project_list HashMap<String, ArrayList<String>> projects list with matched programmers
     */

    public static void Write2File(HashMap<String, ArrayList<String>> project_list) {

        try {
            FileWriter filewriter = new FileWriter("output.txt");
            BufferedWriter writer = new BufferedWriter(filewriter);

            for (String key : project_list.keySet()) {

                writer.write(key + ": " + project_list.get(key));
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
