package org.project;

import java.util.ArrayList;

/**
 * Class of Programmer
 */

public class Programmer {

    /**
     * Identification of an employee
     */
    protected String id;
    /**
     * Programming languages they code in and roles they can act as in the project
     */
    protected ArrayList<String> roles;
    /**
     * Number of projects the person is involved in
     */
    private int numberOfProjects = 0;

    public Programmer(String id, ArrayList<String> roles)  {

        this.id = id;
        this.roles = roles;

    }

    /**
     * Returns true when programmer can work on a project, because they aren't already involved in any,
     * or they are involved in project, but are QA or PM
     *
     * @return Boolean informing whether the programmer is already busy
     */

    public boolean CheckIfAvailable(String role) {

        return ((this.numberOfProjects == 1 && (role.equals(Main.Role1) || role.equals(Main.Role2)))
                || (this.numberOfProjects < 1));

    }

    /**
     * Increases number of projects programmer is involved in and returns their id
     *
     * @return id to put in projects list
     */

    public String SignUpForProject() {

        ++this.numberOfProjects;
        return this.id;

    }

}

