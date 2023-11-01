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

        outer:
        for (Programmer dev : devs) {
            inner:
            for (String key : projects.keySet()) {
                ArrayList<String> projectsLanguages = projects.get(key);

                for (String role : dev.roles) { //running loop with programmer's languages for every project to find fitting roles in the same project if possible
                    int index = 0;

                    for (String language : projectsLanguages) {

                        if (dev.CheckIfAvailable(role)) {

                            if (role.equals(language)) {
                                projects.get(key).set(index, dev.SignUpForProject(role));
                                break;
                            }

                        } else {
                            continue outer; //leaving the loop when programmer is already busy and cannot take more projects
                        }
                        ++index;
                    }
                }
            }
        }
    }
}
//if (!projectsLanguages.contains(dev.id))    //searching next project when there wasn't fitting role in the current one
//        continue inner;