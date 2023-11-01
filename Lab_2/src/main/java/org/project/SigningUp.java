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
        for(Programmer s : devs){
            String keyDominant = null;



            if(!s.leader){ // not QA and PM simultaneously
                int k=0;
                for(int i=0; i<s.roles.size(); i++){
                    if(k!=0 && (!s.roles.get(i).equals("PM") || !s.roles.get(i).equals("QA")) ) // Situation e.g. PM JAVA QA
                        continue;
                    for(String key : projects.keySet()){
                        int j=0;
                        ArrayList<String> projectsLanguages = projects.get(key);
                        for(String language : projectsLanguages) {
                            if (s.roles.get(i).equals(language)) {

                                if(s.roles.get(i).equals("PM") || s.roles.get(i).equals("QA")){
                                    projects.get(key).set(j, s.id);

                                    if(k==1)
                                        continue outer;

                                    k++;
                                }else{
                                    projects.get(key).set(j, s.id);
                                    continue outer;
                                }
                            }
                            j++;
                        }
                    }
                }


            }else{ // Programmer is a leader (can act as PM and QA)
                for(String key : projects.keySet()){
                    int pm=0, qa=0;
                    ArrayList<String> projectsLanguages = projects.get(key);

                    for(String language : projectsLanguages){
                        if(language.equals("PM"))
                            pm++;
                        if (language.equals("QA"))
                            qa++;
                    }
                    if(pm>=1 && qa>=1){
                        keyDominant = key;
                        break;
                    }
                }
                if(keyDominant == null){
                    int k=0;
                    for(int i=0; i<s.roles.size(); i++){
                        if(k!=0 && (!s.roles.get(i).equals("PM") || !s.roles.get(i).equals("QA")) ) // Situation e.g. PM JAVA QA
                            continue;
                        for(String key : projects.keySet()){
                            int j=0;
                            ArrayList<String> projectsLanguages = projects.get(key);
                            for(String language : projectsLanguages) {
                                if (s.roles.get(i).equals(language)) {
                                    if(s.roles.get(i).equals("PM") || s.roles.get(i).equals("QA")){
                                        projects.get(key).set(j, s.id);
                                        if(k==1)
                                            continue outer;
                                        k++;
                                    }else{
                                        projects.get(key).set(j, s.id);
                                        continue outer;
                                    }
                                }
                                j++;
                            }
                        }
                    }
                }
                int amountPM=0, amountQA=0;
                for(int i=0; i<s.roles.size(); i++){
                    ArrayList<String> projectsLanguages = projects.get(keyDominant);
                    int j=0;
                    for(String languages : projectsLanguages){
                        if(s.roles.get(i).equals(languages)){
                            if(s.roles.get(i).equals("PM") && amountPM == 0){
                                projects.get(keyDominant).set(j, s.id);
                                amountPM++;
                            }
                        }
                        if(s.roles.get(i).equals(languages)){
                            if (s.roles.get(i).equals("QA") && amountQA == 0){
                                projects.get(keyDominant).set(j, s.id);
                                amountQA++;
                            }
                        }
                        j++;
                    }
                }
            }
        }
    }
}
