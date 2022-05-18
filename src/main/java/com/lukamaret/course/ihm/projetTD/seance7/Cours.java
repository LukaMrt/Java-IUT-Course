package com.lukamaret.course.ihm.projetTD.seance7;

import java.io.Serializable;

public class Cours implements Serializable {

    private String codeModule;
    private String numCours;

    public Cours() {
        this.codeModule = "NonSpécifié";
        this.numCours = "0";
    }

    public String getCodeModule() {
        return codeModule;
    }

    public void setCodeModule(String codeModule) {
        this.codeModule = codeModule;
    }

    public String getNumCours() {
        return numCours;
    }

    public void setNumCours(String numCours) {
        this.numCours = numCours;
    }

    @Override
    public String toString() {
        return "Code du module : " + codeModule + " numéro du cours : " + numCours;
    }

}
