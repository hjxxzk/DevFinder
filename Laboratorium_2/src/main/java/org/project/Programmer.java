package org.project;

import java.util.ArrayList;

public class Programmer {

    public String id;
    public ArrayList<String> roles;
    public boolean leader = false;
    int number_of_projects = 0;

    public Programmer(String id, ArrayList<String> roles)  {

        this.id = id;
        this.roles = roles;

    }


    public boolean CheckIfAvailable() {

        if ((this.number_of_projects == 1 && this.leader) || (this.number_of_projects == 0)) {
            return true;
        } else {
            return false;
        }

    }

    public String SignUpForProject(String role) {

        if (role.equals("QA") || role.equals("PM"))    {
            this.leader = true;
        }

        ++this.number_of_projects;
        return this.id;

    }

}

