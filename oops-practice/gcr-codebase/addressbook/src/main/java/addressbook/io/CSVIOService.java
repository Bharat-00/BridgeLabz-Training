package addressbook.io;

import addressbook.model.*;
import java.io.*;

public class CSVIOService {

    public void write(AddressBook book) throws IOException {
        FileWriter writer = new FileWriter(book.getName() + ".csv");
        for (Contact c : book.getContacts()) {
            writer.write(c.getFirstName()+","+c.getLastName()+","+c.getPhone()+","+c.getCity()+","+c.getState()+"\n");
        }
        writer.close();
    }
}
