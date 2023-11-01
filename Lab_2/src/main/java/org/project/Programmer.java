package org.project;

import java.util.ArrayList;

/**
 * Class of Programmer
 */

public class Programmer {

    /**
     * Identification of an employee
     */
    public String id;//private
    /**
     * Programming languages they code in and roles they can act as in the project
     */
    public ArrayList<String> roles;
    /**
     * True if employee is a PM or QA; default is false
     */
    public boolean leader = false;
    /**
     * Number of projects the person is involved in
     */

    public Programmer(String id, ArrayList<String> roles)  {
        int i=0;
        this.id = id;
        this.roles = roles;
        for (String e : roles) {
            if (e.equals("QA") || e.equals("PM")) {//!!!!!
                i++;
                if(i>1){
                    this.leader = true; //!!!!!
                    break;
                }
            }
        }
    }

}

