package addressbook.io;

import addressbook.model.*;
import java.io.*;

public class JsonIOService {

    public void write(AddressBook book) throws IOException {
        FileWriter writer = new FileWriter(book.getName() + ".json");
        writer.write("[\n");
        for (Contact c : book.getContacts()) {
            writer.write("{\"firstName\":\""+c.getFirstName()+"\",\"lastName\":\""+c.getLastName()+"\",\"phone\":\""+c.getPhone()+"\",\"city\":\""+c.getCity()+"\",\"state\":\""+c.getState()+"\"},\n");
        }
        writer.write("]");
        writer.close();
    }
}
