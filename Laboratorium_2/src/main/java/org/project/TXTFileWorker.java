package org.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class provides functionality for working with TXT files.
 */

public class TXTFileWorker {

    /**
     * Metoda odczytuje plik txt i tworzy z niego tablicę typu String[].
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

}
