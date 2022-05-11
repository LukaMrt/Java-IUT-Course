package com.lukamaret.course.ihm.projetTP.seance5.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ModeleComboPlayword extends AbstractListModel<String> implements ComboBoxModel<String> {

    private final List<String> elements = new ArrayList<>();
    private String selected;

    public ModeleComboPlayword() {
        selected = "";
    }

    public ModeleComboPlayword(String... elements) {
        this.elements.addAll(List.of(elements));
    }

    public void supprSelectionne() {
        int index = elements.indexOf(selected);
        elements.remove(index);
        selected = elements.isEmpty() ? "" : elements.get(0);
        fireIntervalRemoved(this, index, index);
    }

    public void ajDebutEtSelec(String element) {
        elements.add(0, element);
        selected = element;
        fireIntervalAdded(this, 0, 0);
    }

    public void elimCopies() {
        Stream<String> distinct = elements.stream().distinct();
        int size = elements.size();
        elements.clear();
        fireIntervalRemoved(this, 0, size);
        distinct.forEach(elements::add);
        selected = elements.isEmpty() ? "" : elements.get(0);
        fireIntervalAdded(this, 0, elements.size());
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selected = anItem.toString();
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }

    @Override
    public int getSize() {
        return elements.size();
    }

    @Override
    public String getElementAt(int index) {
        return elements.get(index);
    }

}
