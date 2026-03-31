package addressbook.service;

import addressbook.dao.AddressBookRepository;
import addressbook.model.*;

public class AddressBookService {

    private AddressBookRepository repository = new AddressBookRepository();

    public void createBook(String name) {
        repository.createBook(name);
    }

    public void addContact(String bookName, Contact contact) {
        repository.getBook(bookName).addContact(contact);
    }

    public void editContact(String bookName, String firstName, Contact updated) {
        repository.getBook(bookName).editContact(firstName, updated);
    }

    public void deleteContact(String bookName, String firstName) {
        repository.getBook(bookName).deleteContact(firstName);
    }

    public AddressBook getBook(String name) {
        return repository.getBook(name);
    }
}
