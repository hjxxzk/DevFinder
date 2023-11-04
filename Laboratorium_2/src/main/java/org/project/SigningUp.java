package org.project;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class matching programmers to projects
 */

public class SigningUp {

    /**
     * Reads the devs ArrayList and searches for a projects for them in the projects HashMap
     *
     * @param projects HashMap<String, ArrayList<String>> containing previously prepared list of projects
     * @param devs ArrayList<Programmer>> containing previously prepared list of programmers
     */

    public static void FindAProject(HashMap<String, ArrayList<String>> projects, ArrayList<Programmer> devs) {

        for (Programmer dev : devs) {
            outer:
            for (String role : dev.roles) {

                for (String key : projects.keySet()) {
                    ArrayList<String> projectsLanguages = projects.get(key);
                    int index = 0;

                    for (String language : projectsLanguages) {

                        if (dev.CheckIfAvailable(role)) {

                            if (role.equals(language)) {
                                projects.get(key).set(index, dev.SignUpForProject());
                                break;
                            }

                        }  else {
                            continue outer;
                        }
                        ++index;
                    }
                }
            }
        }
    }

}
