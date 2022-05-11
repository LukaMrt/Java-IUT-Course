package com.lukamaret.course.ihm.projetTD.seance5;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModeleCBString extends AbstractListModel<String> implements ComboBoxModel<String> {

    private final List<String> elements = new ArrayList<>();
    private String selected;

    public ModeleCBString() {
        selected = "";
    }

    public ModeleCBString(String... elements) {
        this.elements.addAll(Arrays.asList(elements));
        selected = elements[0];
    }

    public List<String> accesStrings() {
        return elements;
    }

    public void ajoutElement(String element) {
        elements.add(element);
        fireIntervalAdded(this, elements.size() - 1, elements.size() - 1);
        selected = element;
    }

    public void effaceElement(String element) {
        int index = elements.indexOf(element);
        elements.remove(element);
        fireIntervalRemoved(this, index, index);
        selected = elements.isEmpty() ? "" : elements.get(0);
    }

    public void effaceTout() {
        int index = elements.size() - 1;
        elements.clear();
        fireIntervalRemoved(this, 0, index);
        selected = "";
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selected = anItem.toString();
    }

    @Override
    public Object getSelectedItem() {
        return this.selected;
    }

    @Override
    public int getSize() {
        return this.elements.size();
    }

    @Override
    public String getElementAt(int index) {
        return this.elements.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }

}
