package com.lukamaret.course.projetTP.seanceTD8;

import com.lukamaret.course.projetTP.seanceTD8.membres.MembreBibliotheque;

import java.util.ArrayList;

public class ListeMembres {

    private final ArrayList<MembreBibliotheque> members;

    public ListeMembres() {
        members = new ArrayList<>();
    }

    public boolean addMember(MembreBibliotheque member) {
        boolean result = false;

        if (!members.contains(member)) {
            members.add(member);
            result = true;
        }

        return result;
    }

    public boolean removeMember(MembreBibliotheque member) {
        boolean result = false;

        if (members.contains(member)) {
            members.remove(member);
            result = true;
        }

        return result;
    }

    public MembreBibliotheque getMember(int id) {
        MembreBibliotheque result = null;

        for (MembreBibliotheque member : members) {
            if (member.getMemberId() == id) {
                result = member;
            }
        }

        return result;
    }

    public void displayMembers() {
        for (MembreBibliotheque member : members) {
            System.out.println(member.getMemberId() + " - " + member);
        }


    }

}
