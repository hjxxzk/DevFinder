package org.project;

import java.util.ArrayList;

/**
 * Class of Programmer
 */

public class Programmer {

    /**
     * Identification of an employee
     */
    public String id;
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
    int number_of_projects = 0;

    public Programmer(String id, ArrayList<String> roles)  {

        this.id = id;
        this.roles = roles;
        for (String e : roles) {
            if (e.equals("QA") || e.equals("PM")) {
                this.leader = true;
                break;
            }
        }
    }

    /**
     * Metoda zwraca prawdę, jeśli programista może pracować nad projektem, ponieważ ma mniej niż 1 projekt
     * lub ma już 1 projekt, ale jest QA lub PM
     *
     * @return Boolean czy programista może wziąć projekt czy nie
     */

    public boolean CheckIfAvailable() {

        return (this.number_of_projects < 2 && this.leader) || (this.number_of_projects < 1);

    }

    /**
     * Metoda zwiększa ilość projektów w obiekcie progrmiatsa i zwraca id progrmaisty
     * @return id do wpisania w listę projektów z dopasowanymi pracownikami
     */

    public String SignUpForProject() {

        ++this.number_of_projects;
        return this.id;

    }

}

