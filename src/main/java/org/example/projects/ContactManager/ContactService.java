package org.example.projects.ContactManager;

import java.util.*;

public class ContactService  {
    private Map<String, Contact> contacts = new HashMap<>();

    private String normalizeName(String name) {
        return name.trim().toLowerCase();
    }


    public boolean addContact(Contact c) {
        if (c == null || c.getName() == null || c.getName().isBlank()) {
            return false;
        }
        String name = normalizeName(c.getName());

        if (contacts.containsKey(name)) {
            return false;
        }

        contacts.put(name, c);
        return true;
    }

    public Contact findByName(String name) {
        return contacts.get(normalizeName(name));
    }
    public boolean deleteContact(String name) {
        return contacts.remove(normalizeName(name)) != null;
    }

    public List<Contact> getAllSorted() {
        List<String> names = new ArrayList<>(contacts.keySet());
        Collections.sort(names);

        List<Contact> result = new ArrayList<>();
        for (String name : names) {
            result.add(contacts.get(name));
        }
        return result;
    }

    public List<Contact> getAll(){
        return new ArrayList<>(contacts.values());
    }



}
