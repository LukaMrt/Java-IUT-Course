package com.lukamaret.course.projetTP.seanceTD10.membres;

import com.lukamaret.course.projetTP.seanceTD10.CatalogueBibliotheque;
import com.lukamaret.course.projetTP.seanceTD10.documents.DocBibliotheque;
import com.lukamaret.course.projetTP.seanceTD10.notification.Notifiable;

public class EmployeBibliotheque implements Notifiable {

    private final int employeeId;
    private final String name;
    private final CatalogueBibliotheque catalogue;

    public EmployeBibliotheque(int employeeId, String name, CatalogueBibliotheque catalogue) {
        this.employeeId = employeeId;
        this.name = name;
        this.catalogue = catalogue;
    }

    @Override
    public void docDisponible(DocBibliotheque document) {
        catalogue.remove(document);
    }

}
