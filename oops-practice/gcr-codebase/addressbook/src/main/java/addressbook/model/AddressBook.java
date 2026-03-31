package addressbook.model;

import java.util.*;

public class AddressBook {

    private String name;
    private List<Contact> contacts = new ArrayList<>();

    public AddressBook(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public List<Contact> getContacts() { return contacts; }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void editContact(String firstName, Contact updated) {
        deleteContact(firstName);
        contacts.add(updated);
    }

    public void deleteContact(String firstName) {
        contacts.removeIf(c -> c.getFirstName().equalsIgnoreCase(firstName));
    }

    public Contact findContact(String firstName) {
        return contacts.stream()
                .filter(c -> c.getFirstName().equalsIgnoreCase(firstName))
                .findFirst()
                .orElse(null);
    }
}
