package addressbook.dao;

import addressbook.model.AddressBook;
import java.util.*;

public class AddressBookRepository {

    private Map<String, AddressBook> books = new HashMap<>();

    public void createBook(String name) {
        books.putIfAbsent(name, new AddressBook(name));
    }

    public AddressBook getBook(String name) {
        return books.get(name);
    }

    public Collection<AddressBook> getAllBooks() {
        return books.values();
    }
}
